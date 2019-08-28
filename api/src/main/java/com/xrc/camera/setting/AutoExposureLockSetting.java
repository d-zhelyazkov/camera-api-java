package com.xrc.camera.setting;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.AELockValue;
import io.swagger.client.model.BaseSettingInfo;

public class AutoExposureLockSetting
        extends CameraSettingBase<Boolean> {

    private final DefaultApi swaggerApi;

    public AutoExposureLockSetting(DefaultApi swaggerApi) {
        this.swaggerApi = swaggerApi;
    }

    @Override
    protected BaseSettingInfo<Boolean> getSettingInfo() {
        return swaggerApi.settingsAELOCKGet();
    }

    @Override
    protected void setValueCall(Boolean value) throws ApiException {
        swaggerApi.settingsAELOCKPut(
                new AELockValue()
                        .value(value)
        );
    }
}
