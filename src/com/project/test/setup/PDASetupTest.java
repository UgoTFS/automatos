package com.project.test.setup;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.project.app.Interfaces.AutomatonState;
import com.project.app.Interfaces.PDATransition;
import com.project.app.models.AutomatonStateImpl;
import com.project.app.models.PDATransitionImpl;
import com.project.app.models.PushDownAutomaton;
import com.project.app.setup.PDASetupImpl;

public class PDASetupTest {
  
  private static Set<AutomatonState> automatonStates;
  private static Set<PDATransition> automatonTransitions;
  private static Set<AutomatonState> automatonAcceptedStates;
  private static Set<String> alphabet;

  private static PushDownAutomaton automaton;
  private static AutomatonState initialState;
  private static AutomatonState currentState;

  static AutomatonState state1;
  static AutomatonState state2;
  static AutomatonState state3;
  static AutomatonState state4;

  private static Set<String> alphabetQueue;
  private static Deque<String> stackMemoryDeque;

  @BeforeAll
  public static void setUp() {

    automatonStates = new HashSet<>();
    automatonTransitions = new HashSet<>();
    automatonAcceptedStates = new HashSet<>();
    alphabet = new HashSet<>();

    alphabetQueue = new HashSet<>();
    stackMemoryDeque = new ArrayDeque<>();

    automaton = new PushDownAutomaton();

    state1 = new AutomatonStateImpl("q0");
    state2 = new AutomatonStateImpl("q1");
    state3 = new AutomatonStateImpl("*q2");

    automatonStates.add(state1);
    automatonStates.add(state2);
    automatonStates.add(state3);

    alphabet.add("0");
    alphabet.add("1");

    alphabetQueue.add("A");

    automatonAcceptedStates.add(state3);

    initialState = state1;
    currentState = state1;

    automaton.setInitialSymbol("^");
    stackMemoryDeque.push("^");

    automatonTransitions.add(new PDATransitionImpl(state1, state2, "0", "^", "A^"));
    automatonTransitions.add(new PDATransitionImpl(state2, state2, "0", "A", "AA"));
    automatonTransitions.add(new PDATransitionImpl(state2, state3, "1", "A", null));
    automatonTransitions.add(new PDATransitionImpl(state3, state3, "1", "^", "^"));
    
    automaton.setInitialState(initialState);
    automaton.setCurrentState(currentState);
    automaton.setAcceptedStates(automatonAcceptedStates);
    automaton.setAlphabet(alphabet);
    automaton.setStackAlphabetSet(alphabetQueue);
    automaton.setStates(automatonStates);
    automaton.setPDATransitions(automatonTransitions);
    automaton.setStackMemoryDeque(stackMemoryDeque);

  }

  @Test
  @DisplayName("Test for dfa setups")
  public void testSimpleAutomatonSetup() {

    automaton.setAlphabet(alphabet);
    automaton.setStates(automatonStates);
    automaton.setInitialState(initialState);
    automaton.setPDATransitions(automatonTransitions);
    automaton.setAcceptedStates(automatonAcceptedStates);
    automaton.setCurrentState(currentState);

    PushDownAutomaton automatonTest = new PushDownAutomaton();
    PDASetupImpl automatonSetup = new PDASetupImpl();

    List<String> lines = new ArrayList<>();
    lines.add(0, "q0 q1 *q2");
    lines.add(1, "0 1");
    lines.add(2, "A");
    lines.add(3, "q0 0 q1 ^ A^");
    lines.add(4, "q1 0 q1 A AA");
    lines.add(5, "q1 1 q2 A null");
    lines.add(6, "q2 1 q2 ^ ^");

    automatonSetup.initialize(automatonTest, lines);

    assert (automaton.getAlphabet().equals(automatonTest.getAlphabet()));
    assert (automaton.getCurrentState().equals(automatonTest.getCurrentState()));
    assert (automaton.getAcceptedStates().equals(automatonTest.getAcceptedStates()));

    assert (automaton.getInitialState().equals(automatonTest.getInitialState()));
    assert (automaton.getStates().equals(automatonTest.getStates()));
    assert (automaton.getPDATransitions().equals(automatonTest.getPDATransitions()));
    assert (automaton.getStackAlphabetSet().equals(automatonTest.getStackAlphabetSet()));
    
  }
}
