package com.headwire.coresites.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class InPageNavigation {

    @SlingObject
    private Resource resource;

    private String id;

    private static final Logger LOG = LoggerFactory.getLogger(InPageNavigation.class);

    private List<Anchor> anchors;

    private boolean empty = true;

    @PostConstruct
    private void initModel()
    {
        Resource anchorsResource = resource.getChild("anchors");
        if(anchorsResource != null)
        {
            anchors = new ArrayList<>();
            for(Resource anchorChild : anchorsResource.getChildren())
            {
                anchors.add(anchorChild.adaptTo(Anchor.class));
            }
            empty = anchors.isEmpty();
        }
        id = resource.getName();
    }

    public String getId() {
        return id;
    }

    public List<Anchor> getAnchors() {
        return anchors;
    }

    public boolean isEmpty() {
        return empty;
    }
}