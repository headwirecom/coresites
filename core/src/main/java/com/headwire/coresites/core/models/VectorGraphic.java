package com.headwire.coresites.core.models;

public interface VectorGraphic {

    default String getSrc() {
        throw new UnsupportedOperationException();
    }

    default String getWidth() {
        throw new UnsupportedOperationException();
    }

    default String getHeight() {
        throw new UnsupportedOperationException();
    }
}
