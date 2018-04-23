package com.headwire.coresites.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Anchor {

    @Inject
    private String text;

    @Inject
    private String href;

    public String getText() {
        return text;
    }

    public String getHref() {
        return href;
    }
}
