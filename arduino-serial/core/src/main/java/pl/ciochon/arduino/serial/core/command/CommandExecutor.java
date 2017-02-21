package pl.ciochon.arduino.serial.core.command;

/**
 * Created by Konrad Ciochoń on 2017-02-09.
 */
public class CommandExecutor {

    public void execute(Command command, String... args){
        try {
            command.execute(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
