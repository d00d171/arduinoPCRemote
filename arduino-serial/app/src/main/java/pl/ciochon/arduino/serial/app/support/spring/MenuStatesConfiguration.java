package pl.ciochon.arduino.serial.app.support.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.ciochon.arduino.serial.menu.state.impl.*;
import pl.ciochon.arduino.serial.pilot.core.PilotKey;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
@Configuration
public class MenuStatesConfiguration {

    @Bean(name = IdleState.NAME)
    public IdleState idleState() {
        IdleState idleState = new IdleState();
        Map<PilotKey, String> transitions = new HashMap();
        transitions.put(PilotKey.CHANNEL, SysState.NAME);
        idleState.setMenuTransitionMap(transitions);
        return idleState;
    }

    @Bean(name = SysState.NAME)
    public SysState sysState() {
        SysState sysState = new SysState();
        Map<PilotKey, String> transitions = new HashMap();
        transitions.put(PilotKey.EQ, IdleState.NAME);
        transitions.put(PilotKey.CHANNEL_PLUS, MpcState.NAME);
        transitions.put(PilotKey.CHANNEL_MINUS, MpcState.NAME);
        transitions.put(PilotKey.CHANNEL, VolState.NAME);
        sysState.setMenuTransitionMap(transitions);
        return sysState;
    }

    @Bean(name = VolState.NAME)
    public VolState volState() {
        VolState volState = new VolState();
        Map<PilotKey, String> transitions = new HashMap();
        transitions.put(PilotKey.EQ, SysState.NAME);
        transitions.put(PilotKey.CHANNEL_PLUS, PowerState.NAME);
        transitions.put(PilotKey.CHANNEL_MINUS, PowerState.NAME);
        transitions.put(PilotKey.CHANNEL, VolActionState.NAME);
        volState.setMenuTransitionMap(transitions);
        return volState;
    }

    @Bean(name = PowerState.NAME)
    public PowerState powerState() {
        PowerState powerState = new PowerState();
        Map<PilotKey, String> transitions = new HashMap();
        transitions.put(PilotKey.EQ, SysState.NAME);
        transitions.put(PilotKey.CHANNEL_PLUS, VolState.NAME);
        transitions.put(PilotKey.CHANNEL_MINUS, VolState.NAME);
        transitions.put(PilotKey.CHANNEL, PowerActionState.NAME);
        powerState.setMenuTransitionMap(transitions);
        return powerState;
    }

    @Bean(name = PowerActionState.NAME)
    public PowerActionState powerActionState() {
        PowerActionState powerActionState = new PowerActionState();
        Map<PilotKey, String> transitions = new HashMap();
        transitions.put(PilotKey.EQ, PowerState.NAME);
        powerActionState.setMenuTransitionMap(transitions);
        return powerActionState;
    }

    @Bean(name = VolActionState.NAME)
    public VolActionState volActionState() {
        VolActionState volActionState = new VolActionState();
        Map<PilotKey, String> transitions = new HashMap();
        transitions.put(PilotKey.EQ, VolState.NAME);
        volActionState.setMenuTransitionMap(transitions);
        return volActionState;
    }

    @Bean(name = MpcState.NAME)
    public MpcState mpcState() {
        MpcState mpcState = new MpcState();
        Map<PilotKey, String> transitions = new HashMap();
        transitions.put(PilotKey.EQ, IdleState.NAME);
        transitions.put(PilotKey.CHANNEL_PLUS, SysState.NAME);
        transitions.put(PilotKey.CHANNEL_MINUS, SysState.NAME);
        mpcState.setMenuTransitionMap(transitions);
        return mpcState;
    }

}
