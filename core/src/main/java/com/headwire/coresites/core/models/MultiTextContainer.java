package com.headwire.coresites.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public interface MultiTextContainer {

    default List<MultiTextItem> getItems() {
        throw new UnsupportedOperationException();
    }

    default String getId()
    {
        throw new UnsupportedOperationException();
    }
}
