package pl.ciochon.arduino.serial.support.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.ciochon.arduino.serial.menu.state.impl.*;
import pl.ciochon.arduino.serial.menu.state.util.NonRepeatableAction;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
@Configuration
public class MenuStatesConfiguration {

    @Bean
    public NonRepeatableAction nonRepeatableCall() {
        return new NonRepeatableAction();
    }

    @Bean(name = IdleState.NAME)
    public IdleState idleState() {
        return new IdleState();
    }

    @Bean(name = SysState.NAME)
    public SysState sysState() {
        return new SysState();
    }

    @Bean(name = DelayedShutdownState.NAME)
    public DelayedShutdownState delayedShutdownState() {
        return new DelayedShutdownState();
    }

    @Bean(name = MpcState.NAME)
    public MpcState mpcState() {
        return new MpcState();
    }

    @Bean(name = DelayedShutdownPlanState.NAME)
    public DelayedShutdownPlanState delayedShutdownPlanState() {
        return new DelayedShutdownPlanState();
    }

    @Bean(name = CursorControlState.NAME)
    public CursorControlState cursorControlState() {
        return new CursorControlState();
    }

}
