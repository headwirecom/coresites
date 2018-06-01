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
    private String videoType;

    @Inject
    private String youtubeId;

    @Inject
    private String vimeoId;

    @Inject
    private String damPath;

    @Inject
    private String externalSource;

    private boolean empty;

    @PostConstruct
    protected void initEmpty()
    {
        empty = (vimeoId == null || vimeoId.isEmpty())
                && (youtubeId == null || youtubeId.isEmpty())
                && (damPath == null || damPath.isEmpty())
                && (youtubeId == null || youtubeId.isEmpty())
                && (externalSource == null || externalSource.isEmpty());
    }


    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public String getVimeoId() {
        return vimeoId;
    }

    public void setVimeoId(String vimeoId) {
        this.vimeoId = vimeoId;
    }

    public String getDamPath() {
        return damPath;
    }

    public void setDamPath(String damPath) {
        this.damPath = damPath;
    }

    public String getExternalSource() {
        return externalSource;
    }

    public void setExternalSource(String externalSource) {
        this.externalSource = externalSource;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}
