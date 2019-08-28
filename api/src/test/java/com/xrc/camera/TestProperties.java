package com.xrc.camera;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

    private static final String TEST_PROPS_FILE = "test.properties";

    private static final String CAMERA_HOST_CONFIG = "cameraHost";

    private static final String CAMERA_PORT_CONFIG = "cameraPort";

    private static final String API_DEBUG_CONFIG = "apiDebug";

    private static final String ISO_MAX_ERROR_CONFIG = "isoValueMaxError";

    private final Properties testProperties = new Properties();

    TestProperties() throws IOException {
        ClassLoader classLoader = TestProperties.class.getClassLoader();
        try (InputStream stream =
                     classLoader.getResourceAsStream(TEST_PROPS_FILE)) {
            assert stream != null;

            testProperties.load(stream);
        }
    }

    String getCameraHost() {
        return testProperties.getProperty(CAMERA_HOST_CONFIG);
    }

    int getCameraPort() {
        String cameraPortStr = testProperties.getProperty(CAMERA_PORT_CONFIG);
        return Integer.parseInt(cameraPortStr);
    }

    boolean isApiDebugEnabled() {
        String apiDebugStr = testProperties.getProperty(API_DEBUG_CONFIG);
        return Boolean.parseBoolean(apiDebugStr);
    }

    public int getIsoValueMaxError() {
        String isoMaxErrorStr = testProperties.getProperty(ISO_MAX_ERROR_CONFIG);
        return Integer.parseInt(isoMaxErrorStr);
    }
}
