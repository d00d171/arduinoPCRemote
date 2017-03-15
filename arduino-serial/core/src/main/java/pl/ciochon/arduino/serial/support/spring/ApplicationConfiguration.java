package pl.ciochon.arduino.serial.support.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
@Configuration
@Import({CoreConfiguration.class, PropertySourceConfiguration.class,
        MenuStatesConfiguration.class, MenuConfiguration.class, BasePilotConfiguration.class, WindowsMenuConfiguration.class})
public class ApplicationConfiguration {

    @Bean
    public ContextRefreshedListener contextRefreshedListener() {
        return new ContextRefreshedListener();
    }

}
