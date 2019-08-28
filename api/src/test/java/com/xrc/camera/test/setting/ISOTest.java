package com.xrc.camera.test.setting;

import com.xrc.camera.Camera;
import com.xrc.camera.TestFactory;
import com.xrc.camera.TestProperties;
import com.xrc.camera.setting.ISOSetting;
import com.xrc.camera.setting.UnsupportedSettingException;
import com.xrc.camera.util.ComparableSettingTestHandler;
import com.xrc.camera.util.SettingTestHandler;
import com.xrc.lang.Numbers;
import com.xrc.util.Range;
import io.swagger.client.model.Setting;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

class ISOTest extends CameraSettingTestBase<Integer> {

    private static final int RANDOM_VALUES = 10;

    private static final SettingTestHandler<Integer> settingHandler =
            new ComparableSettingTestHandler<>(Setting.ISO, getISOSetting());

    private static ISOSetting getISOSetting() throws UnsupportedSettingException {
        Camera camera = TestFactory.getCamera();
        return camera.getISOSetting();
    }

    private static Stream<Integer> getValidValues() throws UnsupportedSettingException {
        ISOSetting isoSetting = getISOSetting();
        Range<Integer> valuesRange = isoSetting.getValuesRange();
        int minValue = valuesRange.getLowerBound();
        int maxValue = valuesRange.getHigherBound();
        int maxAnalogValue = isoSetting.getMaxAnalogValue();

        Random random = new Random();
        return Stream.concat(
                Stream.of(minValue, maxAnalogValue, maxValue),
                Stream.generate(() ->
                        random.nextInt(maxValue - minValue) + minValue
                )
                        .limit(RANDOM_VALUES)
        );
    }

    private static Stream<Integer> getInvalidValues() throws UnsupportedSettingException {
        ISOSetting isoSetting = getISOSetting();
        Range<Integer> valuesRange = isoSetting.getValuesRange();
        return Stream.of(
                valuesRange.getLowerBound() - 1,
                valuesRange.getHigherBound() + 1,
                0
        );
    }

    ISOTest() throws UnsupportedSettingException {
        super(settingHandler);

        TestProperties testProperties = TestFactory.getTestProperties();
        int isoValueMaxError = testProperties.getIsoValueMaxError();
        Comparator<Integer> comparatorWithError =
                Numbers.getComparatorWithError(isoValueMaxError);
        settingHandler.setValueComparator(comparatorWithError);
    }

    @Test
    @Override
    void checkSettingValue() throws UnsupportedSettingException {
        ISOSetting isoSetting = getISOSetting();

        Integer value = isoSetting.getValue();
        Assertions.assertNotNull(value);
        System.out.println("value: " + value);

        Range<Integer> valuesRange = isoSetting.getValuesRange();
        System.out.println("range: " + valuesRange);
        Assertions.assertTrue(valuesRange.isInRange(value));

    }

    @ParameterizedTest
    @MethodSource("getValidValues")
    void setValidValue(int value) {
        super.setValue(value);
    }

    @ParameterizedTest
    @MethodSource("getInvalidValues")
    void setInvalidValue(int value) {
        super.setSettingUnsupported(value);
    }

    @AfterAll
    static void tearDown() {
        settingHandler.restoreInitialValue();
    }
}
