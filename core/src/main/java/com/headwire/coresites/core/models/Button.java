package com.headwire.coresites.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

/**
 * Created by headwire on 3/14/2018.
 */

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Button {

    @Inject
    private String text;

    @Inject
    private String link;

    @Inject
    private String color;

    @Inject
    private String size;

    public String getText() {
        return text;
    }

    public String getLink() {
        return link;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
