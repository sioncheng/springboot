package com.github.sioncheng.sb.statemachine;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApp.class)
public class StateMachineTest {

    @Autowired
    private StateMachinePersister<State, Event, Integer> persister;

    @Autowired
    private StateMachineFactory<State, Event> stateMachineFactory;


    private int defaultTid = 123;

    @Test
    public void testNewToRunnable() {
        StateMachine<State, Event> stateMachine = stateMachineFactory.getStateMachine();
        stateMachine.start();
        stateMachine.sendEvent(Event.START);

        Assert.assertEquals(State.RUNNABLE, stateMachine.getState().getId());
    }


    @Test
    public void testRunnableToBlock() {
        StateMachine<State, Event> stateMachine = stateMachineFactory.getStateMachine();
        stateMachine.start();
        stateMachine.sendEvent(Event.START);
        stateMachine.sendEvent(Event.LOCK);

        Assert.assertEquals(State.BLOCKED, stateMachine.getState().getId());

    }

    @Test
    public void testBlockToRunnable() {
        StateMachine<State, Event> stateMachine = stateMachineFactory.getStateMachine();
        stateMachine.start();
        stateMachine.sendEvent(Event.START);
        stateMachine.sendEvent(Event.LOCK);
        stateMachine.sendEvent(Event.UNLOCK);

        Assert.assertEquals(State.RUNNABLE, stateMachine.getState().getId());
    }
}
