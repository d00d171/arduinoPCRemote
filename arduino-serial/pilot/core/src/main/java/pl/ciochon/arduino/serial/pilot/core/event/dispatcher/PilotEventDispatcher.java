package pl.ciochon.arduino.serial.pilot.core.event.dispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.core.command.CommandExecutor;
import pl.ciochon.arduino.serial.core.connection.event.dispatcher.EventDispatcher;
import pl.ciochon.arduino.serial.pilot.core.Pilot;
import pl.ciochon.arduino.serial.pilot.core.PilotKey;

public abstract class PilotEventDispatcher implements EventDispatcher {

    private Pilot pilot;
    protected CommandExecutor commandExecutor;

    public void dispatch(String eventValue) {
        try {
            PilotKey key = pilot.mapKey(Long.valueOf(eventValue));
            if (key != null) {
                dispatch(key);
            }
        } catch (NumberFormatException e) {

        }
    }

    protected abstract void dispatch(PilotKey pilotKey);

    public Pilot getPilot() {
        return pilot;
    }

    @Autowired
    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public CommandExecutor getCommandExecutor() {
        return commandExecutor;
    }

    @Autowired
    public void setCommandExecutor(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

}
