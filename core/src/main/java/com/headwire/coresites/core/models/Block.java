package com.headwire.coresites.core.models;

public interface Block {


    default String getStyleString()
    {
        throw new UnsupportedOperationException();
    }

    default String getBackgroundImagePath() {
        throw new UnsupportedOperationException();
    }

    default boolean isFullWidth() {
        throw new UnsupportedOperationException();
    }

    default String getBackgroundType() {
        throw new UnsupportedOperationException();
    }

    default String getBackgroundColor() {
        throw new UnsupportedOperationException();
    }

    default String getGradientColor1() {
        throw new UnsupportedOperationException();
    }

    default String getGradientColor2() {
        throw new UnsupportedOperationException();
    }

    default String getTopPadding() {
        throw new UnsupportedOperationException();
    }

    default String getBottomPadding() {
        throw new UnsupportedOperationException();
    }

    default String getBlockId() {
        throw new UnsupportedOperationException();
    }
}
