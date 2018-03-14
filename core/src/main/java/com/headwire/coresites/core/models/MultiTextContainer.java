package com.headwire.coresites.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by headwire on 3/7/2018.
 */

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultiTextContainer {

    private static final Logger LOG = LoggerFactory.getLogger(MultiTextContainer.class);

    private List<MultiTextItem> items;

    private String id;

    @SlingObject
    private Resource resource;

    @PostConstruct
    private void initModel()
    {
        Resource itemResource = resource.getChild("items");
        if(itemResource != null)
        {
            items = new ArrayList<>();
            for(Resource itemChild : itemResource.getChildren())
            {
                items.add(itemChild.adaptTo(MultiTextItem.class));
            }
        }

        id = resource.getName();
    }

    public List<MultiTextItem> getItems() {
        return items;
    }

    public String getId()
    {
        return id;
    }
}
