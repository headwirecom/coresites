package com.headwire.coresites.core.models;

public interface MultiTextItem {

    default String getTitle() {
        throw new UnsupportedOperationException();
    }

    default String getText() {
        throw new UnsupportedOperationException();
    }
}
