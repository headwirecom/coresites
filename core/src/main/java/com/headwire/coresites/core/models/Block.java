package com.headwire.coresites.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Block {

    @Inject
    private String backgroundImagePath;

    @Inject
    private boolean fullWidth;

    @Inject
    private String backgroundType;

    @Inject
    private String backgroundColor;

    @Inject
    private String gradientColor1;

    @Inject
    private String gradientColor2;

    @Inject
    private String topPadding;

    @Inject
    private String bottomPadding;

    @Inject
    private String blockId;

    public String getStyleString()
    {
        String backgroundStyle = generateBackgroundStyle();
        String topPaddingStyle = topPadding == null ? "" : "padding-top: " + topPadding + "px;";
        String bottomPaddingStyle = bottomPadding == null ? "" : "padding-bottom: " + bottomPadding + "px;";

        StringBuilder sb = new StringBuilder();
        sb
        .append(backgroundStyle).append(" ")
        .append(backgroundStyle).append(" ")
        .append(topPaddingStyle).append(" ")
        .append(bottomPaddingStyle);

        return sb.toString();
    }

    private String generateBackgroundStyle()
    {
        if(backgroundType == null || backgroundType.isEmpty() || backgroundType.equals("transparent"))
        {
            return "background-color: transparent;";
        }

        if(backgroundType.equals("color"))
        {
            return "background-color: " + backgroundColor + ";";
        }

        if(backgroundType.equals("gradient"))
        {
            return "background: " + generateGradient() + ";";
        }

        if(backgroundType.equals("image"))
        {
            return "background: url('" + backgroundImagePath + "') center; background-size: cover;";
        }

        return "background-color: transparent;";
    }

    public String getBackgroundImagePath() {
        return backgroundImagePath;
    }

    public boolean isFullWidth() {
        return fullWidth;
    }

    public String getBackgroundType() {
        return backgroundType;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getGradientColor1() {
        return gradientColor1;
    }

    public String getGradientColor2() {
        return gradientColor2;
    }

    private String generateGradient()
    {
        if((gradientColor1 == null || gradientColor1.isEmpty()) &&
                (gradientColor2 == null || gradientColor2.isEmpty()))
        {
            return "transparent";
        }

        if(gradientColor2 == null || gradientColor2.isEmpty())
        {
            return "linear-gradient(" + gradientColor1 + ", transparent)";
        }

        if(gradientColor1 == null || gradientColor1.isEmpty())
        {
            return "linear-gradient(transparent, " + gradientColor2 + ")";
        }

        return "linear-gradient(" + gradientColor1 + ", " + gradientColor2 + ")";
    }

    public String getTopPadding() {
        return topPadding;
    }

    public String getBottomPadding() {
        return bottomPadding;
    }

    public String getBlockId() {
        return blockId;
    }
}
