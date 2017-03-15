package pl.ciochon.arduino.serial.core.command.impl;

import pl.ciochon.arduino.serial.core.command.BaseCmdStartCommand;

/**
 * Created by Konrad Ciochoń on 2017-02-10.
 */
public class DelayedShutdownCommand extends BaseCmdStartCommand {

    private Long shutdownAfter;

    public DelayedShutdownCommand(Long shutdownAfter) {
        this.shutdownAfter = shutdownAfter;
    }

    public String getArgs() {
        return shutdownAfter.toString();
    }

    protected String getProgramToExecute() {
        return "shutdown -s -t";
    }
}
