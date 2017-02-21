package pl.ciochon.arduino.serial.core.command;

/**
 * Created by Konrad Ciochoń on 2017-02-09.
 */
public abstract class BaseCmdStartCommand implements Command {

    public void execute(String... argsList) throws Exception {

        String args = "";
        for (String arg : argsList) {
            args += arg + " ";
        }

        Runtime.getRuntime().exec("cmd /c start " + getProgramToExecute() + " " + args);
    }

    protected abstract String getProgramToExecute();

}
