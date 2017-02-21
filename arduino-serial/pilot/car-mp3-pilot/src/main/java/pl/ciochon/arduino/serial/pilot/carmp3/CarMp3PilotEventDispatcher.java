package pl.ciochon.arduino.serial.pilot.carmp3;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.menu.Menu;
import pl.ciochon.arduino.serial.pilot.core.PilotKey;
import pl.ciochon.arduino.serial.pilot.core.event.dispatcher.PilotEventDispatcher;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
public class CarMp3PilotEventDispatcher extends PilotEventDispatcher {

    private Menu menu;

    protected void dispatch(PilotKey pilotKey) {
        System.out.println(pilotKey.toString());
        menu.interpretKeyPress(pilotKey);
    }

    @Autowired
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
