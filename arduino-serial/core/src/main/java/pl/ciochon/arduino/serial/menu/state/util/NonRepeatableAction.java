package pl.ciochon.arduino.serial.menu.state.util;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.core.command.Command;
import pl.ciochon.arduino.serial.core.command.CommandExecutor;
import pl.ciochon.arduino.serial.pilot.event.PilotEvent;

/**
 * Created by Konrad Ciochoń on 2017-03-16.
 */
public class NonRepeatableAction {

    private static CommandExecutor commandExecutor;

    public static <T> T perform(PilotEvent pilotEvent, T result) {
        if (pilotEvent.getRepeatCount() == 0) {
            return result;
        }
        return null;
    }

    public static <T> T performVoidFunction(PilotEvent pilotEvent, Function function) {
        return performVoidFunction(pilotEvent, function, null);
    }

    public static <T> T performVoidFunction(PilotEvent pilotEvent, Function function, T result) {
        if (pilotEvent.getRepeatCount() == 0) {
            function.call();
            return result;
        }
        return null;
    }

    public static <T> T performCommand(PilotEvent pilotEvent, Command command) {
        return performCommand(pilotEvent, command, null);
    }

    public static <T> T performCommand(PilotEvent pilotEvent, Command command, T result) {
        if (pilotEvent.getRepeatCount() == 0) {
            commandExecutor.execute(command);
            return result;
        }
        return null;
    }

    public static <T> T performFunctionWithReturnValue(PilotEvent pilotEvent, FunctionWithReturnValue function) {
        if (pilotEvent.getRepeatCount() == 0) {
            return (T) function.call();
        }
        return null;
    }

    @Autowired
    public void setCommandExecutor(CommandExecutor commandExecutor) {
        NonRepeatableAction.commandExecutor = commandExecutor;
    }

    @FunctionalInterface
    public interface Function {
        void call();
    }

    @FunctionalInterface
    public interface FunctionWithReturnValue<T> {
        T call();
    }

}
