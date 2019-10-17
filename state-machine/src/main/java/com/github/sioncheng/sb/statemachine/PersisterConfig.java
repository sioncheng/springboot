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
}
