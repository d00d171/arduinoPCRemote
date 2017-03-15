package pl.ciochon.arduino.serial.menu;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import pl.ciochon.arduino.serial.menu.state.MenuState;
import pl.ciochon.arduino.serial.menu.state.impl.IdleState;
import pl.ciochon.arduino.serial.pilot.event.PilotEvent;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
public class Menu implements ApplicationContextAware {

    private IdleState idleState;

    private MenuState currentState;

    private ApplicationContext applicationContext;

    public void initialize() {
        currentState = idleState;
        currentState.onTransition();
    }

    public void interpretPilotEvent(PilotEvent pilotEvent) {
        String transitionToState = currentState.onPilotEvent(pilotEvent);
        if (transitionToState != null) {
            MenuState state = (MenuState) applicationContext.getBean(transitionToState);
            currentState.beforeExit();
            currentState = state;
            currentState.onTransition();
        }
    }

    @Autowired
    public void setIdleState(IdleState idleState) {
        this.idleState = idleState;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}