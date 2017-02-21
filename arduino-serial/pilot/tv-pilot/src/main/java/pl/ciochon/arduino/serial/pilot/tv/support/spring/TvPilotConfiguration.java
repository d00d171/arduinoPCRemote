package pl.ciochon.arduino.serial.pilot.tv.support.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.ciochon.arduino.serial.core.connection.event.dispatcher.EventDispatcher;
import pl.ciochon.arduino.serial.pilot.core.Pilot;
import pl.ciochon.arduino.serial.pilot.tv.PhilipsPilot;
import pl.ciochon.arduino.serial.pilot.tv.TvPilotEventDispatcher;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
@Configuration
@Profile("TV_PILOT")
public class TvPilotConfiguration {

    @Bean
    public Pilot pilot() {
        return new PhilipsPilot();
    }

    @Bean
    public EventDispatcher eventDispatcher() {
        return new TvPilotEventDispatcher();
    }

}
