package pl.ciochon.arduino.serial.pilot.tv;

import pl.ciochon.arduino.serial.pilot.core.Pilot;
import pl.ciochon.arduino.serial.pilot.core.PilotKey;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Konrad Ciochoń on 2017-02-09.
 */
public class PlayStationPilot implements Pilot {

    private static final int repeatInterval = 3;
    private static Map<Long, PilotKey> pilotKeyMap;

    static {
        pilotKeyMap = new HashMap<Long, PilotKey>();
        pilotKeyMap.put(650130L, PilotKey.VOLUME_UP);
        pilotKeyMap.put(387986L, PilotKey.VOLUME_DOWN);
        pilotKeyMap.put(854930L, PilotKey.MUTE);
        pilotKeyMap.put(691035L, PilotKey.POWER);
        pilotKeyMap.put(428891L, PilotKey.CANCEL);
    }

    private long lastActionKey;
    private long repeatKey = 4294967295L;
    private long repeatCount = 0;

    public PilotKey mapKey(long key) {
        if (key == repeatKey) {
            if (repeatCount == repeatInterval) {
                repeatCount = 0;

                PilotKey pilotKey = pilotKeyMap.get(key);
                if (lastActionKey == 854930L || lastActionKey == 691035L || lastActionKey == 428891) {
                    return null;
                } else {
                    return pilotKeyMap.get(lastActionKey);
                }
            }
            repeatCount += 1;
            return null;
        } else {
            if (lastActionKey != key) {
                repeatCount = 0;
            }
            lastActionKey = key;
            return pilotKeyMap.get(key);
        }
    }

}
