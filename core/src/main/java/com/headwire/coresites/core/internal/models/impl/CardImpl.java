package com.headwire.coresites.core.internal.models.impl;

import com.headwire.coresites.core.models.Card;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

/**
 * Created by headwire on 3/6/2018.
 */

@Model(adaptables = Resource.class,
        adapters = Card.class,
        resourceType = "coresites/components/content/card",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CardImpl implements Card {

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
