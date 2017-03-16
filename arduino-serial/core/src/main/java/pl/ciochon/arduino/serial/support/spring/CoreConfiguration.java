package pl.ciochon.arduino.serial.support.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.ciochon.arduino.serial.core.connection.Connection;
import pl.ciochon.arduino.serial.core.connection.SerialListener;
import pl.ciochon.arduino.serial.core.connection.SerialWriter;
import pl.ciochon.arduino.serial.support.logging.LoggerSettings;

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

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public LoggerSettings loggerSettings() {
        return new LoggerSettings();
    }

}
