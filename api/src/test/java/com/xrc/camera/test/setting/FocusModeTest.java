package com.xrc.camera.test.setting;

import com.xrc.camera.Camera;
import com.xrc.camera.TestFactory;
import com.xrc.camera.setting.FocusModeSetting;
import com.xrc.camera.util.SettingTestHandler;
import com.xrc.util.Collections;
import io.swagger.client.model.FocusMode;
import io.swagger.client.model.Setting;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.List;

class FocusModeTest extends CameraSettingTestBase<FocusMode> {

    private static final SettingTestHandler<FocusMode> settingHandler =
            new SettingTestHandler<>(Setting.FOCUS_MODE, getFocusModeSetting());

    private static FocusModeSetting getFocusModeSetting() {
        Camera camera = TestFactory.getCamera();
        return camera.getFocusModeSetting();
    }

    private static List<FocusMode> getValidValues() {
        FocusModeSetting focusModeSetting = getFocusModeSetting();
        return focusModeSetting.getValues();
    }

    private static Collection<FocusMode> getInvalidValues() {
        FocusModeSetting focusModeSetting = getFocusModeSetting();
        List<FocusMode> supportedValues = focusModeSetting.getValues();
        return Collections.difference(
                FocusMode.values(),
                supportedValues
        );
    }

    FocusModeTest() {
        super(settingHandler);
    }

    @ParameterizedTest
    @MethodSource("getValidValues")
    void testValidValueSet(FocusMode value) {
        super.setValue(value);
    }

    @ParameterizedTest
    @MethodSource("getInvalidValues")
    void testInvalidValueSet(FocusMode value) {
        super.setSettingUnsupported(value);
    }

    @AfterAll
    static void tearDown() {
        settingHandler.restoreInitialValue();
    }
}
