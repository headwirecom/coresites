package com.headwire.coresites.core.internal.models.impl;

import com.headwire.coresites.core.models.Accordion;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

/**
 * Created by headwire on 3/14/2018.
 */

@Model(adaptables = Resource.class,
        adapters = Accordion.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AccordionImpl extends MultiTextContainerImpl implements Accordion {

    @Inject
    private boolean toggle;

    public boolean isToggle() {
        return toggle;
    }
}
