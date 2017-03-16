package pl.ciochon.arduino.serial.menu.view.util;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Created by Konrad Ciochoń on 2017-02-21.
 */
public class Icons {

    @Autowired
    private MenuUtil menuUtil;

    private static final int ICON_WIDHT = 60;
    private static final int ICON_HEIGHT = 60;

    public JLabel CHANNEL_MINUS_ICON;
    public JLabel CHANNEL_PLUS_ICON;
    public JLabel CHANNEL_ICON;
    public JLabel EQ_ICON;

    @PostConstruct
    public void init() {
        CHANNEL_MINUS_ICON = menuUtil.createImage(getPath("CH-.png"), ICON_WIDHT, ICON_HEIGHT);
        CHANNEL_PLUS_ICON = menuUtil.createImage(getPath("CH+.png"), ICON_WIDHT, ICON_HEIGHT);
        CHANNEL_ICON = menuUtil.createImage(getPath("CH.png"), ICON_WIDHT, ICON_HEIGHT);
        EQ_ICON = menuUtil.createImage(getPath("EQ.png"), ICON_WIDHT, ICON_HEIGHT);
    }


    private String getPath(String name) {
        return getClass().getClassLoader().getResource(name).getFile();
    }

}
