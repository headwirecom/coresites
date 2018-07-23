package com.headwire.coresites.core.models;

public interface Button {

    default String getText() {
        throw new UnsupportedOperationException();
    }

    default String getLink() {
        throw new UnsupportedOperationException();
    }

    default String getId() {
        throw new UnsupportedOperationException();
    }
}
