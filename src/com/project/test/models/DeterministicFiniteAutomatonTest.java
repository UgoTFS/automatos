package com.project.test.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.project.app.Interfaces.Automaton;
import com.project.app.Interfaces.AutomatonState;
import com.project.app.Interfaces.AutomatonTransition;
import com.project.app.models.AutomatonStateImpl;
import com.project.app.models.DFATransitionImpl;
import com.project.app.models.DeterministicFiniteAutomaton;

public class DeterministicFiniteAutomatonTest {

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

    automatonStates = new HashSet<>();
    automatonTransitions = new HashSet<>();
    automatonAcceptedStates = new HashSet<>();
    alphabet = new HashSet<>();

    automaton = new DeterministicFiniteAutomaton();

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

    automatonTransitions.add(new DFATransitionImpl(state1, state2, "a"));
    automatonTransitions.add(new DFATransitionImpl(state1, state3, "b"));
    automatonTransitions.add(new DFATransitionImpl(state3, state4, "c"));
    automatonTransitions.add(new DFATransitionImpl(state4, state4, "c"));
    automatonTransitions.add(new DFATransitionImpl(state4, state1, "d"));

  }

  @Test
  @DisplayName("Test for a simple automaton")
  public void testSimpleAutomaton() {
    automaton.setAlphabet(alphabet);
    automaton.setStates(automatonStates);
    automaton.setInitialState(initialState);
    automaton.setTransitions(automatonTransitions);
    automaton.setAcceptedStates(automatonAcceptedStates);
    automaton.setCurrentState(currentState);

    Set<AutomatonState> stateComparator = new HashSet<>();
    stateComparator.add(new AutomatonStateImpl("q0"));
    stateComparator.add(new AutomatonStateImpl("*q1"));
    stateComparator.add(new AutomatonStateImpl("q2"));
    stateComparator.add(new AutomatonStateImpl("q3"));

    assert (automaton.getStates().containsAll(stateComparator));

    Set<AutomatonTransition> transitionComparator = new HashSet<>();
    transitionComparator.add(new DFATransitionImpl(state1, state2, "a"));
    transitionComparator.add(new DFATransitionImpl(state1, state3, "b"));
    transitionComparator.add(new DFATransitionImpl(state3, state4, "c"));
    transitionComparator.add(new DFATransitionImpl(state4, state4, "c"));
    transitionComparator.add(new DFATransitionImpl(state4, state1, "d"));

    assert (automaton.getTransitions().containsAll(transitionComparator));

    Set<AutomatonState> acceptedStateComparator = new HashSet<>();
    acceptedStateComparator.add(state2);

    assert (automaton.getAcceptedStates().containsAll(acceptedStateComparator));

    Set<String> alphabetComparator = new HashSet<>();
    alphabetComparator.add("a");
    alphabetComparator.add("b");
    alphabetComparator.add("c");
    alphabetComparator.add("d");

    assert (automaton.getAlphabet().containsAll(alphabetComparator));

    assert (automaton.getInitialState().equals(new AutomatonStateImpl("q0")));
    assert (automaton.getCurrentState().equals(new AutomatonStateImpl("q0")));
  }

  @Test
  @DisplayName("Test for an error empyt states set automaton")
  public void testEmptyStates() {
    Set<AutomatonState> emptyStates = new HashSet<>();
    Exception exception = assertThrows(IllegalArgumentException.class, () -> automaton.setStates(emptyStates));

    assertEquals("States cannot be empty", exception.getMessage());
  }

  @Test
  @DisplayName("Test for an error empyt alphabet set automaton")
  public void testEmptyAlphabet() {
    Set<String> emptyAlphabet = new HashSet<>();
    Exception exception = assertThrows(IllegalArgumentException.class, () -> automaton.setAlphabet(emptyAlphabet));

    assertEquals("Alphabet cannot be empty", exception.getMessage());
  }

  @Test
  @DisplayName("Test for an error empyt transitions set automaton")
  public void testEmptyTransitions() {
    Set<AutomatonTransition> emptyTransitions = new HashSet<>();
    Exception exception = assertThrows(IllegalArgumentException.class,
        () -> automaton.setTransitions(emptyTransitions));

    assertEquals("Transitions cannot be empty", exception.getMessage());
  }

  @Test
  @DisplayName("Test for an error empyt accepted states set automaton")
  public void testEmptyAcceptedStates() {
    Set<AutomatonState> emptyAcceptedStates = new HashSet<>();
    Exception exception = assertThrows(IllegalArgumentException.class,
        () -> automaton.setAcceptedStates(emptyAcceptedStates));

    assertEquals("Accepted states cannot be empty", exception.getMessage());
  }

  @Test
    @DisplayName("Test for an error empyt Current state automaton")
    public void testEmptyCurrentState() {
      Exception exception = assertThrows(IllegalArgumentException.class, () -> automaton.setCurrentState(null));
      
      assertEquals("Current state cannot be null", exception.getMessage());
    }

  @Test
    @DisplayName("Test for an error empyt initial state automaton")
    public void testEmptyNextState() {
      Exception exception = assertThrows(IllegalArgumentException.class, () -> automaton.setInitialState(null));
      
      assertEquals("Initial state cannot be null", exception.getMessage());
    }

}
