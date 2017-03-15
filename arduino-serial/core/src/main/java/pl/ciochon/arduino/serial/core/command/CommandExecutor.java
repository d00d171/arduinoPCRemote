package pl.ciochon.arduino.serial.core.command;

import org.apache.log4j.Logger;

/**
 * Created by Konrad Ciochoń on 2017-02-09.
 */
public class CommandExecutor {

    Logger logger = Logger.getLogger(CommandExecutor.class);

    public void execute(Command command) {
        try {
            command.execute();
        } catch (Exception e) {
            logger.error("Error during command execution", e);
        }
    }

}
