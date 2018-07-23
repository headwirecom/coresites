package com.headwire.coresites.core.models;

import java.util.List;

public interface InPageNavigation {

    default String getId() {
        throw new UnsupportedOperationException();
    }

    default List<Anchor> getAnchors() {
        throw new UnsupportedOperationException();
    }

    default boolean isEmpty() {
        throw new UnsupportedOperationException();
    }
}
