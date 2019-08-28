package com.xrc.camera.test.setting;

import com.xrc.camera.Camera;
import com.xrc.camera.TestFactory;
import com.xrc.camera.setting.AutoExposureLockSetting;
import com.xrc.camera.setting.UnsupportedSettingException;
import com.xrc.camera.util.SettingTestHandler;
import io.swagger.client.model.Setting;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

class AELockTest extends CameraSettingTestBase<Boolean> {

    private static final SettingTestHandler<Boolean> settingHandler =
            new SettingTestHandler<>(Setting.AE_LOCK, getAELockSetting());

    private static AutoExposureLockSetting getAELockSetting() throws UnsupportedSettingException {
        Camera camera = TestFactory.getCamera();
        return camera.getAELockSetting();
    }

    private static List<Boolean> getValues() throws UnsupportedSettingException {
        AutoExposureLockSetting aeLockSetting = getAELockSetting();
        return aeLockSetting.getValues();
    }

    AELockTest() throws UnsupportedSettingException {
        super(settingHandler);
    }

    @ParameterizedTest
    @MethodSource("getValues")
    void setValue(Boolean value) {
        super.setValue(value);
    }

    @AfterAll
    static void tearDown() {
        settingHandler.restoreInitialValue();
    }
}
