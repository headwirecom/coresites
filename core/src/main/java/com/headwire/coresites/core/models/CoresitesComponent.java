package com.headwire.coresites.core.models;

public interface CoresitesComponent {

    default String getId() {
        throw new UnsupportedOperationException();
    }
}
