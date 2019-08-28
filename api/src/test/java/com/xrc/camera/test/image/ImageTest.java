package com.xrc.camera.test.image;

import com.xrc.awt.Dimensions;
import com.xrc.camera.Camera;
import com.xrc.camera.TestFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class ImageTest {

    private static final Dimension MIN_IMAGE_SIZE =
            new Dimension(1280, 720);

    private static final DateFormat IMAGE_FILE_FORMAT =
            new SimpleDateFormat("YYYY-MM-dd-HH-mm-ss");

    private static BufferedImage image;

    @BeforeAll
    static void init() throws Exception {
        Camera camera = TestFactory.getCamera();
        image = camera.getImage();

        ImageIO.write(image, "JPG", new File(
                IMAGE_FILE_FORMAT.format(new Date()) + ".jpg")
        );
    }

    @Test
    void checkImageSize() {
        Dimension imageSize = new Dimension(
                image.getWidth(),
                image.getHeight()
        );

        Assertions.assertTrue(
                Dimensions.compare(imageSize, MIN_IMAGE_SIZE) >= 0
        );
    }
}