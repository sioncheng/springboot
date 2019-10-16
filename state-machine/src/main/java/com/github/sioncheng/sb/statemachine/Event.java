package com.github.sioncheng.sb.statemachine;

public enum Event {
    START,
    SLEEP,
    WAIT,
    WAIT_TIMEOUT,
    JOIN,
    JOIN_TIMEOUT,
    LOCK,
    UNLOCK,
    NOTIFY,
    TIMEOUT_NOTIFY,
    COMPLETION
}
