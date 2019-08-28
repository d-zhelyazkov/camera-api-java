package com.xrc.camera.test.setting;

import com.xrc.camera.Camera;
import com.xrc.camera.TestFactory;
import com.xrc.camera.setting.AutoExposureCompensationSetting;
import com.xrc.camera.util.ComparableSettingTestHandler;
import com.xrc.camera.util.SettingTestHandler;
import io.swagger.client.model.Setting;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

class AECompensationTest extends CameraSettingTestBase<Float> {

    private static final SettingTestHandler<Float> settingHandler =
            new ComparableSettingTestHandler<>(Setting.AE_COMPENSATION, getAECompensationSetting());

    private static AutoExposureCompensationSetting getAECompensationSetting() {
        Camera camera = TestFactory.getCamera();
        return camera.getAECompensationSetting();
    }

    private static List<Float> getValidValues() {
        AutoExposureCompensationSetting aeCompensationSetting = getAECompensationSetting();
        return aeCompensationSetting.getValues();
    }

    private static List<Float> getInvalidValues() {
        AutoExposureCompensationSetting aeCompensationSetting = getAECompensationSetting();
        List<Float> supportedValues = aeCompensationSetting.getValues();

        return List.of(
                supportedValues.get(0) - 1,
                supportedValues.get(supportedValues.size() - 1) + 1,
                (supportedValues.get(0) + supportedValues.get(1)) / 2,
                Float.MIN_VALUE,
                Float.MAX_VALUE
        );
    }

    AECompensationTest() {
        super(settingHandler);
    }

    @ParameterizedTest
    @MethodSource("getValidValues")
    void testValue(Float value) {
        super.setValue(value);
    }

    @ParameterizedTest
    @MethodSource("getInvalidValues")
    void testInvalidValue(Float value) {
        super.setSettingUnsupported(value);
    }

    @AfterAll
    static void tearDown() {
        settingHandler.restoreInitialValue();
    }
}
