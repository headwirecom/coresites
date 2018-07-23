package com.headwire.coresites.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public interface Anchor {

    default String getText() {
        throw new UnsupportedOperationException();
    }

    default String getHref() {
        throw new UnsupportedOperationException();
    }
}
