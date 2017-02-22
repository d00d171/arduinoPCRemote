package pl.ciochon.arduino.serial.menu.state.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.core.command.impl.DelayedShutdownCancelCommand;
import pl.ciochon.arduino.serial.core.command.impl.DelayedShutdownCommand;
import pl.ciochon.arduino.serial.menu.state.MenuState;

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


    @Autowired
    public void setDelayedShutdownCommand(DelayedShutdownCommand delayedShutdownCommand) {
        this.delayedShutdownCommand = delayedShutdownCommand;
    }

    @Autowired
    public void setDelayedShutdownCancelCommand(DelayedShutdownCancelCommand delayedShutdownCancelCommand) {
        this.delayedShutdownCancelCommand = delayedShutdownCancelCommand;
    }
}

