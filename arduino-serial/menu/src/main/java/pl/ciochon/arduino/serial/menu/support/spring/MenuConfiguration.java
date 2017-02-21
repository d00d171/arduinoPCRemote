package pl.ciochon.arduino.serial.menu.support.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.ciochon.arduino.serial.menu.Menu;

/**
 * Created by Konrad Ciochoń on 2017-02-15.
 */
@Configuration
public class MenuConfiguration {

    @Bean
    public Menu menu(){
        return new Menu();
    }

}
