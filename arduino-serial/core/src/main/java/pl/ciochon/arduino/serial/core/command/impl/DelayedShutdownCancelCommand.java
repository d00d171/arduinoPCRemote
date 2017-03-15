package pl.ciochon.arduino.serial.core.command.impl;

import pl.ciochon.arduino.serial.core.command.BaseCmdStartCommand;

/**
 * Created by Konrad Ciochoń on 2017-02-10.
 */
public class DelayedShutdownCancelCommand extends BaseCmdStartCommand {

    protected String getProgramToExecute() {
        return "shutdown -a";
    }

}
