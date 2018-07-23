package com.headwire.coresites.core.internal.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.List;
import com.adobe.cq.wcm.core.components.models.ListItem;
import com.headwire.coresites.core.models.CoresitesList;
import com.headwire.coresites.core.models.CoresitesListItem;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.via.ResourceSuperType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by headwire on 3/8/2018.
 */

@Model(adaptables = SlingHttpServletRequest.class, adapters = {CoresitesList.class, ComponentExporter.class}, resourceType = CoresitesListImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class CoresitesListImpl implements CoresitesList {
    private static final Logger LOG = LoggerFactory.getLogger(CoresitesListImpl.class);

    protected static final String RESOURCE_TYPE = "coresites/components/content/list";

    @Self
    private SlingHttpServletRequest request;

    @Self
    @Via(type = ResourceSuperType.class)
    private List delegate;

    @ScriptVariable
    private ValueMap properties;

    @ScriptVariable
    private Resource resource;

    @SlingObject
    private ResourceResolver resourceResolver;

    @Override
    public Collection<ListItem> getListItems()
    {
        String listFrom = properties.get("listFrom", String.class);
        Collection<ListItem> listItems = new ArrayList<>();
        if(listFrom != null && listFrom.equals("fields"))
        {
            Resource slidesRoot = resource.getChild("slides");
            if(slidesRoot != null)
            {
                for(Resource slide : slidesRoot.getChildren())
                {
                    CoresitesListItem listItem = slide.adaptTo(CoresitesListItem.class);
                    listItem.updateURL(request);
                    listItems.add(listItem);
                }
            }
        }
        else
        {
            for(ListItem listItem : delegate.getListItems())
            {
                if(listItem != null)
                {
                    listItems.add(new CoresitesListItemImpl(listItem, resourceResolver));
                }
            }
        }
        return listItems;
    }

    @Override
    public boolean linkItems() {
        return delegate.linkItems();
    }

    @Override
    public boolean showDescription() {
        return delegate.showDescription();
    }

    @Override
    public boolean showModificationDate() {
        return delegate.showModificationDate();
    }

    @Override
    public String getDateFormatString() {
        return delegate.getDateFormatString();
    }

    @Override
    public String getExportedType() {
        return delegate.getExportedType();
    }

}
