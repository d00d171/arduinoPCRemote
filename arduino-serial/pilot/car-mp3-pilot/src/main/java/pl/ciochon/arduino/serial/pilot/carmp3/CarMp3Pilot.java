package pl.ciochon.arduino.serial.pilot.carmp3;


import pl.ciochon.arduino.serial.pilot.core.Pilot;
import pl.ciochon.arduino.serial.pilot.core.PilotKey;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
public class CarMp3Pilot implements Pilot {

    private static Map<Long, PilotKey> keyMap;

    private static final Long repeatKey = 4294967295L;

    static {
        keyMap = new HashMap();
        keyMap.put(16753245L, PilotKey.CHANNEL_MINUS);
        keyMap.put(16736925L, PilotKey.CHANNEL);
        keyMap.put(16769565L, PilotKey.CHANNEL_PLUS);
        keyMap.put(16720605L, PilotKey.PREV);
        keyMap.put(16712445L, PilotKey.NEXT);
        keyMap.put(16761405L, PilotKey.PLAY_PAUSE);
        keyMap.put(16769055L, PilotKey.VOLUME_DOWN);
        keyMap.put(16754775L, PilotKey.VOLUME_UP);
        keyMap.put(16748655L, PilotKey.EQ);
        keyMap.put(16738455L, PilotKey.ZERO);
        keyMap.put(16750695L, PilotKey.HUNDRED_PLUS);
        keyMap.put(16756815L, PilotKey.TWO_HUNDRED_PLUS);
        keyMap.put(16724175L, PilotKey.ONE);
        keyMap.put(16718055L, PilotKey.TWO);
        keyMap.put(16743045L, PilotKey.THREE);
        keyMap.put(16716015L, PilotKey.FOUR);
        keyMap.put(16726215L, PilotKey.FIVE);
        keyMap.put(16734885L, PilotKey.SIX);
        keyMap.put(16728765L, PilotKey.SEVEN);
        keyMap.put(16730805L, PilotKey.EIGHT);
        keyMap.put(16732845L, PilotKey.NINE);


    }

    public PilotKey mapKey(long key) {
        return keyMap.get(key);
    }

}
