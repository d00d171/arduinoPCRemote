package pl.ciochon.arduino.serial.menu.state.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.core.command.impl.MuteCommand;
import pl.ciochon.arduino.serial.core.command.impl.VolumeDownCommand;
import pl.ciochon.arduino.serial.core.command.impl.VolumeUpCommand;
import pl.ciochon.arduino.serial.menu.state.MenuState;
import pl.ciochon.arduino.serial.pilot.core.PilotKey;

/**
 * Created by Konrad Ciochoń on 2017-02-12.
 */
public class VolActionState extends MenuState {

    public static final String NAME = "VOL_ACTION";


    private VolumeUpCommand volumeUpCommand;

    private VolumeDownCommand volumeDownCommand;

    private MuteCommand muteCommand;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String onKeyPress(PilotKey pilotKey) {
        switch (pilotKey) {
            case VOLUME_UP:
                commandExecutor.execute(volumeUpCommand);
                break;
            case VOLUME_DOWN:
                commandExecutor.execute(volumeDownCommand);
                break;
            case ZERO:
                commandExecutor.execute(muteCommand);
                break;
        }
        return null;
    }

    public void onTransition() {
        super.onTransition();
    }

    public void beforeExit() {
        super.beforeExit();
    }

    @Autowired
    public void setVolumeUpCommand(VolumeUpCommand volumeUpCommand) {
        this.volumeUpCommand = volumeUpCommand;
    }

    @Autowired
    public void setVolumeDownCommand(VolumeDownCommand volumeDownCommand) {
        this.volumeDownCommand = volumeDownCommand;
    }

    @Autowired
    public void setMuteCommand(MuteCommand muteCommand) {
        this.muteCommand = muteCommand;
    }
}
