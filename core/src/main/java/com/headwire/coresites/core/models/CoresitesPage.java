package com.headwire.coresites.core.models;

public interface CoresitesPage {

    default String getPrimaryTextColor() {
        throw new UnsupportedOperationException();
    }

    default String getSecondaryTextColor() {
        throw new UnsupportedOperationException();
    }

    default String getPrimaryBackgroundColor() {
        throw new UnsupportedOperationException();
    }

    default String getSecondaryBackgroundColor() {
        throw new UnsupportedOperationException();
    }

    default String getVariableStyleString() {
        throw new UnsupportedOperationException();
    }
}
