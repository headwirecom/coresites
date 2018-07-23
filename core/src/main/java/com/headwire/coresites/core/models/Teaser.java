package com.headwire.coresites.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public interface Teaser {

    default boolean isHideTitle() {
        throw new UnsupportedOperationException();
    }

    default boolean isHideSubtitle() {
        throw new UnsupportedOperationException();
    }

    default boolean isHideText() {
        throw new UnsupportedOperationException();
    }

    default boolean isHideButtons() {
        throw new UnsupportedOperationException();
    }

    default String getAlignContent() {
        throw new UnsupportedOperationException();
    }

    default String getAlignButtons() {
        throw new UnsupportedOperationException();
    }

    default String getButtonSize() {
        throw new UnsupportedOperationException();
    }

    default List<Button> getButtons() {
        throw new UnsupportedOperationException();
    }

    default Resource getResource() {
        throw new UnsupportedOperationException();
    }
}
