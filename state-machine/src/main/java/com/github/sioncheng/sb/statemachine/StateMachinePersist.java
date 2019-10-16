package com.github.sioncheng.sb.statemachine;

import org.springframework.statemachine.StateMachineContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class StateMachinePersist implements org.springframework.statemachine.StateMachinePersist<State, Event, Integer> {

    private HashMap<Integer, StateMachineContext<State, Event>> stateMachineContextHashMap = new HashMap<>();

    @Override
    public StateMachineContext<State, Event> read(Integer tid) throws Exception {
        return stateMachineContextHashMap.get(tid);
    }

    @Override
    public void write(StateMachineContext<State, Event> stateMachineContext, Integer tid) throws Exception {
        stateMachineContextHashMap.put(tid, stateMachineContext);
    }
}
