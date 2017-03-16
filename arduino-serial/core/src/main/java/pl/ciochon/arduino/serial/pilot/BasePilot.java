package pl.ciochon.arduino.serial.pilot;


import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.pilot.event.PilotEvent;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
public class BasePilot implements Pilot {

    @Autowired
    private KeysMapping keysMapping;

    private PilotKey lastActionKey;

    int repeatCount = 0;

    public PilotEvent mapKey(long key) {
        PilotKey pressedKey = keysMapping.getCodesMap().get(key);
        if (PilotKey.REPEAT_KEY.equals(pressedKey)) {
            repeatCount += 1;
            return new PilotEvent(lastActionKey, repeatCount);
        } else if (pressedKey != null) {
            repeatCount = 0;
            lastActionKey = pressedKey;
            return new PilotEvent(pressedKey, repeatCount);
        } else {
            return null;
        }
    }

}
