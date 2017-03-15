package pl.ciochon.arduino.serial.menu.windows;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.ciochon.arduino.serial.support.spring.WindowsMenuConfiguration;

/**
 * Created by Konrad Ciochoń on 2017-02-16.
 */
public class MenuTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(WindowsMenuConfiguration.class);

        WindowsMenuController windowsMenuController = applicationContext.getBean(WindowsMenuController.class);
        windowsMenuController.initialize();
        windowsMenuController.toggleVisibility(true);
    }

}
