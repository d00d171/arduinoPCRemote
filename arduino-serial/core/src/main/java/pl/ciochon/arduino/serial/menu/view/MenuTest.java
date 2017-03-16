package pl.ciochon.arduino.serial.menu.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.ciochon.arduino.serial.support.spring.ViewsConfiguration;

/**
 * Created by Konrad Ciochoń on 2017-02-16.
 */
public class MenuTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ViewsConfiguration.class);

        OSDMenuView OSDMenuView = applicationContext.getBean(OSDMenuView.class);
        OSDMenuView.initialize();
        OSDMenuView.toggleVisibility(true);
    }

}
