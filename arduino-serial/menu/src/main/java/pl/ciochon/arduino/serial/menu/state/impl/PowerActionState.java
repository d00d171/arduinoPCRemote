package pl.ciochon.arduino.serial.menu.state.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.core.command.impl.DelayedShutdownCancelCommand;
import pl.ciochon.arduino.serial.core.command.impl.DelayedShutdownCommand;
import pl.ciochon.arduino.serial.menu.state.MenuState;
import pl.ciochon.arduino.serial.pilot.core.PilotKey;

/**
 * Created by Konrad Ciochoń on 2017-02-15.
 */
public class PowerActionState extends MenuState {

    public static final String NAME = "POW_ACTION";

    private String timerSettings = "";

    private DelayedShutdownCommand delayedShutdownCommand;

    private DelayedShutdownCancelCommand delayedShutdownCancelCommand;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void beforeExit() {
        super.beforeExit();
        clearTimer();
    }

    private void clearTimer() {
        timerSettings = "";
    }

    @Override
    public void onKeyPress(PilotKey pilotKey) {
        switch (pilotKey) {
            case ONE:
                timerSettings += 1;
                break;
            case TWO:
                timerSettings += 2;
                break;
            case THREE:
                timerSettings += 3;
                break;
            case FOUR:
                timerSettings += 4;
                break;
            case FIVE:
                timerSettings += 5;
                break;
            case SIX:
                timerSettings += 6;
                break;
            case SEVEN:
                timerSettings += 7;
                break;
            case EIGHT:
                timerSettings += 8;
                break;
            case NINE:
                timerSettings += 9;
                break;
            case CHANNEL:
                commandExecutor.execute(delayedShutdownCommand, String.valueOf(Long.valueOf(timerSettings) * 60));
                clearTimer();
                break;
            case PLAY_PAUSE:
                commandExecutor.execute(delayedShutdownCancelCommand);
                clearTimer();
                break;
        }
    }

    @Autowired
    public void setDelayedShutdownCommand(DelayedShutdownCommand delayedShutdownCommand) {
        this.delayedShutdownCommand = delayedShutdownCommand;
    }

    @Autowired
    public void setDelayedShutdownCancelCommand(DelayedShutdownCancelCommand delayedShutdownCancelCommand) {
        this.delayedShutdownCancelCommand = delayedShutdownCancelCommand;
    }
}

