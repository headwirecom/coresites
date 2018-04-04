package com.headwire.coresites.core.models;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class VectorGraphic {

    private static final Logger LOG = LoggerFactory.getLogger(VectorGraphic.class);

    @Self
    private Resource resource;

    @Inject
    private String fileReference;

    private String src;

    @PostConstruct
    protected void initModel()
    {
        LOG.debug("Initializing vector graphic");
        if(StringUtils.isNotEmpty(fileReference))
        {
            Resource assetResource = resource.getResourceResolver().getResource(fileReference);
            if(assetResource != null)
            {
                Asset asset = assetResource.adaptTo(Asset.class);
                if(asset != null)
                {
                    Rendition original = asset.getRendition("original");
                    if(original != null)
                    {
                        String originalPath = original.getPath();
                        src = originalPath;
                    }
                }
            }
        }
        else
        {
            LOG.debug("Empty fileReference");
        }

        //TODO: Add logic for uploaded files and metadata
    }

    public String getSrc() {
        return src;
    }
}
