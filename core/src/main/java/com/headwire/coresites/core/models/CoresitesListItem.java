package com.headwire.coresites.core.models;

import com.adobe.cq.wcm.core.components.models.ListItem;
import org.apache.sling.api.SlingHttpServletRequest;

public interface CoresitesListItem extends ListItem{
    default void updateURL(SlingHttpServletRequest request)
    {
        throw new UnsupportedOperationException();
    }
}
