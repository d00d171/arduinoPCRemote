package pl.ciochon.arduino.serial.core.command.impl;

import pl.ciochon.arduino.serial.core.command.BaseNIRCMDCommand;

/**
 * Created by Konrad Ciochoń on 2017-02-09.
 */
public class VolumeChangeCommand extends BaseNIRCMDCommand {

    private Long volumeChangeValue;

    public VolumeChangeCommand(Long volumeChangeValue) {
        this.volumeChangeValue = volumeChangeValue;
    }

    public String getArgs() {
        return volumeChangeValue.toString();
    }

    public String getNirCmdArguments() {
        return "changesysvolume";
    }

}
