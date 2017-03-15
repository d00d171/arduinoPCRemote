package pl.ciochon.arduino.serial.pilot;

import pl.ciochon.arduino.serial.pilot.event.PilotEvent;

/**
 * Created by Konrad Ciochoń on 2017-02-09.
 */
public interface Pilot {

    public PilotEvent mapKey(long key);

}
