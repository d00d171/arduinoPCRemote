package pl.ciochon.arduino.serial.menu.state.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.core.command.impl.DelayedShutdownCancelCommand;
import pl.ciochon.arduino.serial.menu.state.MenuState;
import pl.ciochon.arduino.serial.menu.state.util.Option;
import pl.ciochon.arduino.serial.menu.windows.view.ViewableScrollPane;
import pl.ciochon.arduino.serial.pilot.core.PilotKey;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * Created by Konrad Ciochoń on 2017-02-12.
 */
public class DelayedShutdownState extends MenuState {

    public static final String NAME = "DELAYED_SHUTDOWN";

    private Option[] optionList = new Option[]{Option.DSS_PLAN, Option.DSS_CANCEL_PLANNED};

    private ViewableScrollPane<Option> viewableScrollPane;

    @Autowired
    private DelayedShutdownCancelCommand delayedShutdownCancelCommand;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void onTransition() {
        super.onTransition();
        windowsMenuController.setHeder("header.delayedShutdown");
        windowsMenuController.setCenterPanel(viewableScrollPane.getView());
    }

    @Override
    public String onKeyPressAfterShow(PilotKey pilotKey) {
        switch (pilotKey) {
            case EQ:
                return SysState.NAME;
            case CHANNEL_PLUS:
                viewableScrollPane.scrollDown();
                break;
            case CHANNEL_MINUS:
                viewableScrollPane.scrollUp();
                break;
            case CHANNEL:
                switch (viewableScrollPane.getSelectedValue()) {
                    case DSS_CANCEL_PLANNED:
                        commandExecutor.execute(delayedShutdownCancelCommand);
                        windowsMenuController.toggleVisibility(false);
                        return IdleState.NAME;
                    case DSS_PLAN:
                        return DelayedShutdownPlanState.NAME;
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
