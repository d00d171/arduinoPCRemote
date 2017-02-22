package pl.ciochon.arduino.serial.menu.state.impl;

import pl.ciochon.arduino.serial.menu.state.MenuState;
import pl.ciochon.arduino.serial.pilot.core.PilotKey;

import javax.swing.*;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
public class IdleState extends MenuState {

    public static final String NAME = "IDLE";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void onTransition() {
        super.onTransition();
        windowsMenuController.setCenterPanel(menuUtil.createOptions(new String[]{messages.SYSTEM, messages.MEDIA_PLAYER_CLASSIC}));
    }

    public boolean onKeyPress(PilotKey pilotKey) {
        boolean wasVisible = false;
        if (windowsMenuController.isVisible()) {
            wasVisible = true;
        }
        if (!wasVisible) {
            showMenu();
            return true;
        } else {
            switch (pilotKey) {
                case EQ:
                    hideMenu();
                    return true;
                case CHANNEL_PLUS:
                    JScrollPane scrollPane = (JScrollPane) windowsMenuController.getCenterPanel();
                    menuUtil.scrollPaneDown(scrollPane);
                    return true;
                case CHANNEL_MINUS:
                    JScrollPane scrollPane2 = (JScrollPane) windowsMenuController.getCenterPanel();
                    menuUtil.scrollPaneUp(scrollPane2);
                    return true;
                default:
                    return false;
            }
        }
    }

}
