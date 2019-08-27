package com.xrc.camera.setting;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.BaseSettingInfo;
import io.swagger.client.model.Setting;
import io.swagger.client.model.SettingValue;

public class BasicCameraSetting
        extends CameraSettingBase<String> {

    private final DefaultApi swaggerApi;

    private final Setting setting;

    public BasicCameraSetting(DefaultApi swaggerApi, Setting setting) {
        this.swaggerApi = swaggerApi;
        this.setting = setting;
    }

    @Override
    protected BaseSettingInfo<String> getSettingInfo() {
        return swaggerApi.settingsSettingGet(setting);
    }

    @Override
    protected void setValueCall(String value) throws ApiException {
        swaggerApi.settingsSettingPut(
                setting,
                new SettingValue()
                        .value(value)
        );
    }
}
