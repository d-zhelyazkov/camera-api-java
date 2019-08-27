package com.xrc.camera;

import io.swagger.client.api.DefaultApi;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Camera {
    private final DefaultApi swaggerApi;

    Camera(DefaultApi swaggerApi) {
        this.swaggerApi = swaggerApi;
    }

    public BufferedImage getImage() {
        try (InputStream is = swaggerApi.getImageStream()) {
            return ImageIO.read(is);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
