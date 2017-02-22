package pl.ciochon.arduino.serial.menu.windows;

import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    private Fonts fonts;

    public JLabel createImage(String path, int width, int height) {
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JLabel(new ImageIcon(myPicture.getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }

    public JScrollPane createOptions(Object[] options) {
        DefaultListModel model = new DefaultListModel();
        JList list = new JList(model);
        list.setFont(fonts.OPTIONS_FONT);
        JScrollPane pane = new JScrollPane(list);
        for (Object obj : options) {
            model.addElement(obj);
        }
        list.setSelectedIndex(0);
        return pane;
    }

    public void scrollPaneUp(JScrollPane jScrollPane) {
        JList list = (JList) jScrollPane.getViewport().getView();
        list.setSelectedIndex(list.getSelectedIndex() - 1);
    }

    public void scrollPaneDown(JScrollPane jScrollPane) {
        JList list = (JList) jScrollPane.getViewport().getView();
        list.setSelectedIndex(list.getSelectedIndex() + 1);
    }

}
