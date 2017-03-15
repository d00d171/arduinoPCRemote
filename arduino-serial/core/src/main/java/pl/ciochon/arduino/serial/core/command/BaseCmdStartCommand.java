package pl.ciochon.arduino.serial.core.command;

/**
 * Created by Konrad Ciochoń on 2017-02-09.
 */
public abstract class BaseCmdStartCommand implements Command {

    public void execute() throws Exception {
        Runtime.getRuntime().exec("cmd /c start " + getProgramToExecute() + " " + getArgs());
    }

    protected abstract String getProgramToExecute();

}
