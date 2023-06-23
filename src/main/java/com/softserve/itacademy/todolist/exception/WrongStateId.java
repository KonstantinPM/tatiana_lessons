package com.softserve.itacademy.todolist.exception;

import java.util.List;
public class WrongStateId extends RuntimeException {

    public WrongStateId(long stateId, List<Long> stateList) {
        super("You set incorrect StateId: " + stateId + ". Valid state id are: " + stateList);
    }

}
