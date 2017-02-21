package pl.ciochon.arduino.serial.pilot.tv;

import pl.ciochon.arduino.serial.pilot.core.Pilot;
import pl.ciochon.arduino.serial.pilot.core.PilotKey;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Konrad Ciochoń on 2017-02-09.
 */
public class PhilipsPilot implements Pilot {

    private static Map<Long, PilotKey> keyMap;

    static {
        keyMap = new HashMap();
        keyMap.put(3843267751L, PilotKey.VOLUME_UP);
        keyMap.put(2891014758L, PilotKey.VOLUME_UP);

        keyMap.put(3826490130L, PilotKey.VOLUME_DOWN);
        keyMap.put(2907792379L, PilotKey.VOLUME_DOWN);

        keyMap.put(13L, PilotKey.MUTE);
        keyMap.put(2061L, PilotKey.MUTE);
    }

    public PilotKey mapKey(long key) {
        return keyMap.get(key);
    }
}
