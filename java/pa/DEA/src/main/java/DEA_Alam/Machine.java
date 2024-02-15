/**
 * @author : Itmam Alam
 * @class : Machine
 * @created : 15.11.2023
 **/

package DEA_Alam;

import java.io.*;
import java.util.HashMap;

public class Machine {
    private HashMap<String, State> states;
    private String[] alphabet;
    private State startState;

    public Machine(String[] alphabet) {
        states = new HashMap<String, State>();
        this.alphabet = alphabet;
    }

    public Machine(String fileName) {
        states = new HashMap<String, State>();  // initialize HashMap
        String line;
        String parts[];
        String desc;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            alphabet = br.readLine().split("-");

            while ((line = br.readLine()) != null) {
                parts = line.split("-");

                if (parts.length == 1) {  // if size is 1 it's a state
                    desc = parts[0];
                    if (desc.startsWith("(")) {  // if state starts with '(' it's an endSate
                        desc = desc.substring(1, desc.length() - 1);
                        addState(desc, true);
                    } else
                        addState(desc, false);
                } else
                    addSuccessor(parts[0], parts[1], parts[2]);  // if size bigger 1 then add transitions
            }

            br.close();  // close BufferedReader
        } catch (FileNotFoundException e) {
            System.err.println("File " + fileName + " not found. Check file path!");
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("Error occurred while reading " + fileName);
        }
    }

    public boolean addState(String desc, boolean isEndState) {
        if (states.containsKey(desc))
            return false;

        states.put(desc, new State(desc, isEndState));

        if (states.size() == 1)  // if first state, make it startState
            startState = states.get(desc);

        return true;
    }

    public boolean addSuccessor(String state, String token, String successor) {
        if (!states.containsKey(state) ||
            !states.containsKey(successor) ||
            !isInAlphabet(token)
        )
            return false;

        return states.get(state).addSuccessor(token, states.get(successor));  // if successor added successfully -> true
    }

    public boolean run(String[] word) {
        State s = startState;

        for (String a : word)  // iterate through word and transform
            if (s != null)
                s = s.getSuccessor(a);  // transform with token 'a'

        return ((s != null) && (s.isEndState()));
    }

    public void print(PrintStream ps) {
        for (int i = 0; i < alphabet.length; i++)
            if (alphabet.length == i+1)
                ps.print(alphabet[i]);
            else
                ps.print(alphabet[i] + "-");
        ps.println();

        for (State s : states.values())
            s.print(ps);

        for (State s : states.values())
            s.printSuccessors(ps);
    }

    private boolean isInAlphabet(String token) {
        for (String a : alphabet)
            if (a.equals(token))
                return true;
        return false;
    }
}
