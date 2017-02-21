package pl.ciochon.arduino.serial.core.support.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.ciochon.arduino.serial.core.connection.Connection;
import pl.ciochon.arduino.serial.core.connection.SerialListener;
import pl.ciochon.arduino.serial.core.connection.SerialWriter;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
@Configuration
@Import(CommandConfiguration.class)
public class CoreConfiguration {

    @Bean
    public SerialListener eventListener() {
        SerialListener serialListener = new SerialListener();
        serialListener.setInput(connection().getInput());
        return serialListener;
    }

    @Bean
    public Connection connection() {
        return new Connection();
    }

    @Bean
    public SerialWriter serialWriter() {
        return new SerialWriter();
    }

}
