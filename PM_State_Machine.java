package com.poshmark.utils.sharing;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by nikhilsohoni on 10/11/15.
 */
public abstract class PM_State_Machine {

    //int [][] transitions = {};

    Map<State, State> transitions = new HashMap<State, State>();

    State currentState;
    public static enum  STATE_COMPLETION_RESULT {OK, FAILED, CANCEL};


    class  State {
        StateCompletionListener listener;
        UUID    id;
        public State(StateCompletionListener listener) {
            this.listener = listener;
            id = UUID.randomUUID();
        }
        public UUID getId() {
            return id;
        }
        public void executeState(){};
    }

    class FB_INIT extends State {
        public FB_INIT(StateCompletionListener listener) {
            super(listener);
        }

        public void executeState() {
            //Fb share init...
            listener.stateCompleted();
        }
    }

    class FB_GET_CONTENT extends State {
        public FB_GET_CONTENT(StateCompletionListener listener) {
            super(listener);
        }

        public void executeState() {
            //Fb get content...
        }
    }

    class FB_GET_BACKUP_CONTENT extends State {
        public FB_GET_BACKUP_CONTENT(StateCompletionListener listener) {
            super(listener);
        }

        public void executeState() {
            //Fb get content...
        }
    }

    class TW_INIT extends State {
        public TW_INIT(StateCompletionListener listener) {
            super(listener);
        }

        public void executeState() {
            //Fb share init...
        }
    }

    class TW_GET_CONTENT extends State {
        public TW_GET_CONTENT(StateCompletionListener listener) {
            super(listener);
        }

        public void executeState() {
            //Fb get content...
        }
    }
}

