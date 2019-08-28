package com.xrc.camera.util;

import com.xrc.camera.setting.CameraSetting;
import com.xrc.util.Comparator;
import io.swagger.client.model.Setting;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class SettingTestHandler<T> {

    protected final Setting setting;

    protected final CameraSetting<T> cameraSetting;

    private final T initialValue;

    private boolean valueChanged = false;

    private Predicate<CameraSetting<T>> valueValidator = (CameraSetting<T> cameraSetting) -> {

        List<T> supportedValues = cameraSetting.getValues();
        T value = cameraSetting.getValue();
        return supportedValues.contains(value);
    };

    private Comparator<T> valueComparator = new Comparator<>((T o1, T o2) ->
            (Objects.equals(o1, o2)) ? 0 : 1);

    public SettingTestHandler(Setting setting, CameraSetting<T> cameraSetting) {
        this.setting = setting;
        this.cameraSetting = cameraSetting;
        this.initialValue = cameraSetting.getValue();
    }

    public void verifySettingType() {
        Assertions.assertEquals(setting, cameraSetting.getSetting());
    }

    public void verifySettingValue() {
        T value = cameraSetting.getValue();
        Assertions.assertNotNull(value);

        Assertions.assertTrue(valueValidator.test(cameraSetting));
    }

    public void verifySupportedValues() {
        List<T> supportedValues = cameraSetting.getValues();
        Assertions.assertNotNull(supportedValues);
        Assertions.assertFalse(supportedValues.isEmpty());

        long distinctValues = supportedValues.stream()
                .distinct()
                .count();
        Assertions.assertEquals(distinctValues, supportedValues.size());
    }

    public void setValue(T value) {
        boolean editable = cameraSetting.isEditable();
        if (editable) {
            valueChanged = true;
            cameraSetting.setValue(value);
            checkValue(value, cameraSetting.getValue());
        } else {
            setSettingUnsupported(value);
        }
    }

    public void setSettingUnsupported(T value) {
        T currentValue = cameraSetting.getValue();
        try {
            cameraSetting.setValue(value);
            Assertions.fail("Successfully set unsupported setting.");
        } catch (UnsupportedOperationException e) {
            checkValue(currentValue, cameraSetting.getValue());
        }
    }

    public void restoreInitialValue() {
        if (valueChanged)
            setValue(initialValue);
    }

    public void setValueValidator(Predicate<CameraSetting<T>> valueValidator) {
        this.valueValidator = valueValidator;
    }

    public void setValueComparator(java.util.Comparator<T> valueComparator) {
        this.valueComparator = new Comparator<>(valueComparator);
    }

    private void checkValue(T expected, T actual) {
        Assertions.assertTrue(valueComparator.equal(expected, actual),
                String.format(
                        "Value not correct. Expected %s, got %s.",
                        expected, actual));

    }
}
