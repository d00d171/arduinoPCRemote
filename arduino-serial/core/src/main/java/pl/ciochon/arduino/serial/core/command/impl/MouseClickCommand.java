package pl.ciochon.arduino.serial.core.command.impl;

import pl.ciochon.arduino.serial.core.command.BaseNIRCMDCommand;

/**
 * Created by Konrad Ciochoń on 2017-03-01.
 */
public class MouseClickCommand extends BaseNIRCMDCommand {

    @Override
    public String getNirCmdArguments() {
        return "sendmouse left click";
    }
}
