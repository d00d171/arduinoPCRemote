package pl.ciochon.arduino.serial.pilot.event.dispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.core.connection.event.dispatcher.EventDispatcher;
import pl.ciochon.arduino.serial.pilot.Pilot;
import pl.ciochon.arduino.serial.pilot.event.PilotEvent;

public abstract class PilotEventDispatcher implements EventDispatcher {

    private Pilot pilot;

    public void dispatch(String eventValue) {
        try {
            PilotEvent event = pilot.mapKey(Long.valueOf(eventValue));
            if (event != null) {
                dispatch(event);
            }
        } catch (NumberFormatException e) {

        }
    }

    protected abstract void dispatch(PilotEvent pilotEvent);

    public Pilot getPilot() {
        return pilot;
    }

    @Autowired
    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

}
