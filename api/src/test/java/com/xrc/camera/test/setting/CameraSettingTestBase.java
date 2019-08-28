package com.xrc.camera.test.setting;

import com.xrc.camera.util.SettingTestHandler;
import org.junit.jupiter.api.Test;

abstract class CameraSettingTestBase<T> {

    private final SettingTestHandler<T> settingHandler;

    CameraSettingTestBase(SettingTestHandler<T> settingHandler) {
        this.settingHandler = settingHandler;
    }

    @Test
    void testSettingType() {
        settingHandler.verifySettingType();
    }


    @Test
    void checkSettingValue() throws Exception {
        settingHandler.verifySettingValue();
    }

    @Test
    void verifySupportedValues() {
        settingHandler.verifySupportedValues();
    }

    void setValue(T value) {
        settingHandler.setValue(value);
    }

    void setSettingUnsupported(T value) {
        settingHandler.setSettingUnsupported(value);
    }
}
