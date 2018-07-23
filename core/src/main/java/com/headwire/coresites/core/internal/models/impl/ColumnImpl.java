package com.headwire.coresites.core.internal.models.impl;

import com.headwire.coresites.core.models.Column;

public class ColumnImpl implements Column
{
    private String widthString;
    private String resourceName;

    public String getWidthString() {
        return widthString;
    }

    public void setWidthString(String widthString) {
        this.widthString = widthString;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}