package pl.ciochon.arduino.serial.core.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Konrad Ciochoń on 2017-02-09.
 */
public abstract class BaseNIRCMDCommand extends BaseCmdStartCommand {

    private String nirCmdPath;

    public abstract String getNirCmdArguments();

    protected String getProgramToExecute() {
      return nirCmdPath + " " + getNirCmdArguments();
    }

    @Value("${nir.cmd.path}")
    public void setNirCmdPath(String nirCmdPath) {
        this.nirCmdPath = nirCmdPath;
    }
}
