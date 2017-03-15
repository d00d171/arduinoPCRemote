package pl.ciochon.arduino.serial.support.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import pl.ciochon.arduino.serial.core.connection.Connection;
import pl.ciochon.arduino.serial.core.connection.SerialListener;
import pl.ciochon.arduino.serial.menu.Menu;
import pl.ciochon.arduino.serial.menu.windows.WindowsMenuController;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    private Connection connection;

    private SerialListener serialListener;

    private Menu menu;

    private WindowsMenuController windowsMenuController;

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        connection.addEventListener(serialListener);
        try {
            Thread.sleep(2000);
            windowsMenuController.initialize();
            menu.initialize();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    public void setSerialListener(SerialListener serialListener) {
        this.serialListener = serialListener;
    }

    @Autowired
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Autowired
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Autowired
    public void setWindowsMenuController(WindowsMenuController windowsMenuController) {
        this.windowsMenuController = windowsMenuController;
    }
}
