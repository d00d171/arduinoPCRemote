package pl.ciochon.arduino.serial.menu.state.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.core.command.impl.DelayedShutdownCommand;
import pl.ciochon.arduino.serial.menu.state.MenuState;
import pl.ciochon.arduino.serial.menu.state.util.Option;
import pl.ciochon.arduino.serial.menu.windows.view.ViewableScrollPane;
import pl.ciochon.arduino.serial.pilot.core.PilotKey;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
public class SysState extends MenuState {

    public static final String NAME = "SYS";

    private Option[] optionList = new Option[]{Option.SYS_DELAYED_SHUTDOWN, Option.SYS_SHUTDOWN};

    private ViewableScrollPane<Option> viewableScrollPane;

    @Autowired
    private DelayedShutdownCommand delayedShutdownCommand;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void onTransition() {
        super.onTransition();
        windowsMenuController.setHeder("header.system");
        windowsMenuController.setCenterPanel(viewableScrollPane.getView());
    }

    @Override
    public String onKeyPressAfterShow(PilotKey pilotKey) {
        switch (pilotKey) {
            case EQ:
                return IdleState.NAME;
            case CHANNEL_PLUS:
                viewableScrollPane.scrollDown();
                break;
            case CHANNEL_MINUS:
                viewableScrollPane.scrollUp();
                break;
            case CHANNEL:
                switch (viewableScrollPane.getSelectedValue()) {
                    case SYS_SHUTDOWN:
                        commandExecutor.execute(delayedShutdownCommand, "0");
                        return null;
                    case SYS_DELAYED_SHUTDOWN:
                        return DelayedShutdownState.NAME;
                }
        }
        return null;
    }

    @PostConstruct
    public void init() {
        viewableScrollPane = new ViewableScrollPane(optionList, fonts.OPTIONS_FONT, Optional.of(viewableListCellRenderer));
    }

}
