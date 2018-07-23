package com.headwire.coresites.core.models;

public interface Card {


    default String getButtonLinkTo() {
        throw new UnsupportedOperationException();
    }


    default String getButtonLabel() {
        throw new UnsupportedOperationException();
    }

}
