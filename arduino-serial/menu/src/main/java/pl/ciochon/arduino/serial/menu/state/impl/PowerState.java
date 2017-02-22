package pl.ciochon.arduino.serial.menu.state.impl;

import pl.ciochon.arduino.serial.menu.state.MenuState;

/**
 * Created by Konrad Ciochoń on 2017-02-12.
 */
public class PowerState extends MenuState {

    public static final String NAME = "POWER";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void onTransition() {
        super.onTransition();
    }

}
