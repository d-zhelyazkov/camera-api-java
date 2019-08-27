package com.xrc.camera.setting;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.AECompensationValue;
import io.swagger.client.model.BaseSettingInfo;

public class AutoExposureCompensationSetting
        extends CameraSettingBase<Float> {

    private final DefaultApi swaggerApi;

    public AutoExposureCompensationSetting(DefaultApi swaggerApi) {
        this.swaggerApi = swaggerApi;
    }

    @Override
    protected BaseSettingInfo<Float> getSettingInfo() {
        return swaggerApi.settingsAECOMPENSATIONGet();
    }

    @Override
    protected void setValueCall(Float value) throws ApiException {
        swaggerApi.settingsAECOMPENSATIONPut(
                new AECompensationValue()
                        .value(value)
        );
    }
}
