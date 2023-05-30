package com.project.test.setup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.project.app.Interfaces.Automaton;
import com.project.app.Interfaces.AutomatonState;
import com.project.app.Interfaces.AutomatonTransition;
import com.project.app.models.AutomatonStateImpl;
import com.project.app.models.AutomatonTransitionImpl;
import com.project.app.models.DeterministicFiniteAutomaton;
import com.project.app.setup.DFASetup;

public class DFASetupTest {

  private static Set<AutomatonState> automatonStates;
  private static Set<AutomatonTransition> automatonTransitions;
  private static Set<AutomatonState> automatonAcceptedStates;
  private static Set<String> alphabet;

  private static Automaton automaton;
  private static AutomatonState initialState;
  private static AutomatonState currentState;

  static AutomatonState state1;
  static AutomatonState state2;
  static AutomatonState state3;
  static AutomatonState state4;

  @BeforeAll
  public static void setUp() {

    automaton = new DeterministicFiniteAutomaton();

    automatonStates = new HashSet<>();
    automatonTransitions = new HashSet<>();
    automatonAcceptedStates = new HashSet<>();
    alphabet = new HashSet<>();

    state1 = new AutomatonStateImpl("q0");
    state2 = new AutomatonStateImpl("*q1");
    state3 = new AutomatonStateImpl("q2");
    state4 = new AutomatonStateImpl("q3");

    automatonStates.add(state1);
    automatonStates.add(state2);
    automatonStates.add(state3);
    automatonStates.add(state4);

    alphabet.add("a");
    alphabet.add("b");
    alphabet.add("c");
    alphabet.add("d");

    automatonAcceptedStates.add(state2);

    initialState = state1;
    currentState = state1;

    automatonTransitions.add(new AutomatonTransitionImpl(state1, state2, "a"));
    automatonTransitions.add(new AutomatonTransitionImpl(state2, state3, "b"));
    automatonTransitions.add(new AutomatonTransitionImpl(state3, state4, "c"));
    automatonTransitions.add(new AutomatonTransitionImpl(state4, state4, "c"));
    automatonTransitions.add(new AutomatonTransitionImpl(state4, state1, "d"));

  }

  @Test
  @DisplayName("Test for dfa setups")
  public void testSimpleAutomatonSetup() {

    automaton.setAlphabet(alphabet);
    automaton.setStates(automatonStates);
    automaton.setInitialState(initialState);
    automaton.setTransitions(automatonTransitions);
    automaton.setAcceptedStates(automatonAcceptedStates);
    automaton.setCurrentState(currentState);

    Automaton automatonTest = new DeterministicFiniteAutomaton();
    DFASetup automatonSetup = new DFASetup();

    List<String> lines = new ArrayList<>();
    lines.add(0, "q0 *q1 q2 q3");
    lines.add(1, "a b c d");
    lines.add(2, "q0 a q1");
    lines.add(3, "q1 b q2");
    lines.add(4, "q2 c q3");
    lines.add(5, "q3 c q3");
    lines.add(6, "q3 d q0");

    automatonSetup.initialize(automatonTest, lines);

    System.out.println("automaton test: states: " + automatonTest.getStates());
    System.out.println("automaton test: alphabet: " + automatonTest.getAlphabet());
    System.out.println("automaton test: accepted states: " + automatonTest.getAcceptedStates());
    System.out.println("automaton test: transitions: " + automatonTest.getTransitions());
    System.out.println("automaton test: initial state: " + automatonTest.getInitialState());
    System.out.println("automaton test: current state: " + automatonTest.getCurrentState());


    assert (automaton.getAlphabet().equals(automatonTest.getAlphabet()));
    assert (automaton.getCurrentState().equals(automatonTest.getCurrentState()));
    assert (automaton.getAcceptedStates().equals(automatonTest.getAcceptedStates()));

    assert (automaton.getInitialState().equals(automatonTest.getInitialState()));
    assert (automaton.getStates().equals(automatonTest.getStates()));
    System.out.println("automaton transition: " + automaton.getTransitions());
    System.out.println("automaton test: " + automatonTest.getTransitions());
    System.out.println("test transitions: " + automaton.getTransitions().equals(automatonTest.getTransitions()));
    assert (automaton.getTransitions().equals(automatonTest.getTransitions()));
    
    
  }
}
