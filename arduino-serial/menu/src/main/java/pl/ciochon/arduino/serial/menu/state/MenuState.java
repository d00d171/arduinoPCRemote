package pl.ciochon.arduino.serial.menu.state;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.core.command.CommandExecutor;
import pl.ciochon.arduino.serial.menu.windows.MenuUtil;
import pl.ciochon.arduino.serial.menu.windows.Messages;
import pl.ciochon.arduino.serial.menu.windows.WindowsMenuController;
import pl.ciochon.arduino.serial.pilot.core.PilotKey;

import java.util.Map;


/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
public abstract class MenuState {

    @Autowired
    protected CommandExecutor commandExecutor;

    @Autowired
    protected WindowsMenuController windowsMenuController;

    @Autowired
    protected MenuUtil menuUtil;

    @Autowired
    protected Messages messages;

    protected Map<PilotKey, String> menuTransitionMap;

    public abstract String getName();

    public void setMenuTransitionMap(Map<PilotKey, String> menuTransitionMap) {
        this.menuTransitionMap = menuTransitionMap;
    }

    public Map<PilotKey, String> getPossibleTransitions() {
        return menuTransitionMap;
    }

    public boolean onKeyPress(PilotKey pilotKey) {
        return false;
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
