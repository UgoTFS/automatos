package com.project.test.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.project.app.Interfaces.AutomatonState;
import com.project.app.Interfaces.AutomatonTransition;
import com.project.app.models.AutomatonStateImpl;
import com.project.app.models.DFATransitionImpl;

public class DFATransitionTest {

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
  @DisplayName("Simple test for a transition with current state q0,not final , next state q1,final and input 0")
  public void simpleTransitionTest() {

    AutomatonTransition automatonTransition = new DFATransitionImpl(state1, state2, "0");

    assertEquals(automatonTransition.getCurrentState(), state1);
    assertEquals(automatonTransition.getNextState(), state2);
    assertEquals(automatonTransition.getInput(), "0");
  }

  @Test
  @DisplayName("Simple test for a transition with current state q0,not final, next state q1,final and input 1")
  public void simpleTransitionTest2() {

    AutomatonTransition automatonTransition = new DFATransitionImpl(state1, state2, "1");

    assertEquals(automatonTransition.getCurrentState(), state1);
    assertEquals(automatonTransition.getNextState(), state2);
    assertEquals(automatonTransition.getInput(), "1");
  }

  @Test
  @DisplayName("Simple test for a transition with current state q0,not final, next state q0,not final and input 1")
  public void transitionToSelf() {

    AutomatonTransition automatonTransition = new DFATransitionImpl(state1, state1, "1");

    assertEquals(automatonTransition.getCurrentState(), state1);
    assertEquals(automatonTransition.getNextState(), state1);
    assertEquals(automatonTransition.getInput(), "1");
  }

  @Test
  @DisplayName("Simple error test for a transition with current state null, next state q0,final and input 1")
  public void transitionFromNull() {

    Exception exception = assertThrows(IllegalArgumentException.class, () ->
      new DFATransitionImpl(null, state1, "1")
    );

    assertEquals("currentState cannot be null", exception.getMessage());
  }

  @Test
  @DisplayName("Simple error test for a transition with current state q0, not final, next state null and input 1")
  public void transitionToNull() {

    Exception exception = assertThrows(IllegalArgumentException.class, () ->
      new DFATransitionImpl(state1, null, "1")
    );

    assertEquals("nextState cannot be null", exception.getMessage());
  }

  @Test
  @DisplayName("Simple test for a transition with current state q0, not final, next state q1, final and input null")
  public void transitionWithouInput() {

    AutomatonTransition automatonTransition = new DFATransitionImpl(state1, state2, null);

    assertEquals(automatonTransition.getCurrentState(), state1);
    assertEquals(automatonTransition.getNextState(), state2);
    assertEquals(automatonTransition.getInput(), null);
  }
}
