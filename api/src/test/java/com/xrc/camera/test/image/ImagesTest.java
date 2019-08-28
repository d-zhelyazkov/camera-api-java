package com.xrc.camera.test.image;

import com.xrc.camera.Camera;
import com.xrc.camera.TestFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.awt.image.BufferedImage;

class ImagesTest {

    @RepeatedTest(20)
    void testImageRetrieval() {
        Camera camera = TestFactory.getCamera();
        BufferedImage image = camera.getImage();
        Assertions.assertNotNull(image);
    }
}
