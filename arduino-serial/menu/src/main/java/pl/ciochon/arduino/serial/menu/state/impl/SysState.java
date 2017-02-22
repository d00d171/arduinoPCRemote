package pl.ciochon.arduino.serial.menu.state.impl;

import pl.ciochon.arduino.serial.menu.state.MenuState;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
public class SysState extends MenuState {

    public static final String NAME = "SYS";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void onTransition() {
        super.onTransition();
        windowsMenuController.setCenterPanel(menuUtil.createOptions(new String[]{messages.DELAYED_SHUTDOWN}));
    }

}
