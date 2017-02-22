package pl.ciochon.arduino.serial.menu.windows;

import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * Created by Konrad Ciochoń on 2017-02-16.
 */
public class WindowsMenuController {

    @Autowired
    private Messages messages;

    @Autowired
    private Icons icons;

    @Autowired
    private Fonts fonts;

    private boolean visible = false;

    private JWindow window;
    private JLabel header;
    private JComponent centerPanel;
    private JComponent footer;

    public void initialize() {
        window = createWindow();
        centerWindow();
        header = createWindowHeader();
        window.add(header, BorderLayout.NORTH);
        footer = createFooter();
        window.add(footer, BorderLayout.SOUTH);
    }

    public void setCenterPanel(JComponent component) {
        if (centerPanel != null) {
            window.remove(centerPanel);
        }
        centerPanel = component;
        window.add(centerPanel, BorderLayout.CENTER);
        window.revalidate();
    }

    public JComponent getCenterPanel() {
        return centerPanel;
    }

    public void toggleVisibility(boolean visible) {
        this.visible = visible;
        window.setVisible(visible);
    }

    private JPanel createFooter() {
        JPanel footer = new JPanel();
        footer.setLayout(new BorderLayout());

        JPanel firstRow = new JPanel();
        firstRow.setLayout(new FlowLayout());
        firstRow.add(icons.CHANNEL_MINUS_ICON);
        firstRow.add(footerLabel(" / "));
        firstRow.add(icons.CHANNEL_PLUS_ICON);
        firstRow.add(footerLabel(" - " + messages.MENU_SCROLLE));

        JPanel secondRow = new JPanel();
        secondRow.add(icons.CHANNEL_ICON);
        secondRow.add(footerLabel(" - " + messages.APPROVE + " / "));
        secondRow.add(icons.EQ_ICON);
        secondRow.add(footerLabel(" - " + messages.BACK));

        footer.add(firstRow, BorderLayout.PAGE_START);
        footer.add(secondRow, BorderLayout.PAGE_END);
        return footer;
    }

    private JLabel footerLabel(String content) {
        JLabel result = new JLabel(content);
        result.setFont(fonts.FOOTER_FONT);
        return result;
    }

    private JWindow createWindow() {
        JWindow window = new JWindow();
        window.setSize(600, 300);
        window.setAlwaysOnTop(true);
        window.setLocationByPlatform(true);
        window.setLayout(new BorderLayout());
        return window;
    }

    private JLabel createWindowHeader() {
        JLabel jLabel = new JLabel(messages.MAIN_MENU, JLabel.CENTER);
        jLabel.setFont(fonts.HEADER_FONT);
        jLabel.setBackground(Color.CYAN);
        jLabel.setOpaque(true);
        jLabel.setSize(window.getWidth(), 30);
        jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
        return jLabel;
    }

    private void centerWindow() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - window.getWidth();
        int y = (int) rect.getMaxY() - window.getHeight();
        window.setLocation(x / 2, y / 2);
    }

    public boolean isVisible() {
        return visible;
    }
}
