package pl.ciochon.arduino.serial.pilot;


import pl.ciochon.arduino.serial.pilot.event.PilotEvent;

import java.util.Map;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
public class BasePilot implements Pilot {

    private Map<Long, PilotKey> codesMap;

    public BasePilot(Map<Long, PilotKey> keyMap) {
        this.codesMap = keyMap;
    }

    private PilotKey lastActionKey;

    int repeatCount = 0;

    public PilotEvent mapKey(long key) {
        PilotKey pressedKey = codesMap.get(key);
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
