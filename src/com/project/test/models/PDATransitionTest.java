package com.project.test.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.project.app.Interfaces.AutomatonState;
import com.project.app.Interfaces.PDATransition;
import com.project.app.models.AutomatonStateImpl;
import com.project.app.models.PDATransitionImpl;

public class PDATransitionTest {

  static AutomatonState state1;
  static AutomatonState state2;
  static AutomatonState state3;
  static AutomatonState state4;

  @BeforeAll
  public static void setup() {
    state1 = new AutomatonStateImpl("q0");
    state2 = new AutomatonStateImpl("*q1");
    state3 = new AutomatonStateImpl("q2");
    state4 = new AutomatonStateImpl("q3");
  }

  @Test
  @DisplayName("Simple test for a transition with current state q0,not final , next state q1,final and input 0, topqueue null, and inputqueue A")
  public void simpleTransitionTest() {

    PDATransition automatonTransition = new PDATransitionImpl(state1, state2, "0", null, "A");

    assertEquals(automatonTransition.getCurrentState(), state1);
    assertEquals(automatonTransition.getNextState(), state2);
    assertEquals(automatonTransition.getInput(), "0");

    assertEquals(automatonTransition.getInputQueue(), "A");
    assertEquals(automatonTransition.getTopQueue(), null);

  }

  @Test
  @DisplayName("Simple test for a transition with current state q0,not final, next state q1,final and input 1")
  public void simpleTransitionTest2() {

    PDATransition automatonTransition = new PDATransitionImpl(state1, state2, "1", "A", "AA");

    assertEquals(automatonTransition.getCurrentState(), state1);
    assertEquals(automatonTransition.getNextState(), state2);
    assertEquals(automatonTransition.getInput(), "1");

    assertEquals(automatonTransition.getInputQueue(), "AA");
    assertEquals(automatonTransition.getTopQueue(), "A");
  }

  @Test
  @DisplayName("Simple test for a transition with current state q0,not final, next state q0,not final and input 1")
  public void transitionToSelf() {

    PDATransition automatonTransition = new PDATransitionImpl(state1, state1, "1", "A", "BA");

    assertEquals(automatonTransition.getCurrentState(), state1);
    assertEquals(automatonTransition.getNextState(), state1);
    assertEquals(automatonTransition.getInput(), "1");

    assertEquals(automatonTransition.getInputQueue(), "BA");
    assertEquals(automatonTransition.getTopQueue(), "A");
  }

  @Test
  @DisplayName("Simple error test for a transition with current state null, next state q0,final and input 1")
  public void transitionFromNull() {

    Exception exception = assertThrows(IllegalArgumentException.class, () ->
      new PDATransitionImpl(null, state1, "1", null, "A")
    );

    assertEquals("currentState cannot be null", exception.getMessage());
  }

  @Test
  @DisplayName("Simple error test for a transition with current state q0, not final, next state null and input 1")
  public void transitionToNull() {

    Exception exception = assertThrows(IllegalArgumentException.class, () ->
      new PDATransitionImpl(state1, null, "1", null, "A")
    );

    assertEquals("nextState cannot be null", exception.getMessage());
  }

  @Test
  @DisplayName("Simple test for a transition with current state q0, not final, next state q1, final and input null")
  public void transitionWithouInput() {

    PDATransition automatonTransition = new PDATransitionImpl(state1, state2, null, null, "A");

    assertEquals(automatonTransition.getCurrentState(), state1);
    assertEquals(automatonTransition.getNextState(), state2);
    assertEquals(automatonTransition.getInput(), null);
    
    assertEquals(automatonTransition.getInputQueue(), "A");
    assertEquals(automatonTransition.getTopQueue(), null);
  }
}
