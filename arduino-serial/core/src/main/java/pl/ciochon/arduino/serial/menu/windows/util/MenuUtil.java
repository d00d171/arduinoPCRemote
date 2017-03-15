package pl.ciochon.arduino.serial.menu.windows.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Konrad Ciochoń on 2017-02-21.
 */
public class MenuUtil {

    public JLabel createImage(String path, int width, int height) {
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JLabel(new ImageIcon(myPicture.getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }

}
