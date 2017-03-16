package pl.ciochon.arduino.serial.menu.state;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import pl.ciochon.arduino.serial.core.command.CommandExecutor;
import pl.ciochon.arduino.serial.core.command.impl.DelayedShutdownCommand;
import pl.ciochon.arduino.serial.core.command.impl.MuteCommand;
import pl.ciochon.arduino.serial.core.command.impl.VolumeChangeCommand;
import pl.ciochon.arduino.serial.menu.state.impl.DelayedShutdownState;
import pl.ciochon.arduino.serial.menu.state.util.NonRepeatableAction;
import pl.ciochon.arduino.serial.menu.view.OSDMenuView;
import pl.ciochon.arduino.serial.menu.view.ViewableListCellRenderer;
import pl.ciochon.arduino.serial.menu.view.util.Fonts;
import pl.ciochon.arduino.serial.menu.view.util.ViewValueResolver;
import pl.ciochon.arduino.serial.pilot.event.PilotEvent;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
public abstract class MenuState {

    private static final Logger logger = Logger.getLogger(MenuState.class);

    private static final Long HIDE_MENU_AFTER_SECONDS = 5L;

    @Autowired
    protected CommandExecutor commandExecutor;

    @Autowired
    protected OSDMenuView OSDMenuView;

    @Autowired
    protected Fonts fonts;

    @Autowired
    protected ViewableListCellRenderer viewableListCellRenderer;

    @Autowired
    protected ViewValueResolver viewValueResolver;

    private Timer timer;

    private void resetTimer() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                OSDMenuView.toggleVisibility(false);
            }
        };
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        timer.schedule(timerTask, HIDE_MENU_AFTER_SECONDS * 1000);
    }

    public abstract String getName();

    public String onPilotEvent(PilotEvent pilotEvent) {
        Optional<String> result = onPilotEventCommon(pilotEvent);
        if (result.isPresent()) {
            return StringUtils.isEmpty(result.get()) ? null : result.get();
        } else {
            switch (pilotEvent.getPilotKey()) {
                case VOL_MINUS:
                    commandExecutor.execute(new VolumeChangeCommand(-(1000L + 200 * pilotEvent.getRepeatCount())));
                    return null;
                case VOL_PLUS:
                    commandExecutor.execute(new VolumeChangeCommand(1000L + 200 * pilotEvent.getRepeatCount()));
                    return null;
                case MUTE:
                    return NonRepeatableAction.performCommand(pilotEvent, new MuteCommand());
                case POWER:
                    return NonRepeatableAction.performCommand(pilotEvent, new DelayedShutdownCommand(0L));
                case MENU:
                    return NonRepeatableAction.performVoidFunction(pilotEvent, this::toggleMenuVisibility);
                case SLEEP:
                    return NonRepeatableAction.performVoidFunction(pilotEvent, this::showMenu, DelayedShutdownState.NAME);
                default:
                    if (showMenu()) {
                        return null;
                    }
                    return onPilotEventAfterMenuShow(pilotEvent);
            }
        }
        // resetTimer(); TODO odkomentować w przyszłości
    }

    public Optional<String> onPilotEventCommon(PilotEvent pilotEvent) {
        return Optional.empty();
    }

    public String onPilotEventAfterMenuShow(PilotEvent pilotEvent) {
        return null;
    }

    public void beforeExit() {
        logger.debug("Leaving state: " + getName());
    }

    public void onTransition() {
        logger.debug("Transition to state: " + getName());
    }

    protected void toggleMenuVisibility() {
        boolean value = !OSDMenuView.isVisible() ? true : false;
        OSDMenuView.toggleVisibility(value);
    }

    public boolean showMenu() {
        if (!OSDMenuView.isVisible()) {
            OSDMenuView.toggleVisibility(true);
            return true;
        }
        return false;
    }

    public boolean hideMenu() {
        if (OSDMenuView.isVisible()) {
            OSDMenuView.toggleVisibility(false);
            return true;
        }
        return false;
    }

}
