package pl.ciochon.arduino.serial.core.command.impl;

import org.springframework.stereotype.Component;
import pl.ciochon.arduino.serial.core.command.BaseCmdStartCommand;

/**
 * Created by Konrad Ciochoń on 2017-02-10.
 */
@Component
public class DelayedShutdownCommand extends BaseCmdStartCommand{

    protected String getProgramToExecute() {
        return "shutdown -s -t";
    }
}
