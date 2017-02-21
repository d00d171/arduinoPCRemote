package pl.ciochon.arduino.serial.menu.windows;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Konrad Ciochoń on 2017-02-21.
 */
public class Icons {

    private static final int ICON_WIDHT = 60;
    private static final int ICON_HEIGHT = 60;

    public JLabel CHANNEL_MINUS_ICON = createImage(getPath("CH-.png"), ICON_WIDHT, ICON_HEIGHT);
    public JLabel CHANNEL_PLUS_ICON = createImage(getPath("CH+.png"), ICON_WIDHT, ICON_HEIGHT);
    public JLabel CHANNEL_ICON = createImage(getPath("CH.png"), ICON_WIDHT, ICON_HEIGHT);
    public JLabel EQ_ICON = createImage(getPath("EQ.png"), ICON_WIDHT, ICON_HEIGHT);

    private JLabel createImage(String path, int width, int height) {
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JLabel(new ImageIcon(myPicture.getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }

    private String getPath(String name) {
        return getClass().getClassLoader().getResource(name).getFile();
    }

}
