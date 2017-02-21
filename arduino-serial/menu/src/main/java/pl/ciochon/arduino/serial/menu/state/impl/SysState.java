package pl.ciochon.arduino.serial.menu.state.impl;

import pl.ciochon.arduino.serial.lcdWriter.util.BigSign;
import pl.ciochon.arduino.serial.lcdWriter.util.BigTextBuilder;
import pl.ciochon.arduino.serial.menu.state.MenuState;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
public class SysState extends MenuState{

    public static final String NAME = "SYS";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void onTransition(){
        super.onTransition();
        lcdScreenController.write(new BigTextBuilder().addS(BigSign.S_LETTER).addS(BigSign.Y_LETTER).add(BigSign.S_LETTER).build());
    }

}
