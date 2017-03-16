package pl.ciochon.arduino.serial.support.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.ciochon.arduino.serial.menu.view.OSDMenuView;
import pl.ciochon.arduino.serial.menu.view.ViewableListCellRenderer;
import pl.ciochon.arduino.serial.menu.view.util.Fonts;
import pl.ciochon.arduino.serial.menu.view.util.Icons;
import pl.ciochon.arduino.serial.menu.view.util.MenuUtil;
import pl.ciochon.arduino.serial.menu.view.util.ViewValueResolver;

/**
 * Created by Konrad Ciochoń on 2017-02-16.
 */
@Configuration
public class ViewsConfiguration {

    @Bean
    public OSDMenuView windowsMenuController() {
        return new OSDMenuView();
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

