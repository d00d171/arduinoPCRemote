package pl.ciochon.arduino.serial.pilot.tv;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.core.command.impl.*;
import pl.ciochon.arduino.serial.pilot.core.PilotKey;
import pl.ciochon.arduino.serial.pilot.core.event.dispatcher.PilotEventDispatcher;

/**
 * Created by Konrad Ciochoń on 2017-02-09.
 */
public class TvPilotEventDispatcher extends PilotEventDispatcher {

    private VolumeUpCommand volumeUpCommand;

    private VolumeDownCommand volumeDownCommand;

    private MuteCommand muteCommand;

    private DelayedShutdownCancelCommand delayedShutdownCancelCommand;

    private DelayedShutdownCommand delayedShutdownCommand;

    protected void dispatch(PilotKey pilotKey) {
        switch (pilotKey) {
            case VOLUME_UP:
                commandExecutor.execute(volumeUpCommand);
                break;
            case VOLUME_DOWN:
                commandExecutor.execute(volumeDownCommand);
                break;
            case MUTE:
                commandExecutor.execute(muteCommand);
                break;
            case POWER:
                commandExecutor.execute(delayedShutdownCommand, "-3600");
                break;
            case CANCEL:
                commandExecutor.execute(delayedShutdownCancelCommand);
        }
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

    @Autowired
    public void setDelayedShutdownCancelCommand(DelayedShutdownCancelCommand delayedShutdownCancelCommand) {
        this.delayedShutdownCancelCommand = delayedShutdownCancelCommand;
    }

    @Autowired
    public void setDelayedShutdownCommand(DelayedShutdownCommand delayedShutdownCommand) {
        this.delayedShutdownCommand = delayedShutdownCommand;
    }
}
