package pl.ciochon.arduino.serial.menu.state.impl;

import pl.ciochon.arduino.serial.core.command.impl.MouseClickCommand;
import pl.ciochon.arduino.serial.core.command.impl.MoveCursorCommand;
import pl.ciochon.arduino.serial.menu.state.MenuState;
import pl.ciochon.arduino.serial.pilot.event.PilotEvent;

import java.util.Optional;

/**
 * Created by Konrad Ciochoń on 2017-03-01.
 */
public class CursorControlState extends MenuState {

    public static final String NAME = "CURSOR_CONTROL_STATE";

    private static final Integer MOVE_X = 10;

    private static final Integer MOVE_Y = 10;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Optional<String> onPilotEventCommon(PilotEvent pilotEvent) {
        switch (pilotEvent.getPilotKey()) {
            case EXIT:
                return Optional.of(SysState.NAME);
            case LEFT:
                commandExecutor.execute(new MoveCursorCommand(-1 * applyRepeat(pilotEvent, MOVE_X), 0));
                return Optional.ofNullable("");
            case RIGHT:
                commandExecutor.execute(new MoveCursorCommand(applyRepeat(pilotEvent, MOVE_X), 0));
                return Optional.ofNullable("");
            case UP:
                commandExecutor.execute(new MoveCursorCommand(0, -1 * applyRepeat(pilotEvent, MOVE_Y)));
                return Optional.ofNullable("");
            case DOWN:
                commandExecutor.execute(new MoveCursorCommand(0, applyRepeat(pilotEvent, MOVE_Y)));
                return Optional.ofNullable("");
            case ENTER:
                commandExecutor.execute(new MouseClickCommand());
                return Optional.ofNullable("");
            default:
                return Optional.empty();
        }
    }

    private Integer applyRepeat(PilotEvent pilotEvent, Integer moveValue) {
        return moveValue + pilotEvent.getRepeatCount();
    }

}
