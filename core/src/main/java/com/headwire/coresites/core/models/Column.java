package com.headwire.coresites.core.models;

public interface Column
{

    default String getWidthString() {
        throw new UnsupportedOperationException();
    }

    default void setWidthString(String widthString) {
        throw new UnsupportedOperationException();
    }

    default String getResourceName() {
        throw new UnsupportedOperationException();
    }

    default void setResourceName(String resourceName) {
        throw new UnsupportedOperationException();
    }
}