package com.headwire.coresites.core.models;

import java.util.List;

public interface ColumnControl {

    default List<Column> getColumns() {
        throw new UnsupportedOperationException();
    }
}
