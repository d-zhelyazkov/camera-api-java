package com.xrc.camera;

import com.xrc.camera.setting.AutoExposureCompensationSetting;
import com.xrc.camera.setting.AutoExposureLockSetting;
import com.xrc.camera.setting.BasicCameraSetting;
import com.xrc.camera.setting.FocusModeSetting;
import com.xrc.camera.setting.ISOSetting;
import com.xrc.camera.setting.UnsupportedSettingException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Setting;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Camera {
    private final DefaultApi swaggerApi;

    private final Set<Setting> supportedSettings;

    Camera(DefaultApi swaggerApi) {
        this.swaggerApi = swaggerApi;

        supportedSettings = new HashSet<>(swaggerApi.settingsGet());
    }

    public BufferedImage getImage() {
        try (InputStream is = swaggerApi.getImageStream()) {
            return ImageIO.read(is);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public BasicCameraSetting getSetting(Setting setting) throws UnsupportedSettingException {
        checkSettingSupported(setting);

        return new BasicCameraSetting(swaggerApi, setting);
    }

    public AutoExposureCompensationSetting getAECompensationSetting() throws UnsupportedSettingException {
        checkSettingSupported(Setting.AE_COMPENSATION);

        return new AutoExposureCompensationSetting(swaggerApi);
    }

    public AutoExposureLockSetting getAELockSetting() throws UnsupportedSettingException {
        checkSettingSupported(Setting.AE_LOCK);

        return new AutoExposureLockSetting(swaggerApi);
    }

    public FocusModeSetting getFocusModeSetting() throws UnsupportedSettingException {
        checkSettingSupported(Setting.FOCUS_MODE);

        return new FocusModeSetting(swaggerApi);
    }

    public ISOSetting getISOSetting() throws UnsupportedSettingException {
        checkSettingSupported(Setting.ISO);

        return new ISOSetting(swaggerApi);
    }

    public Set<Setting> getSupportedSettings() {
        return supportedSettings;
    }

    public DefaultApi getSwaggerApi() {
        return swaggerApi;
    }

    private void checkSettingSupported(Setting setting) throws UnsupportedSettingException {
        if (!supportedSettings.contains(setting))
            throw new UnsupportedSettingException("Setting not supported.");
    }
}
