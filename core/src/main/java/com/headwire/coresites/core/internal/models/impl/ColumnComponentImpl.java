package com.headwire.coresites.core.internal.models.impl;

import com.headwire.coresites.core.models.Column;
import com.headwire.coresites.core.models.ColumnComponent;
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
        adapters = ColumnComponent.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ColumnComponentImpl implements ColumnComponent {

    private static final Logger LOG = LoggerFactory.getLogger(ColumnComponentImpl.class);

    private static final String GRID_TYPE = "coresites/components/structure/unresponsivegrid";

    private List<Column> columns;

    @SlingObject
    private Resource resource;

    @PostConstruct
    private void initModel()
    {
        columns = new ArrayList<>();
        for(Resource child : resource.getChildren())
        {
            if(child.getResourceType() != null && child.getResourceType().equals(GRID_TYPE))
            {
                String resourceName = child.getName();
                ValueMap columnProperties = child.getValueMap();
                String width = columnProperties.get("width", String.class);
                Column column = new ColumnImpl();
                column.setResourceName(resourceName);
                column.setWidthString(width);
                columns.add(column);
            }
        }
    }

    public List<Column> getColumns() {
        return columns;
    }
}
