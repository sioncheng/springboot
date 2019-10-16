package com.github.sioncheng.sb.statemachine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StateMachineTest {

    @Autowired
    private StateMachinePersister<State, Event, Integer> persister;

    @Autowired
    private StateMachineBuilder.Builder<State, Event> stateEventBuilder;


    private int defaultTid = 123;

    @Test
    public void testNewToRunnable() {
        StateMachine<State, Event> stateMachine = stateEventBuilder.build();
        stateMachine.start();
        stateMachine.sendEvent(Event.START);
        Assert.assertEquals(State.RUNNABLE, stateMachine.getState().getId());
    }

    @Test
    public void testRunnableToBlock() throws Exception {
        StateMachine<State, Event> stateMachine1 = stateEventBuilder.build();

        stateMachine1.start();
        stateMachine1.sendEvent(Event.START);
        stateMachine1.sendEvent(Event.LOCK);
        Assert.assertEquals(State.BLOCKED, stateMachine1.getState().getId());

        persister.persist(stateMachine1, defaultTid);
    }
}
