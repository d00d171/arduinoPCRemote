package pl.ciochon.arduino.serial.menu.state;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import pl.ciochon.arduino.serial.core.command.CommandExecutor;
import pl.ciochon.arduino.serial.core.command.impl.DelayedShutdownCommand;
import pl.ciochon.arduino.serial.core.command.impl.MuteCommand;
import pl.ciochon.arduino.serial.core.command.impl.VolumeChangeCommand;
import pl.ciochon.arduino.serial.menu.state.impl.DelayedShutdownState;
import pl.ciochon.arduino.serial.menu.windows.WindowsMenuController;
import pl.ciochon.arduino.serial.menu.windows.util.Fonts;
import pl.ciochon.arduino.serial.menu.windows.util.ViewValueResolver;
import pl.ciochon.arduino.serial.menu.windows.view.ViewableListCellRenderer;
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
    protected WindowsMenuController windowsMenuController;

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
                windowsMenuController.toggleVisibility(false);
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
                    commandExecutor.execute(new MuteCommand());
                    return null;
                case POWER:
                    commandExecutor.execute(new DelayedShutdownCommand(0L));
                    return null;
                case MENU:
                    toggleMenuVisibility();
                    return null;
                case SLEEP:
                    showMenu();
                    return DelayedShutdownState.NAME;
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

    private void toggleMenuVisibility() {
        boolean value = !windowsMenuController.isVisible() ? true : false;
        windowsMenuController.toggleVisibility(value);
    }

    public boolean showMenu() {
        if (!windowsMenuController.isVisible()) {
            windowsMenuController.toggleVisibility(true);
            return true;
        }
        return false;
    }

    public boolean hideMenu() {
        if (windowsMenuController.isVisible()) {
            windowsMenuController.toggleVisibility(false);
            return true;
        }
        return false;
    }

}
