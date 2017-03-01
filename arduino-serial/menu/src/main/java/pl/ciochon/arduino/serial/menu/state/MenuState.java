package pl.ciochon.arduino.serial.menu.state;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.core.command.CommandExecutor;
import pl.ciochon.arduino.serial.core.command.impl.VolumeDownCommand;
import pl.ciochon.arduino.serial.core.command.impl.VolumeUpCommand;
import pl.ciochon.arduino.serial.menu.windows.WindowsMenuController;
import pl.ciochon.arduino.serial.menu.windows.util.Fonts;
import pl.ciochon.arduino.serial.menu.windows.util.Icons;
import pl.ciochon.arduino.serial.menu.windows.util.ViewValueResolver;
import pl.ciochon.arduino.serial.menu.windows.view.ViewableListCellRenderer;
import pl.ciochon.arduino.serial.pilot.core.PilotKey;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
public abstract class MenuState {

    private static final Long HIDE_MENU_AFTER_SECONDS = 5L;

    @Autowired
    protected CommandExecutor commandExecutor;

    @Autowired
    protected VolumeDownCommand volumeDownCommand;

    @Autowired
    protected VolumeUpCommand volumeUpCommand;

    @Autowired
    protected WindowsMenuController windowsMenuController;

    @Autowired
    protected Fonts fonts;

    @Autowired
    protected ViewableListCellRenderer viewableListCellRenderer;

    @Autowired
    protected Icons icons;

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

    //returns name of state to transition to
    public String onKeyPress(PilotKey pilotKey) {
        String result = null;
        if (!performCommonAction(pilotKey)) {
            if (!windowsMenuController.isVisible()) {
                showMenu();
            } else {
                result = onKeyPressAfterShow(pilotKey);
            }
            // resetTimer(); TODO odkomentować w przyszłości
            return result;
        }
        return null;
    }

    private boolean performCommonAction(PilotKey pilotKey) {
        switch (pilotKey) {
            case VOLUME_DOWN:
                commandExecutor.execute(volumeDownCommand);
                return true;
            case VOLUME_UP:
                commandExecutor.execute(volumeUpCommand);
                return true;
        }
        return false;
    }

    public String onKeyPressAfterShow(PilotKey pilotKey) {
        return null;
    }

    public void beforeExit() {
        System.out.println("Leaving state: " + getName());
    }

    public void onTransition() {
        System.out.println("Transition to state: " + getName());
    }

    public void showMenu() {
        if (!windowsMenuController.isVisible()) {
            windowsMenuController.toggleVisibility(true);
        }
    }

    public void hideMenu() {
        if (windowsMenuController.isVisible()) {
            windowsMenuController.toggleVisibility(false);
        }
    }

}
