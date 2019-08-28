package com.xrc.camera;

import io.swagger.client.ApiClient;
import io.swagger.client.api.DefaultApi;

import java.io.IOException;

public class TestFactory {

    private static final Camera camera;

    private static final TestProperties testProperties;

    static {
        try {
            testProperties = new TestProperties();

            camera = Factory.getCamera(
                    testProperties.getCameraHost(),
                    testProperties.getCameraPort()
            );

            DefaultApi swaggerApi = camera.getSwaggerApi();
            ApiClient apiClient = swaggerApi.getApiClient();
            boolean apiDebugEnabled = testProperties.isApiDebugEnabled();
            apiClient.setDebugging(apiDebugEnabled);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Camera getCamera() {
        return camera;
    }

    public static TestProperties getTestProperties() {
        return testProperties;
    }
}
