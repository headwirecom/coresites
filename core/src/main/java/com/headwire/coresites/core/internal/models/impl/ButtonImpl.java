package com.headwire.coresites.core.internal.models.impl;

import com.headwire.coresites.core.models.Button;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

/**
 * Created by headwire on 3/14/2018.
 */

@Model(adaptables = Resource.class,
        adapters = Button.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ButtonImpl implements Button {

    @Inject
    private String text;

    @Inject
    private String link;

    @Inject
    private String id;

    public String getText() {
        return text;
    }

    public String getLink() {
        return link;
    }

    public String getId() {
        return id;
    }
}
