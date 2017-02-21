package pl.ciochon.arduino.serial.core.command.impl;

import org.springframework.stereotype.Component;
import pl.ciochon.arduino.serial.core.command.BaseNIRCMDCommand;

/**
 * Created by Konrad Ciochoń on 2017-02-09.
 */
@Component
public class VolumeDownCommand extends BaseNIRCMDCommand {

    public String getNirCmdArguments() {
        return "changesysvolume -1000";
    }

}
