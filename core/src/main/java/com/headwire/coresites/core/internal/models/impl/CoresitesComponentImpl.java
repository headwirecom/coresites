package com.headwire.coresites.core.internal.models.impl;

import com.headwire.coresites.core.models.CoresitesComponent;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class,
        adapters = CoresitesComponent.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CoresitesComponentImpl implements CoresitesComponent{

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
