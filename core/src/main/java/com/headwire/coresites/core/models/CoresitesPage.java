package com.headwire.coresites.core.models;

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
public class CoresitesPage {

    private static final Logger LOG = LoggerFactory.getLogger(CoresitesPage.class);

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