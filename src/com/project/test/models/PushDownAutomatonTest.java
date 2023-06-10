package com.project.test.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.project.app.Interfaces.AutomatonState;
import com.project.app.Interfaces.AutomatonTransition;
import com.project.app.models.AutomatonStateImpl;
import com.project.app.models.PDATransitionImpl;
import com.project.app.models.PushDownAutomaton;

public class PushDownAutomatonTest {

  
  private static Set<AutomatonState> automatonStates;
  private static Set<AutomatonTransition> automatonTransitions;
  private static Set<AutomatonState> automatonAcceptedStates;
  private static Set<String> alphabet;

  private static Set<String> alphabetQueue;
  private static Deque<String> stackMemoryDeque;

  private static PushDownAutomaton automaton;
  private static AutomatonState initialState;
  private static AutomatonState currentState;

  static AutomatonState state1;
  static AutomatonState state2;
  static AutomatonState state3;

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

    automatonAcceptedStates.add(state2);

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
    automaton.setTransitions(automatonTransitions);
    automaton.setStackMemoryDeque(stackMemoryDeque);

  }


  @Test
  @DisplayName("test for adding an element to the stack memory of the automata engine")
  void testAddStackMemoryElement() {

    automaton.addStackMemoryElement("A");

    assertEquals(automaton.getStackMemoryDeque().peek(), "A");

  }

  @Test
  @DisplayName("testing the top symbol in the stack memory of the automaton")
  void testEqualsTopStackMemoryElement() {

    automaton.addStackMemoryElement("A");

    assert(automaton.equalsTopStackMemoryElement("A"));

  }

  @Test
  @DisplayName("testing the return of the final states of the automaton")
  void testGetAcceptedStates() {

    Set<AutomatonState> finalStatesTemp = new HashSet<>();
    finalStatesTemp.add(state2);

    assertEquals(automaton.getAcceptedStates(), finalStatesTemp);

  }

  @Test
  @DisplayName("testing the return of the alphabet set for the input of the automaton")
  void testGetAlphabet() {

    Set<String> alphos = new HashSet<>();
    alphos.add("0");
    alphos.add("1");

    assertEquals(alphos, automaton.getAlphabet());

  }

  @Test
  @DisplayName("testing for the return of the current state of the automaton")
  void testGetCurrentState() {

    AutomatonState currentStateTemp = currentState;
    
    assertEquals(currentStateTemp, automaton.getCurrentState());

    currentStateTemp = state3;
    automaton.setCurrentState(state3);

    assertEquals(currentStateTemp, automaton.getCurrentState());

  }

  @Test
  @DisplayName("testing for the return of the initial state of the automaton")
  void testGetInitialState() {

    AutomatonState initialStateTemp = new AutomatonStateImpl("q0");

    assertEquals(initialStateTemp, automaton.getInitialState());

  }

  @Test
  @DisplayName("testing for the return of the stack alphabet of the automaton")
  void testGetStackAlphabetSet() {

    Set<String> alphos = new HashSet<String>();
    alphos.add("A");

    assertEquals(alphos, automaton.getStackAlphabetSet());

  }

  @Test
  @DisplayName("testing for the return of the stack memory of the automaton")
  void testGetStackMemoryDeque() {

    assertEquals("^", automaton.getStackMemoryDeque().peek());

    automaton.addStackMemoryElement("A");

    assertEquals("A", automaton.getStackMemoryDeque().peek());

    automaton.addStackMemoryElement("B");
    automaton.removeStackMemoryElement();

    assertEquals("A", automaton.getStackMemoryDeque().peek());
  }

  @Test
  void testGetStates() {

    Set<AutomatonState> statesTemp = new HashSet<>();
    statesTemp.add(new AutomatonStateImpl("q0"));
    statesTemp.add(new AutomatonStateImpl("q1"));
    statesTemp.add(new AutomatonStateImpl("*q2"));
    
    automaton.setCurrentState(state2);

    assertEquals(statesTemp, automaton.getStates());

    
    Set<AutomatonState> statesNotEqualTemp = new HashSet<>();
    statesNotEqualTemp.add(new AutomatonStateImpl("q0"));
    statesNotEqualTemp.add(new AutomatonStateImpl("q1"));
    statesNotEqualTemp.add(new AutomatonStateImpl("q2"));

    assertNotEquals(statesNotEqualTemp, automaton.getStates());

  }

  @Test
  void testGetTransitions() {

    Set<AutomatonTransition> transitionsTemp = new HashSet<>();

    transitionsTemp.add(new PDATransitionImpl(state1, state2, "0", "^", "A^"));
    transitionsTemp.add(new PDATransitionImpl(state2, state2, "0", "A", "AA"));
    transitionsTemp.add(new PDATransitionImpl(state2, state3, "1", "A", null));
    transitionsTemp.add(new PDATransitionImpl(state3, state3, "1", "^", "^"));

    assertEquals(automaton.getTransitions(), transitionsTemp);

    Set<AutomatonTransition> transitionsNotEqualTemp = new HashSet<>();

    transitionsNotEqualTemp.add(new PDATransitionImpl(state1, state2, "0", "^", "B^"));
    transitionsNotEqualTemp.add(new PDATransitionImpl(state2, state2, "0", "B", "BB"));
    transitionsNotEqualTemp.add(new PDATransitionImpl(state2, state3, "1", "B", null));
    transitionsNotEqualTemp.add(new PDATransitionImpl(state3, state3, "1", "^", "^"));

    assertNotEquals(automaton.getTransitions(), transitionsNotEqualTemp);
  }

  @Test
  void testRemoveStackMemoryElement() {

    automaton.addStackMemoryElement("A");
    automaton.addStackMemoryElement("B");
    assertEquals(automaton.removeStackMemoryElement(), "B");

  }

}
