package com.poshmark.utils.sharing;

/**
 * Created by nikhilsohoni on 10/11/15.
 */
public class FB_Sharing_State_Machine extends PM_State_Machine implements StateCompletionListener{
    public FB_Sharing_State_Machine() {
       //init the transitions
        //create the start state
        currentState = new FB_INIT(this);

        //add all the other states in the transaction map
        State state = new FB_GET_CONTENT(this);
        transitions.put(currentState, state);

        state = new FB_GET_BACKUP_CONTENT(this);


    }

    public void init() {
        currentState.executeState();
    }

    @Override
    public void stateCompleted() {
        //current state done...do a transition
        currentState = transitions.get(currentState);

    }

    @Override
    public void stateFailed() {

    }
}
