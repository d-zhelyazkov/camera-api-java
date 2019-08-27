package com.xrc.camera.setting;

import com.xrc.util.Range;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.ISOInfo;
import io.swagger.client.model.ISOValue;

import java.util.List;

/**
 * Camera sensitivity (ISO) setting.
 * <p>
 * Method {@link ISOSetting#getValues()} returns a list with 3 values:
 * min ISO value, max analog ISO value and max ISO value.
 * Refer to methods {@link ISOSetting#getValuesRange()} and {@link ISOSetting#getMaxAnalogValue()}
 */
public class ISOSetting extends CameraSettingBase<Integer> {

    private final DefaultApi swaggerApi;

    public ISOSetting(DefaultApi swaggerApi) {
        this.swaggerApi = swaggerApi;
    }

    @Override
    protected ISOInfo getSettingInfo() {
        return swaggerApi.settingsISOGet();
    }

    @Override
    protected void setValueCall(Integer value) throws ApiException {
        swaggerApi.settingsISOPut(
                new ISOValue()
                        .value(value)
        );
    }

    public Range<Integer> getValuesRange() {
        List<Integer> values = super.getValues();
        return new Range<>(
                values.get(0),
                values.get(values.size() - 1)
        );
    }

    public int getMaxAnalogValue() {
        List<Integer> values = super.getValues();
        return values.get(1);
    }

}
