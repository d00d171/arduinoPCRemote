package pl.ciochon.arduino.serial.core.command;

import java.io.IOException;

/**
 * Created by Konrad Ciochoń on 2017-02-09.
 */
public interface Command {

    public void execute(String... args) throws Exception;

}
