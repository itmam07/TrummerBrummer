/**
 * @author : Itmam Alam
 * @class : State
 * @created : 15.11.2023
 **/

package DEA_Alam;

import java.io.PrintStream;
import java.util.HashMap;

public class State {
    private String desc;
    private boolean isEndState;
    private HashMap<String, State> successors;

    public State(String desc, boolean isEndState) {
        this.desc = desc;
        this.isEndState = isEndState;
        successors = new HashMap<String, State>();
    }

    public boolean addSuccessor(String token, State successor) {
        if (successors.containsKey(token))  // check if token already exits
            return false;

        successors.put(token, successor);  // put token in HashMap
        return true;
    }

    public State getSuccessor(String token) {
        return successors.getOrDefault(token, null);  // if token not there, return null
    }

    public boolean isEndState() {
        return isEndState;
    }

    public boolean isValid(String[] alphabet) {
        if (successors.size() < alphabet.length)  // is more tokens than successors then false
            return false;

        for (String a : alphabet)
            if (!successors.containsKey(a))  // if token not in successors return false
                return false;

        return true;
    }

    public void print(PrintStream ps) {
        if (isEndState)
            ps.print("(");
        ps.print(desc);
        if (isEndState)
            ps.print(")");
        ps.println();
    }

    public void printSuccessors(PrintStream ps) {
        for (String token : successors.keySet()) {
            ps.print(desc + "-");
            ps.print(token + "-");
            ps.print(successors.get(token).desc);
            ps.println();
        }
    }
}
