package pl.ciochon.arduino.serial.pilot.event;

import pl.ciochon.arduino.serial.pilot.PilotKey;

/**
 * Created by Konrad Ciochoń on 2017-03-15.
 */
public class PilotEvent {

    private PilotKey pilotKey;

    int repeatCount;

    public PilotEvent(PilotKey pilotKey, int repeatCount) {
        this.pilotKey = pilotKey;
        this.repeatCount = repeatCount;
    }

    public PilotKey getPilotKey() {
        return pilotKey;
    }

    public void setPilotKey(PilotKey pilotKey) {
        this.pilotKey = pilotKey;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    @Override
    public String toString() {
        return "PilotEvent{" +
                "pilotKey=" + pilotKey +
                ", repeatCount=" + repeatCount +
                '}';
    }
}
