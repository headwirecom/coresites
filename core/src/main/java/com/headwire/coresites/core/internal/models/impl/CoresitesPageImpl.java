package com.headwire.coresites.core.internal.models.impl;

import com.day.cq.commons.inherit.HierarchyNodeInheritanceValueMap;
import com.day.cq.commons.inherit.InheritanceValueMap;
import com.headwire.coresites.core.models.CoresitesPage;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = CoresitesPage.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CoresitesPageImpl implements CoresitesPage {

    private static final Logger LOG = LoggerFactory.getLogger(CoresitesPageImpl.class);

    @Self
    private Resource resource;

    @Inject
    private String primaryTextColor;

    @Inject
    private String secondaryTextColor;

    @Inject
    private String primaryBackgroundColor;

    @Inject
    private String secondaryBackgroundColor;

    private String variableStyleString;

    @PostConstruct
    protected void initModel()
    {
        LOG.debug("Initializing model for {}", resource.getPath());
        initColors();


        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\t:root {\n");
        if(primaryTextColor != null && !primaryTextColor.isEmpty())
        {
            stringBuilder.append("\t\t--primary-text-color: ").append(primaryTextColor).append(";\n");
        }

        if(secondaryTextColor != null && !secondaryTextColor.isEmpty())
        {
            stringBuilder.append("\t\t--secondary-text-color: ").append(secondaryTextColor).append(";\n");
        }

        if(primaryBackgroundColor != null && !primaryBackgroundColor.isEmpty())
        {
            stringBuilder.append("\t\t--primary-background-color: ").append(primaryBackgroundColor).append(";\n");
        }

        if(secondaryBackgroundColor != null && !secondaryBackgroundColor.isEmpty())
        {
            stringBuilder.append("\t\t--secondary-background-color: ").append(secondaryBackgroundColor).append(";\n");
        }

        stringBuilder.append("\t}");

        variableStyleString = stringBuilder.toString();
    }

    private void initColors()
    {
        InheritanceValueMap inheritedProperties = new HierarchyNodeInheritanceValueMap(resource);
        if(primaryTextColor == null)
        {
            primaryTextColor = inheritedProperties.getInherited("primaryTextColor", String.class);
            LOG.debug("Setting primaryTextColor to {}", primaryTextColor);
        }
        if(secondaryTextColor == null)
        {
            secondaryTextColor = inheritedProperties.getInherited("secondaryTextColor", String.class);
            LOG.debug("Setting secondaryTextColor to {}", secondaryTextColor);
        }
        if(primaryBackgroundColor == null)
        {
            primaryBackgroundColor = inheritedProperties.getInherited("primaryBackgroundColor", String.class);
            LOG.debug("Setting primaryBackgroundColor to {}", primaryBackgroundColor);
        }
        if(secondaryBackgroundColor == null)
        {
            secondaryBackgroundColor = inheritedProperties.getInherited("secondaryBackgroundColor", String.class);
            LOG.debug("Setting secondaryBackgroundColor to {}", secondaryBackgroundColor);
        }
    }


    public String getPrimaryTextColor() {
        return primaryTextColor;
    }

    public String getSecondaryTextColor() {
        return secondaryTextColor;
    }

    public String getPrimaryBackgroundColor() {
        return primaryBackgroundColor;
    }

    public String getSecondaryBackgroundColor() {
        return secondaryBackgroundColor;
    }

    public String getVariableStyleString() {
        return variableStyleString;
    }
}
