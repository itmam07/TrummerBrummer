/**
 * @author: Itmam Alam
 * @class: State
 * @created: 17.10.2023
 **/

package dealab;

import java.io.PrintStream;
import java.util.HashMap;

public class State {
    private String description;
    private boolean endState;
    private HashMap<String, State> successors;

    public State(String description, boolean endState) {
        this.description = description;
        this.endState = endState;
        this.successors = new HashMap<String, State>();
    }

    public boolean addSuccessor(String input, State successor) {
        if (successors.containsKey(input))
            return false;
        successors.put(input, successor);
        return true;
    }

    public State getSuccessor(String input) {
        return successors.getOrDefault(input, null);
    }

    public boolean isEndState() {
        return endState;
    }

    public boolean isValidState(String[] alphabet) {
        for (String alpha : alphabet) {
            if (successors.containsKey(alpha))
                continue;
            else
                return false;
        }
        return true;
    }

    public void print(PrintStream ps) {
        // TODO
    }
}
