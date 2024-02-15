/**
 * @author: Itmam Alam
 * @class: Machine
 * @created: 17.10.2023
 **/

package dealab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Machine {
    private HashMap<String, State> states;
    private State startState;
    private String[] alphabet;

    public Machine(String[] alphabet) {
        states = new HashMap<String, State>();
        this.alphabet = alphabet;
    }

    public Machine(String fileName) {
        states = new HashMap<String, State>();
        try {
            Scanner sc = new Scanner(new File(fileName));
            String line;
            alphabet = sc.nextLine().split("-"); // get alphabet

            while (sc.hasNextLine() && (line = sc.nextLine()) != null) { // get alphabet and transitions and states
                if (line.contains("-")) { // if line contains '-' anywhere it is a transition
                    String[] parts = line.split("-");
                    if (states != null && states.containsKey(parts[0]))
                        addSuccessor(parts[0], parts[1], parts[2]); // add transition
                } else {
                    if (line.startsWith("(")) { // else it is a state, if it starts with '(' it is an end state
                        String state = line.substring(1, line.length() - 1);
                        addState(state, true); // add state as endState
                    } else
                        addState(line, false); // add state
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found! Check if the file path is correct");
        }
    }

    public boolean addState(String description, boolean endState) {
        if (states.isEmpty()) { // if first state => startState
            states.put(description, new State(description, endState));
            setStartState(states.get(description));
        } else if (states.containsKey(description))
            return false;
        else
            states.put(description, new State(description, endState));
        return true;
    }

    public boolean addSuccessor(String state, String input, String successor) {
        if ((!states.containsKey(state)) ||
                (!states.containsKey(successor)) ||
                (!isInAlphabet(input))
        )
            return false;
        states.get(state).addSuccessor(input, states.get(successor));
        return true;
    }

    public boolean isValidMachine() {
        if (startState == null || states.isEmpty() || alphabet.length == 0)
            return false;
        for (State s : states.values()) { // check if a state has
            for (String a : alphabet) {
                if (s.getSuccessor(a) == null)
                    return false;
            }
        }
        return true;
    }

    public boolean run(String[] input) {
        State state = startState;
        for (String token : input) {
            state = state.getSuccessor(token);
        }
        return state.isEndState();
    }

    public static Machine ImportMachine(String fileName) {
        return new Machine(fileName);
    }

    public void print() {
        // TODO
    }

    public void save() {
        // TODO
    }

    private void setStartState(State startState) {
        this.startState = startState;
    }

    private boolean isInAlphabet(String input) {
        for (String a : alphabet) {
            if (a.equals(input))
                return true;
        }
        return false;
    }
}
