package com.headwire.coresites.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public interface Video {

    default String getVideoType() {
        throw new UnsupportedOperationException();
    }

    default void setVideoType(String videoType) {
        throw new UnsupportedOperationException();
    }

    default String getYoutubeId() {
        throw new UnsupportedOperationException();
    }

    default void setYoutubeId(String youtubeId) {
        throw new UnsupportedOperationException();
    }

    default String getVimeoId() {
        throw new UnsupportedOperationException();
    }

    default void setVimeoId(String vimeoId) {
        throw new UnsupportedOperationException();
    }

    default String getDamPath() {
        throw new UnsupportedOperationException();
    }

    default void setDamPath(String damPath) {
        throw new UnsupportedOperationException();
    }

    default String getExternalSource() {
        throw new UnsupportedOperationException();
    }

    default void setExternalSource(String externalSource) {
        throw new UnsupportedOperationException();
    }

    default boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    default void setEmpty(boolean empty) {
        throw new UnsupportedOperationException();
    }
}
