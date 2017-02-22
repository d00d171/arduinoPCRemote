package pl.ciochon.arduino.serial.menu.windows.support.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.ciochon.arduino.serial.menu.windows.*;

/**
 * Created by Konrad Ciochoń on 2017-02-16.
 */
@Configuration
public class WindowsMenuConfiguration {

    @Bean
    public Messages messages() {
        return new Messages();
    }

    @Bean
    public WindowsMenuController windowsMenuController() {
        return new WindowsMenuController();
    }

    @Bean
    public Icons icons() {
        return new Icons();
    }

    @Bean
    public Fonts fonts() {
        return new Fonts();
    }

    @Bean
    public MenuUtil menuUtil() {
        return new MenuUtil();
    }

}

