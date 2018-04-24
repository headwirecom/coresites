package com.headwire.coresites.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CoresitesComponent {

    @Self
    private Resource resource;

    private String id;

    @PostConstruct
    protected void initModel()
    {
        id = resource.getName();
    }

    public String getId() {
        return id;
    }
}
