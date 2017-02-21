package pl.ciochon.arduino.serial.menu.state;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.core.command.CommandExecutor;
import pl.ciochon.arduino.serial.lcdWriter.LcdScreenController;
import pl.ciochon.arduino.serial.pilot.core.PilotKey;

import java.util.Map;


/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
public abstract class MenuState {

    protected CommandExecutor commandExecutor;

    protected LcdScreenController lcdScreenController;

    protected Map<PilotKey, String> menuTransitionMap;

    public abstract String getName();

    public void setMenuTransitionMap(Map<PilotKey, String> menuTransitionMap) {
        this.menuTransitionMap = menuTransitionMap;
    }

    public Map<PilotKey, String> getPossibleTransitions() {
        return menuTransitionMap;
    }

    public void onKeyPress(PilotKey pilotKey) {
    }

    public void beforeExit() {
        System.out.println("Leaving state: " + getName());
    }

    public void onTransition() {
        System.out.println("Transition to state: " + getName());
    }

    @Autowired
    public void setLcdScreenController(LcdScreenController lcdScreenController) {
        this.lcdScreenController = lcdScreenController;
    }

    @Autowired
    public void setCommandExecutor(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

}
