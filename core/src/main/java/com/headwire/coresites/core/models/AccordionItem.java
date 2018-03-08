package com.headwire.coresites.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

/**
 * Created by headwire on 3/7/2018.
 */

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AccordionItem {

    @Inject
    private String title;

    @Inject
    private String text;

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
