package com.xrc.camera.setting;

import io.swagger.client.ApiException;
import io.swagger.client.model.BaseSettingInfo;
import io.swagger.client.model.Setting;

import java.net.HttpURLConnection;
import java.util.List;

public abstract class CameraSettingBase<T> implements CameraSetting<T> {

    @Override
    public T getValue() {
        BaseSettingInfo<T> settingInfo = getSettingInfo();
        return settingInfo.getValue();
    }

    @Override
    public void setValue(T value) throws UnsupportedOperationException {
        try {
            setValueCall(value);
        } catch (ApiException e) {
            int httpCode = e.getCode();
            if (httpCode == HttpURLConnection.HTTP_BAD_REQUEST) {
                throw new UnsupportedOperationException(e);
            }
            throw e;
        }
    }

    @Override
    public List<T> getValues() {
        BaseSettingInfo<T> settingInfo = getSettingInfo();
        return settingInfo.getValues();
    }

    @Override
    public boolean isEditable() {
        BaseSettingInfo<T> settingInfo = getSettingInfo();
        return settingInfo.isEditable();
    }

    @Override
    public Setting getSetting() {
        BaseSettingInfo<T> settingInfo = getSettingInfo();
        return settingInfo.getSetting();
    }

    @Override
    public String toString() {
        BaseSettingInfo<T> settingInfo = getSettingInfo();
        return settingInfo.toString();
    }

    protected abstract BaseSettingInfo<T> getSettingInfo();

    protected abstract void setValueCall(T value) throws ApiException;

}
