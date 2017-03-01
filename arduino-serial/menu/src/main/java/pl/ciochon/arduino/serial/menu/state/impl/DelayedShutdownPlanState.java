package pl.ciochon.arduino.serial.menu.state.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.core.command.impl.DelayedShutdownCommand;
import pl.ciochon.arduino.serial.menu.state.MenuState;
import pl.ciochon.arduino.serial.pilot.core.PilotKey;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Konrad Ciochoń on 2017-02-24.
 */
public class DelayedShutdownPlanState extends MenuState {

    public static final String NAME = "DELAYED_SHUTDOWN_PLAN";

    private JTextField textField;

    private JPanel centerPanelContent;

    private String shutdownAfter = "";

    @Autowired
    private DelayedShutdownCommand delayedShutdownCommand;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void onTransition() {
        super.onTransition();
        windowsMenuController.setHeder("header.delayedShutdownPlan");
        windowsMenuController.setCenterPanel(centerPanelContent);
    }

    @Override
    public String onKeyPressAfterShow(PilotKey pilotKey) {
        switch (pilotKey) {
            case EQ:
                return DelayedShutdownState.NAME;
            case CHANNEL:
                String commandArg = getShutdownAfterInMinutes();
                if (commandArg != null) {
                    commandExecutor.execute(delayedShutdownCommand, commandArg);
                    windowsMenuController.toggleVisibility(false);
                    return IdleState.NAME;
                } else {
                    return null;
                }
            case CHANNEL_MINUS:
                if (shutdownAfter.length() != 0) {
                    shutdownAfter = shutdownAfter.substring(0, shutdownAfter.length() - 1);
                    textField.setText(shutdownAfter);
                }
                break;
            case ONE:
                addText("1");
                break;
            case TWO:
                addText("2");
                break;
            case THREE:
                addText("3");
                break;
            case FOUR:
                addText("4");
                break;
            case FIVE:
                addText("5");
                break;
            case SIX:
                addText("6");
                break;
            case SEVEN:
                addText("7");
                break;
            case EIGHT:
                addText("8");
                break;
            case NINE:
                addText("9");
                break;
            case ZERO:
                addText("0");
                break;
        }
        return null;
    }

    private void addText(String value) {
        shutdownAfter += value;
        textField.setText(shutdownAfter);
    }

    private String getShutdownAfterInMinutes() {
        try {
            return String.valueOf(Integer.valueOf(shutdownAfter) * 60);
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
