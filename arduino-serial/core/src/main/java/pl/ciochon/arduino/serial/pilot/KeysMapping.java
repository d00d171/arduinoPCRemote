package pl.ciochon.arduino.serial.pilot;

import org.springframework.beans.factory.annotation.Value;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Konrad Ciochoń on 2017-03-01.
 */
public class KeysMapping {

    private Map<PilotKey, Long> keysMap;

    private Map<Long, PilotKey> codesMap;

    public Map<PilotKey, Long> getKeysMap() {
        return keysMap;
    }

    @Value("${keys.map}")
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
