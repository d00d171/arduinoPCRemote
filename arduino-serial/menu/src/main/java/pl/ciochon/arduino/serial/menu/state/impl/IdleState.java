package pl.ciochon.arduino.serial.menu.state.impl;

import pl.ciochon.arduino.serial.menu.state.MenuState;
import pl.ciochon.arduino.serial.menu.state.util.Option;
import pl.ciochon.arduino.serial.menu.windows.view.ViewableScrollPane;
import pl.ciochon.arduino.serial.pilot.core.PilotKey;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
public class IdleState extends MenuState {

    public static final String NAME = "IDLE";

    private Option[] optionList = new Option[]{Option.MM_SYSTEM, Option.MM_MPC};

    private ViewableScrollPane<Option> viewableScrollPane;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void onTransition() {
        super.onTransition();
        windowsMenuController.setHeder("header.mainMenu");
        windowsMenuController.setCenterPanel(viewableScrollPane.getView());
    }

    @Override
    public String onKeyPressAfterShow(PilotKey pilotKey) {
        switch (pilotKey) {
            case EQ:
                hideMenu();
                break;
            case CHANNEL_PLUS:
                viewableScrollPane.scrollDown();
                break;
            case CHANNEL_MINUS:
                viewableScrollPane.scrollUp();
                break;
            case CHANNEL:
                switch (viewableScrollPane.getSelectedValue()) {
                    case MM_MPC:
                        return MpcState.NAME;
                    case MM_SYSTEM:
                        return SysState.NAME;
                    default:
                        return null;
                }
        }
        return null;
    }

    @PostConstruct
    public void init() {
        viewableScrollPane = new ViewableScrollPane(optionList, fonts.OPTIONS_FONT, Optional.of(viewableListCellRenderer));
    }

}

