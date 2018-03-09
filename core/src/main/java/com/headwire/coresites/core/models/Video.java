package com.headwire.coresites.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by headwire on 3/8/2018.
 */

@Model(adaptables = Resource.class,
        resourceType = "coresites/components/content/video",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Video {
    private static final Logger LOG = LoggerFactory.getLogger(Video.class);

    @Inject
    private String source;

    private boolean external;

    @PostConstruct
    private void initModel()
    {
        LOG.debug("Setting external");
        if(source != null && !source.isEmpty() && !source.startsWith("/"))
        {
            external = true;
            LOG.debug("Setting external to true: {}", external);
        }
        else
        {
            external = false;
            LOG.debug("Setting external to false: {}", external);
        }
    }

    public String getSource() {
        return source;
    }

    public boolean isExternal() {
        LOG.debug("Returning external: {}", external);
        return external;
    }
}
