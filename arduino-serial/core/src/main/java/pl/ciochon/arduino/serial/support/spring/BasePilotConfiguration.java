package pl.ciochon.arduino.serial.support.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.ciochon.arduino.serial.core.connection.event.dispatcher.EventDispatcher;
import pl.ciochon.arduino.serial.pilot.BasePilot;
import pl.ciochon.arduino.serial.pilot.KeysMapping;
import pl.ciochon.arduino.serial.pilot.Pilot;
import pl.ciochon.arduino.serial.pilot.event.dispatcher.BasePilotEventDispatcher;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
@Configuration
public class BasePilotConfiguration {

    @Bean
    public Pilot pilot() {
        return new BasePilot();
    }

    @Bean
    public EventDispatcher eventDispatcher() {
        return new BasePilotEventDispatcher();
    }

    @Bean
    public KeysMapping keysMapping() {
        return new KeysMapping();
    }

}
