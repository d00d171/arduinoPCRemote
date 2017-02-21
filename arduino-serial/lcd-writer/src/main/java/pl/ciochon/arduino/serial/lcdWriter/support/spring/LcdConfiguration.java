package pl.ciochon.arduino.serial.lcdWriter.support.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.ciochon.arduino.serial.lcdWriter.LcdScreenController;
import pl.ciochon.arduino.serial.lcdWriter.LcdScreenControllerImpl;
import pl.ciochon.arduino.serial.lcdWriter.LcdSerialWriter;
import pl.ciochon.arduino.serial.lcdWriter.MockLcdScreenController;

/**
 * Created by Konrad Ciochoń on 2017-02-12.
 */
@Configuration
public class LcdConfiguration {

    @Bean
    @Profile("LCD")
    public LcdSerialWriter lcdSerialWriter() {
        return new LcdSerialWriter();
    }

    @Bean
    @Profile("LCD")
    public LcdScreenController lcdScreenController(){
        return new LcdScreenControllerImpl();
    }

    @Bean
    @Profile("!LCD")
    public LcdScreenController lcdMockScreenController(){
        return new MockLcdScreenController();
    }

}
