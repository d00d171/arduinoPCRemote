package pl.ciochon.arduino.serial.core.command;

/**
 * Created by Konrad Ciochoń on 2017-02-09.
 */
public interface Command {

    default String getArgs() {
        return "";
    }

    void execute() throws Exception;

}
