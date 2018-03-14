package com.headwire.coresites.core.models;

import com.adobe.cq.wcm.core.components.models.ListItem;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.util.Calendar;

/**
 * Created by headwire on 3/8/2018.
 */

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CarouselSlide implements ListItem{

    private static final Logger LOG = LoggerFactory.getLogger(CarouselSlide.class);

    @Inject
    private String url;

    @Inject
    private String title;

    @Inject
    private String description;

    private Calendar lastModified;

    private String path;

    @Inject
    private String imageSrc;

    public CarouselSlide()
    {

    }

    public CarouselSlide(ListItem listItem, ResourceResolver resourceResolver)
    {
        url = listItem.getURL();
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
        LOG.debug("SuperType of '{}': {}", resource.getPath(), superType);

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

    public String getUrl() {
        return url;
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
}
