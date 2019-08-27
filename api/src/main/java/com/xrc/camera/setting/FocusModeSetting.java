package com.xrc.camera.setting;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.BaseSettingInfo;
import io.swagger.client.model.FocusMode;
import io.swagger.client.model.FocusModeValue;

public class FocusModeSetting
        extends CameraSettingBase<FocusMode> {

    private final DefaultApi swaggerApi;

    public FocusModeSetting(DefaultApi swaggerApi) {
        this.swaggerApi = swaggerApi;
    }


    @Override
    protected BaseSettingInfo<FocusMode> getSettingInfo() {
        return swaggerApi.settingsFOCUSMODEGet();
    }

    @Override
    protected void setValueCall(FocusMode value) throws ApiException {
        swaggerApi.settingsFOCUSMODEPut(
                new FocusModeValue()
                        .value(value)
        );
    }
}
