package pl.ciochon.arduino.serial.support.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.ciochon.arduino.serial.core.connection.event.dispatcher.EventDispatcher;
import pl.ciochon.arduino.serial.core.util.AppConfigurationHolder;
import pl.ciochon.arduino.serial.pilot.BasePilot;
import pl.ciochon.arduino.serial.pilot.Pilot;
import pl.ciochon.arduino.serial.pilot.event.dispatcher.BasePilotEventDispatcher;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
@Configuration
public class BasePilotConfiguration {

    @Bean
    public Pilot pilot(AppConfigurationHolder appConfigurationHolder) {
        return new BasePilot(appConfigurationHolder.getAppConfiguration().getCodesMap());
    }

    @Bean
    public EventDispatcher eventDispatcher() {
        return new BasePilotEventDispatcher();
    }

}
