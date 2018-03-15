package com.headwire.coresites.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by headwire on 3/14/2018.
 */

@Model(adaptables = Resource.class,
        resourceType = "coresites/components/content/teaser",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Teaser {

    @Inject
    private boolean hideTitle;
    @Inject
    private boolean hideSubtitle;
    @Inject
    private boolean hideText;
    @Inject
    private boolean hideButtons;

    @Inject
    private String alignContent;
    @Inject
    private String alignButtons;
    @Inject
    private String buttonSize;

    private List<Button> buttons;

    @SlingObject
    private Resource resource;

    @PostConstruct
    private void initModel()
    {
        Resource buttonsResource = resource.getChild("buttons");
        if(buttonsResource != null)
        {
            buttons = new ArrayList<>();
            for(Resource buttonChild : buttonsResource.getChildren())
            {
                buttons.add(buttonChild.adaptTo(Button.class));
            }
        }
    }

    public boolean isHideTitle() {
        return hideTitle;
    }

    public boolean isHideSubtitle() {
        return hideSubtitle;
    }

    public boolean isHideText() {
        return hideText;
    }

    public boolean isHideButtons() {
        return hideButtons;
    }

    public String getAlignContent() {
        return alignContent;
    }

    public String getAlignButtons() {
        return alignButtons;
    }

    public String getButtonSize() {
        return buttonSize;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public Resource getResource() {
        return resource;
    }
}
