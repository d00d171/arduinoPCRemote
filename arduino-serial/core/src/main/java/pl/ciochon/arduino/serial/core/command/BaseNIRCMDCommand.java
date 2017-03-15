package pl.ciochon.arduino.serial.core.command;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Konrad Ciochoń on 2017-02-09.
 */
public abstract class BaseNIRCMDCommand extends BaseCmdStartCommand {

    //TODO koniecznie poprawic
    private String nirCmdPath = "E:\\PROJECTS\\ArduinoSerialClient\\runner\\bin\\nircmd.exe";

    public abstract String getNirCmdArguments();

    protected String getProgramToExecute() {
        return nirCmdPath + " " + getNirCmdArguments();
    }

    @Value("${nir.cmd.path}")
    public void setNirCmdPath(String nirCmdPath) {
        this.nirCmdPath = nirCmdPath;
    }
}
