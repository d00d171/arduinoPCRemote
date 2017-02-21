package pl.ciochon.arduino.serial.app.support.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.ciochon.arduino.serial.app.listener.ContextRefreshedListener;
import pl.ciochon.arduino.serial.core.support.spring.CoreConfiguration;
import pl.ciochon.arduino.serial.menu.support.spring.MenuConfiguration;
import pl.ciochon.arduino.serial.pilot.carmp3.support.spring.CarMp3PilotConfiguration;
import pl.ciochon.arduino.serial.pilot.tv.support.spring.TvPilotConfiguration;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
@Configuration
@Import({CoreConfiguration.class, PropertySourceConfiguration.class, TvPilotConfiguration.class,
        MenuStatesConfiguration.class, MenuConfiguration.class, CarMp3PilotConfiguration.class,})
public class ApplicationConfiguration {

    @Bean
    public ContextRefreshedListener contextRefreshedListener() {
        return new ContextRefreshedListener();
    }

}
