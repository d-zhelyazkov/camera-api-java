package com.xrc.camera.test.setting;

import com.xrc.camera.Camera;
import com.xrc.camera.TestFactory;
import com.xrc.camera.TestProperties;
import com.xrc.camera.setting.BasicCameraSetting;
import com.xrc.camera.setting.CameraSetting;
import com.xrc.camera.setting.UnsupportedSettingException;
import com.xrc.camera.util.SettingTestHandler;
import com.xrc.lang.Numbers;
import com.xrc.util.Range;
import io.swagger.client.model.Setting;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

class BasicSettingsTest {

    private SettingTestHandler<String> settingHandler;

    private static Collection<Setting> getSupportedSettings() {
        Camera camera = TestFactory.getCamera();
        return camera.getSupportedSettings();
    }

    private static Stream<Arguments> getSettingValues() {
        Camera camera = TestFactory.getCamera();
        Set<Setting> supportedSettings = camera.getSupportedSettings();
        return supportedSettings.stream()
                .flatMap((Setting setting) -> {
                    BasicCameraSetting cameraSetting = camera.getSetting(setting);
                    List<String> values = cameraSetting.getValues();
                    return values.stream()
                            .map((String value) -> Arguments.of(setting, value));
                });
    }

    @ParameterizedTest
    @MethodSource("getSupportedSettings")
    void testSettingType(Setting setting) {
        setupSettingHandler(setting);

        settingHandler.verifySettingType();
    }

    @ParameterizedTest
    @MethodSource("getSupportedSettings")
    void checkSettingValue(Setting setting) {
        setupSettingHandler(setting);

        settingHandler.verifySettingValue();
    }

    @ParameterizedTest
    @MethodSource("getSupportedSettings")
    void verifySupportedValues(Setting setting) {
        setupSettingHandler(setting);

        settingHandler.verifySupportedValues();
    }

    @ParameterizedTest
    @MethodSource("getSettingValues")
    void setSettingValue(Setting setting, String value) {
        try {
            setupSettingHandler(setting);

            settingHandler.setValue(value);
        } finally {
            settingHandler.restoreInitialValue();
        }
    }

    private void setupSettingHandler(Setting setting) throws UnsupportedSettingException {
        Camera camera = TestFactory.getCamera();
        BasicCameraSetting cameraSetting = camera.getSetting(setting);
        settingHandler = new SettingTestHandler<>(setting, cameraSetting);

        if (setting == Setting.ISO) {
            setISOValidator();
            setISOComparator();
        }
    }

    private void setISOValidator() {
        settingHandler.setValueValidator((CameraSetting<String> isoSetting) -> {
            int value = Integer.parseInt(isoSetting.getValue());
            List<String> values = isoSetting.getValues();
            Range<Integer> valuesRange = new Range<>(
                    Integer.parseInt(values.get(0)),
                    Integer.parseInt(values.get(values.size() - 1))
            );
            return valuesRange.isInRange(value);
        });
    }

    private void setISOComparator() {
        settingHandler.setValueComparator((String value1Str, String value2Str) -> {
            int value1 = Integer.parseInt(value1Str);
            int value2 = Integer.parseInt(value2Str);

            TestProperties testProperties = TestFactory.getTestProperties();
            int isoValueMaxError = testProperties.getIsoValueMaxError();
            Comparator<Integer> comparatorWithError =
                    Numbers.getComparatorWithError(isoValueMaxError);

            return comparatorWithError.compare(value1, value2);
        });
    }
}
