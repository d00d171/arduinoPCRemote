package pl.ciochon.arduino.serial.menu.state.impl;

import pl.ciochon.arduino.serial.core.command.impl.DelayedShutdownCommand;
import pl.ciochon.arduino.serial.menu.state.MenuState;
import pl.ciochon.arduino.serial.menu.state.util.NonRepeatableAction;
import pl.ciochon.arduino.serial.pilot.PilotKey;
import pl.ciochon.arduino.serial.pilot.event.PilotEvent;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static pl.ciochon.arduino.serial.pilot.PilotKey.*;

/**
 * Created by Konrad Ciochoń on 2017-02-24.
 */
public class DelayedShutdownPlanState extends MenuState {

    public static final String NAME = "DELAYED_SHUTDOWN_PLAN";

    private static Map<PilotKey, String> numericalValues;

    static {
        numericalValues = new HashMap<PilotKey, String>() {{
            put(ONE, "1");
            put(TWO, "2");
            put(THREE, "3");
            put(FOUR, "4");
            put(FIVE, "5");
            put(SIX, "6");
            put(SEVEN, "7");
            put(EIGHT, "8");
            put(NINE, "9");
            put(ZERO, "0");
        }};
    }

    private JTextField textField;

    private JPanel centerPanelContent;

    private String shutdownAfter = "";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void onTransition() {
        super.onTransition();
        OSDMenuView.setHeader("header.delayedShutdownPlan");
        OSDMenuView.setCenterPanel(centerPanelContent);
    }

    @Override
    public String onPilotEventAfterMenuShow(PilotEvent pilotEvent) {
        switch (pilotEvent.getPilotKey()) {
            case EXIT:
                return NonRepeatableAction.perform(pilotEvent, DelayedShutdownState.NAME);
            case ENTER:
                return NonRepeatableAction.performFunctionWithReturnValue(pilotEvent, () -> {
                    Long commandArg = getShutdownAfterInMinutes();
                    if (commandArg != null) {
                        commandExecutor.execute(new DelayedShutdownCommand(commandArg));
                        OSDMenuView.toggleVisibility(false);
                        return IdleState.NAME;
                    } else {
                        return null;
                    }
                });
            case LEFT:
                if (shutdownAfter.length() != 0) {
                    shutdownAfter = shutdownAfter.substring(0, shutdownAfter.length() - 1);
                    textField.setText(shutdownAfter);
                }
                break;
            case ONE:
            case TWO:
            case THREE:
            case FOUR:
            case FIVE:
            case SIX:
            case SEVEN:
            case EIGHT:
            case NINE:
            case ZERO:
                //TODO non repeatable
                addText(numericalValues.get(pilotEvent.getPilotKey()));
                break;
        }
        return null;
    }

    private void addText(String value) {
        shutdownAfter += value;
        textField.setText(shutdownAfter);
    }

    private Long getShutdownAfterInMinutes() {
        try {
            return Long.valueOf(shutdownAfter) * 60;
        } catch (Exception e) {
            return null;
        }
    }

    @PostConstruct
    public void init() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());

        JLabel label = new JLabel(viewValueResolver.getViewValue("delayedShutdownPlan.after"));
        label.setFont(fonts.COMMON_FONT);
        jPanel.add(label, BorderLayout.NORTH);

        JTextField textField = new JTextField();
        textField.setFont(fonts.COMMON_FONT);
        textField.requestFocus();
        jPanel.add(textField, BorderLayout.CENTER);

        this.textField = textField;
        this.centerPanelContent = jPanel;

    }
}
