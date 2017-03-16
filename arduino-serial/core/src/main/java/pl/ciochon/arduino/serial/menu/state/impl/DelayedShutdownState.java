package pl.ciochon.arduino.serial.menu.state.impl;

import pl.ciochon.arduino.serial.core.command.impl.DelayedShutdownCancelCommand;
import pl.ciochon.arduino.serial.menu.state.MenuState;
import pl.ciochon.arduino.serial.menu.state.util.Option;
import pl.ciochon.arduino.serial.menu.view.ViewableScrollPane;
import pl.ciochon.arduino.serial.pilot.event.PilotEvent;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * Created by Konrad Ciochoń on 2017-02-12.
 */
public class DelayedShutdownState extends MenuState {

    public static final String NAME = "DELAYED_SHUTDOWN";

    private Option[] optionList = new Option[]{Option.DSS_PLAN, Option.DSS_CANCEL_PLANNED};

    private ViewableScrollPane<Option> viewableScrollPane;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void onTransition() {
        super.onTransition();
        OSDMenuView.setHeader("header.delayedShutdown");
        OSDMenuView.setCenterPanel(viewableScrollPane.getView());
    }

    @Override
    public String onPilotEventAfterMenuShow(PilotEvent pilotEvent) {
        switch (pilotEvent.getPilotKey()) {
            case EXIT:
                return SysState.NAME;
            case DOWN:
                viewableScrollPane.scrollDown();
                break;
            case UP:
                viewableScrollPane.scrollUp();
                break;
            case ENTER:
                switch (viewableScrollPane.getSelectedValue()) {
                    case DSS_CANCEL_PLANNED:
                        commandExecutor.execute(new DelayedShutdownCancelCommand());
                        OSDMenuView.toggleVisibility(false);
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
