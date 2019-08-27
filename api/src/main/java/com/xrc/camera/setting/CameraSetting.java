package com.xrc.camera.setting;

import io.swagger.client.model.Setting;

import java.util.List;

public interface CameraSetting<T> {

    T getValue();

    void setValue(T value) throws UnsupportedOperationException;

    /**
     * Retrieves a list of supported values for this setting.
     */
    List<T> getValues();

    boolean isEditable();

    Setting getSetting();
}
