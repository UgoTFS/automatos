package com.project.test.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashSet;
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
import com.project.app.service.DFARules;
import com.project.app.utils.AutomatonType;
import com.project.test.AutomatonTestSuite;

public class DFARulesTest {

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

  private static DFARules automatonMotor;
  private static AutomatonTestSuite testFile;

  @BeforeAll
  public static void setUp() throws IOException {

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

    automaton.setAlphabet(alphabet);

    automatonAcceptedStates.add(state2);

    automaton.setAcceptedStates(automatonAcceptedStates);

    initialState = state1;
    currentState = state1;

    automaton.setInitialState(initialState);
    automaton.setCurrentState(currentState);

    automatonTransitions.add(new AutomatonTransitionImpl(state1, state2, "a"));
    automatonTransitions.add(new AutomatonTransitionImpl(state2, state3, "b"));
    automatonTransitions.add(new AutomatonTransitionImpl(state3, state4, "c"));
    automatonTransitions.add(new AutomatonTransitionImpl(state4, state4, "c"));
    automatonTransitions.add(new AutomatonTransitionImpl(state4, state1, "d"));

    automaton.setTransitions(automatonTransitions);

    automatonMotor = new DFARules();

    testFile = new AutomatonTestSuite(AutomatonType.DFA);

  }

  @Test
  @DisplayName("test for getting current state")
  void testGetCurrentState() {

    assertEquals(automaton.getInitialState(), automatonMotor.getCurrentState(automaton));

    automaton.setCurrentState(state4);
    assertEquals(automaton.getCurrentState(), automatonMotor.getCurrentState(automaton));
  }

  @Test
  @DisplayName("test for getting next state")
  void testGetNextState() {

    automatonMotor.reset(automaton);
    String input = "a";

    assertEquals(automaton.getCurrentState(), state1);

    assertEquals(automatonMotor.getNextState(automaton, input), state2);

  }

  @Test
  @DisplayName("test to return if it is possible to finish the automaton with success")
  void testIsFinalState() {

    automaton.setCurrentState(state1);

    assert (!automatonMotor.isFinalState(automaton));

    automaton.setCurrentState(state2);

    assert (automatonMotor.isFinalState(automaton));

    automaton.setCurrentState(state3);

    assert (!automatonMotor.isFinalState(automaton));

    automaton.setCurrentState(state4);

    assert (!automatonMotor.isFinalState(automaton));
  }

  @Test
  @DisplayName("test to return if it is possible to make that transition to the next state")
  void testIsTransitionPossible() {

    automatonMotor.reset(automaton);

    String input = "a";

    assert (automatonMotor.isTransitionPossible(automaton, input));

    input = "d";

    assert (!automatonMotor.isTransitionPossible(automaton, input));

  }

  @Test
  @DisplayName("test for resetting the automaton")
  void testReset() {

    automaton.setCurrentState(state4);

    assert (!automaton.getCurrentState().equals(automaton.getInitialState()));

    automatonMotor.reset(automaton);

    assert (automaton.getCurrentState().equals(automaton.getInitialState()));

  }

  @Test
  @DisplayName("test for writing a test file")
  void testProcessInput() throws IOException {

    automatonMotor.processInput(automaton, "abcdabc", testFile);

  }
}