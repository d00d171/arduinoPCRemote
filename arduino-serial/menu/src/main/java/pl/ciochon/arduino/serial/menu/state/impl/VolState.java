package pl.ciochon.arduino.serial.menu.state.impl;

import pl.ciochon.arduino.serial.lcdWriter.util.BigSign;
import pl.ciochon.arduino.serial.lcdWriter.util.BigTextBuilder;
import pl.ciochon.arduino.serial.menu.state.MenuState;

/**
 * Created by Konrad Ciochoń on 2017-02-12.
 */
public class VolState extends MenuState{

    public static final String NAME = "VOL";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void onTransition(){
        super.onTransition();
        lcdScreenController.write(new BigTextBuilder().addS(BigSign.V_LETTER).addS(BigSign.O_LETTER).add(BigSign.L_LETTER).build());
    }

}
