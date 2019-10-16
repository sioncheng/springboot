package com.github.sioncheng.sb.statemachine;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<State, Event> {

    @Override
    public void configure(StateMachineStateConfigurer<State, Event> states) throws Exception {
        states.withStates().initial(State.NEW)
                .states(EnumSet.allOf(State.class));
    }


    @Override
    public void configure(StateMachineTransitionConfigurer<State, Event> transitions) throws Exception {
        transitions.withExternal()
                .source(State.NEW)
                .target(State.RUNNABLE)
                .event(Event.START)
                //
                .and()
                .withExternal()
                .source(State.RUNNABLE)
                .target(State.BLOCKED)
                .event(Event.LOCK)
                //
                .and()
                .withExternal()
                .source(State.BLOCKED)
                .target(State.RUNNABLE)
                .event(Event.UNLOCK)
                //
                ;
    }
}
