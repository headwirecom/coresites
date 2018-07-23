package com.headwire.coresites.core.internal.models.impl;

import com.headwire.coresites.core.models.Column;
import com.headwire.coresites.core.models.ColumnControl;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Model(adaptables = Resource.class,
        adapters = ColumnControl.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ColumnControlImpl implements ColumnControl {

    private static final Logger LOG = LoggerFactory.getLogger(ColumnControlImpl.class);

    private List<Column> columns;

    @SlingObject
    private Resource resource;

    @PostConstruct
    private void initModel()
    {
        Resource columnsResource = resource.getChild("columns");
        if(columnsResource != null)
        {
            columns = new ArrayList<>();
            int i = 0;
            for(Resource columnChild : columnsResource.getChildren())
            {
                ValueMap columnProperties = columnChild.getValueMap();
                String columnWidth = columnProperties.get("width", String.class);
                if(columnWidth != null && ! columnWidth.isEmpty())
                {
                    String colString = "col-" + columnWidth;
                    String name = "column-" + i;
                    Column column = new ColumnImpl();
                    column.setWidthString(colString);
                    column.setResourceName(name);
                    columns.add(column);
                }
                i++;
            }
        }
    }

    public List<Column> getColumns() {
        return columns;
    }
}
