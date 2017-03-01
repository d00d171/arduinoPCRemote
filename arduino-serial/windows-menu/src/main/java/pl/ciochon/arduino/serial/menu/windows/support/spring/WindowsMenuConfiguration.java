package pl.ciochon.arduino.serial.menu.windows.support.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.ciochon.arduino.serial.menu.windows.WindowsMenuController;
import pl.ciochon.arduino.serial.menu.windows.util.Fonts;
import pl.ciochon.arduino.serial.menu.windows.util.Icons;
import pl.ciochon.arduino.serial.menu.windows.util.MenuUtil;
import pl.ciochon.arduino.serial.menu.windows.util.ViewValueResolver;
import pl.ciochon.arduino.serial.menu.windows.view.ViewableListCellRenderer;

/**
 * Created by Konrad Ciochoń on 2017-02-16.
 */
@Configuration
public class WindowsMenuConfiguration {

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

    @Bean
    public ViewableListCellRenderer viewableListCellRenderer() {
        return new ViewableListCellRenderer();
    }

    @Bean
    public ViewValueResolver viewValueResolver() {
        return new ViewValueResolver();
    }

}

