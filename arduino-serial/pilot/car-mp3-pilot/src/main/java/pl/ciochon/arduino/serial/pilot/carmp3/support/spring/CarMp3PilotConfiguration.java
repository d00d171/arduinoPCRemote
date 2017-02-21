package pl.ciochon.arduino.serial.pilot.carmp3.support.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.ciochon.arduino.serial.core.connection.event.dispatcher.EventDispatcher;
import pl.ciochon.arduino.serial.pilot.carmp3.CarMp3Pilot;
import pl.ciochon.arduino.serial.pilot.carmp3.CarMp3PilotEventDispatcher;
import pl.ciochon.arduino.serial.pilot.core.Pilot;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
@Configuration
@Profile("CAR_MP3_PILOT")
public class CarMp3PilotConfiguration {

    @Bean
    public Pilot pilot() {
        return new CarMp3Pilot();
    }

    @Bean
    public EventDispatcher eventDispatcher() {
        return new CarMp3PilotEventDispatcher();
    }

}
