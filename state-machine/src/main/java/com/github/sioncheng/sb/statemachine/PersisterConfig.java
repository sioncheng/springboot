package com.github.sioncheng.sb.statemachine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;

import java.util.EnumSet;

@Configuration
public class PersisterConfig {

    @Bean
    public StateMachinePersister<State, Event, Integer> threadStateMachinePersister(StateMachinePersist stateMachinePersist) {

        return new DefaultStateMachinePersister<>(stateMachinePersist);

    }


    @Bean
    public StateMachineBuilder.Builder<State, Event> stateEventStateMachineBuilder() throws Exception {
        StateMachineBuilder.Builder<State, Event> builder = StateMachineBuilder.builder();

        System.out.println("构建订单状态机");

        builder.configureStates()
                .withStates()
                .initial(State.NEW)
                .states(EnumSet.allOf(State.class));

        builder.configureTransitions()
                .withExternal()
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
                .event(Event.UNLOCK);

        return builder;
    }
}
