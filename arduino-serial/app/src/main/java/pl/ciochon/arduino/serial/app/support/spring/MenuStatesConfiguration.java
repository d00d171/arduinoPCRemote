package pl.ciochon.arduino.serial.app.support.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.ciochon.arduino.serial.menu.state.impl.*;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
@Configuration
public class MenuStatesConfiguration {

    @Bean(name = IdleState.NAME)
    public IdleState idleState() {
        IdleState idleState = new IdleState();
        return idleState;
    }

    @Bean(name = SysState.NAME)
    public SysState sysState() {
        SysState sysState = new SysState();
        return sysState;
    }

    @Bean(name = VolState.NAME)
    public VolState volState() {
        VolState volState = new VolState();
        return volState;
    }

    @Bean(name = DelayedShutdownState.NAME)
    public DelayedShutdownState delayedShutdownState() {
        DelayedShutdownState delayedShutdownState = new DelayedShutdownState();
        return delayedShutdownState;
    }

    @Bean(name = VolActionState.NAME)
    public VolActionState volActionState() {
        VolActionState volActionState = new VolActionState();
        return volActionState;
    }

    @Bean(name = MpcState.NAME)
    public MpcState mpcState() {
        MpcState mpcState = new MpcState();
        return mpcState;
    }

    @Bean(name = DelayedShutdownPlanState.NAME)
    public DelayedShutdownPlanState delayedShutdownPlanState() {
        return new DelayedShutdownPlanState();
    }

}
