package com.xrc.camera;

import io.swagger.client.api.DefaultApi;

public class Factory {
    public static Camera getCamera(String host, int port) {
        DefaultApi swaggerApi = new DefaultApi(host, port);
        return new Camera(swaggerApi);
    }
}
