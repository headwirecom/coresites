package com.headwire.coresites.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

/**
 * Created by headwire on 3/6/2018.
 */

@Model(adaptables = Resource.class,
        resourceType = "coresites/components/content/card",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Card {

    @Inject
    private String buttonLinkTo;

    @Inject
    private String buttonLabel;

    public String getButtonLinkTo() {
        return buttonLinkTo;
    }


    public String getButtonLabel() {
        return buttonLabel;
    }

}
