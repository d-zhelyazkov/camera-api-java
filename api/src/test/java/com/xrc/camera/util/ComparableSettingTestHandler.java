package com.xrc.camera.util;

import com.xrc.camera.setting.CameraSetting;
import com.xrc.util.Collections;
import io.swagger.client.model.Setting;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;
import java.util.List;

public class ComparableSettingTestHandler<T extends Comparable<? super T>>
        extends SettingTestHandler<T> {

    public ComparableSettingTestHandler(Setting setting, CameraSetting<T> cameraSetting) {
        super(setting, cameraSetting);

        setValueComparator(Comparator.naturalOrder());
    }

    @Override
    public void verifySupportedValues() {
        super.verifySupportedValues();

        List<T> supportedValues = cameraSetting.getValues();
        Assertions.assertTrue(
                Collections.isOrdered(supportedValues),
                String.format(
                        "%s supported values not ordered: %s",
                        setting, supportedValues)
        );
    }
}
