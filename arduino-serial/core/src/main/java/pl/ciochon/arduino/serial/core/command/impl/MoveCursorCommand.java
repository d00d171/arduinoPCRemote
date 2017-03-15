package pl.ciochon.arduino.serial.core.command.impl;

import pl.ciochon.arduino.serial.core.command.BaseNIRCMDCommand;

/**
 * Created by Konrad Ciochoń on 2017-03-01.
 */
public class MoveCursorCommand extends BaseNIRCMDCommand {

    private Integer x;

    private Integer y;

    public MoveCursorCommand(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public String getArgs() {
        return x + " " + y;
    }

    @Override
    public String getNirCmdArguments() {
        return "movecursor";
    }

}
