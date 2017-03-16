package pl.ciochon.arduino.serial.menu.state.impl;

import pl.ciochon.arduino.serial.core.command.impl.DelayedShutdownCommand;
import pl.ciochon.arduino.serial.menu.state.MenuState;
import pl.ciochon.arduino.serial.menu.state.util.Option;
import pl.ciochon.arduino.serial.menu.view.ViewableScrollPane;
import pl.ciochon.arduino.serial.pilot.event.PilotEvent;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
public class SysState extends MenuState {

    public static final String NAME = "SYS";

    private Option[] optionList = new Option[]{Option.SYS_DELAYED_SHUTDOWN, Option.SYS_SHUTDOWN, Option.SYS_CURSOR_CONTROL};

    private ViewableScrollPane<Option> viewableScrollPane;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void onTransition() {
        super.onTransition();
        OSDMenuView.setHeader("header.system");
        OSDMenuView.setCenterPanel(viewableScrollPane.getView());
    }

    @Override
    public String onPilotEventAfterMenuShow(PilotEvent pilotEvent) {
        switch (pilotEvent.getPilotKey()) {
            case EXIT:
                return IdleState.NAME;
            case DOWN:
                viewableScrollPane.scrollDown();
                break;
            case UP:
                viewableScrollPane.scrollUp();
                break;
            case ENTER:
                switch (viewableScrollPane.getSelectedValue()) {
                    case SYS_SHUTDOWN:
                        commandExecutor.execute(new DelayedShutdownCommand(0L));
                        return null;
                    case SYS_DELAYED_SHUTDOWN:
                        return DelayedShutdownState.NAME;
                    case SYS_CURSOR_CONTROL:
                        return CursorControlState.NAME;
                }
        }
        return null;
    }

    @PostConstruct
    public void init() {
        viewableScrollPane = new ViewableScrollPane(optionList, fonts.OPTIONS_FONT, Optional.of(viewableListCellRenderer));
    }

}
