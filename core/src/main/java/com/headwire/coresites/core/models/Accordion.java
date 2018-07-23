package com.headwire.coresites.core.models;

public interface Accordion extends MultiTextContainer{

    default boolean isToggle() { throw new UnsupportedOperationException(); }
}
