package pl.ciochon.arduino.serial.pilot.event.dispatcher;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.menu.Menu;
import pl.ciochon.arduino.serial.pilot.event.PilotEvent;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
public class BasePilotEventDispatcher extends PilotEventDispatcher {

    private static final Logger logger = Logger.getLogger(BasePilotEventDispatcher.class);

    @Autowired
    private Menu menu;

    protected void dispatch(PilotEvent pilotEvent) {
        logger.debug("Dispatching key press: " + pilotEvent.toString());
        menu.interpretPilotEvent(pilotEvent);
    }

}
