package pl.ciochon.arduino.serial.core.util;

import pl.ciochon.arduino.serial.pilot.PilotKey;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Konrad Ciochoń on 2017-03-01.
 */
public class AppConfiguration {

    private Map<PilotKey, Long> keysMap;
    
    private Map<Long, PilotKey> codesMap;

    public Map<PilotKey, Long> getKeysMap() {
        return keysMap;
    }

    public void setKeysMap(Map<PilotKey, Long> keysMap) {
        this.keysMap = keysMap;
        codesMap = keysMap.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }

    public Map<Long, PilotKey> getCodesMap() {
        return codesMap;
    }

    public void setCodesMap(Map<Long, PilotKey> codesMap) {
        this.codesMap = codesMap;
    }
}
