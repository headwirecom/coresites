package com.headwire.coresites.core.internal.models.impl;

import com.adobe.cq.wcm.core.components.models.ListItem;
import com.day.cq.wcm.api.Page;
import com.headwire.coresites.core.models.CoresitesListItem;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import java.util.Calendar;

/**
 * Created by headwire on 3/8/2018.
 */

@Model(adaptables = Resource.class,
        adapters = CoresitesListItem.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CoresitesListItemImpl implements CoresitesListItem{

    private static final Logger LOG = LoggerFactory.getLogger(CoresitesListItemImpl.class);

    private String URL;

    @Inject
    private String title;

    @Inject
    private String description;

    private Calendar lastModified;

    @Inject
    private String path;

    @Inject
    private String imageSrc;

    public CoresitesListItemImpl()
    {

    }

    public CoresitesListItemImpl(ListItem listItem, ResourceResolver resourceResolver)
    {
        URL = listItem.getURL();
        title = listItem.getTitle();
        description = listItem.getDescription();
        lastModified = listItem.getLastModified();
        path = listItem.getPath();
        imageSrc = findImagePath(path, resourceResolver);
    }

    private String findImagePath(String path, ResourceResolver resourceResolver)
    {
        Resource pageResource = resourceResolver.getResource(path);
        if(pageResource == null)
        {
            return null;
        }

        return findImagePathHelper(pageResource);
    }

    private String findImagePathHelper(Resource resource)
    {
        if(resource == null)
        {
            return null;
        }

        String superType = resource.getResourceResolver().getParentResourceType(resource);
        LOG.trace("SuperType of '{}': {}", resource.getPath(), superType);

        if(superType != null && superType.contains("image"))
        {
            ValueMap properties = resource.getValueMap();
            String fileReference = properties.get("fileReference", String.class);
            if(fileReference != null && !fileReference.isEmpty())
            {
                return fileReference;
            }
        }

        for(Resource child : resource.getChildren())
        {
            String imagePath = findImagePathHelper(child);
            if(imagePath != null)
            {
                return imagePath;
            }
        }
        return null;
    }

    public void updateURL(SlingHttpServletRequest request)
    {
        if(path == null || path.isEmpty())
        {
            return;
        }

        if(!path.startsWith("/"))
        {
            URL = path;
            return;
        }

        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource resource = resourceResolver.getResource(path);
        if(resource == null)
        {
            return;
        }
        Page page = resource.adaptTo(Page.class);
        if(page == null)
        {
            return;
        }
        URL = getURL(request, page);
    }

    @Nullable
    @Override
    public String getURL() {
        return URL;
    }

    @Nullable
    @Override
    public String getTitle() {
        return title;
    }

    @Nullable
    @Override
    public String getDescription() {
        return description;
    }

    @Nullable
    @Override
    public Calendar getLastModified() {
        return lastModified;
    }

    @Nullable
    @Override
    public String getPath() {
        return path;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    private String getURL(@Nonnull SlingHttpServletRequest request, @Nonnull Page page) {
        String vanityURL = page.getVanityUrl();
        return StringUtils.isEmpty(vanityURL) ? request.getContextPath() + page.getPath() + ".html" : request.getContextPath() + vanityURL;
    }
}
