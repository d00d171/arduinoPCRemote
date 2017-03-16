package pl.ciochon.arduino.serial.menu.state.util;

import pl.ciochon.arduino.serial.menu.view.Viewable;

/**
 * Created by Konrad Ciochoń on 2017-02-24.
 */
public enum Option implements Viewable {
    MM_SYSTEM("mainMenu.option.system"),
    MM_MPC("mainMenu.option.mediaPlayerClass"),
    SYS_DELAYED_SHUTDOWN("system.option.delayedShutdown"),
    SYS_SHUTDOWN("system.option.shutdown"),
    SYS_CURSOR_CONTROL("system.option.cursorControl"),
    DSS_PLAN("delayShutdown.option.plan"),
    DSS_CANCEL_PLANNED("delayShutdown.option.cancel");


    private String viewValueKey;

    Option(String viewValueKey) {
        this.viewValueKey = viewValueKey;
    }

    @Override
    public String getViewValueKey() {
        return viewValueKey;
    }
}
