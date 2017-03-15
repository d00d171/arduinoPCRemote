package pl.ciochon.arduino.serial.support.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.ciochon.arduino.serial.core.command.CommandExecutor;

/**
 * Created by Konrad Ciochoń on 2017-02-15.
 */
@Configuration
@ComponentScan("pl.ciochon.arduino.serial.core.command.impl")
public class CommandConfiguration {

    @Bean
    public CommandExecutor commandExecutor() {
        return new CommandExecutor();
    }

}
