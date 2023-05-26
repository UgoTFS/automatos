package com.project.test.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import com.project.app.Interfaces.AutomatonState;
import com.project.app.models.AutomatonStateImpl;

public class AutomatonStateTest {

  @Test
  @DisplayName("Simple test for an automaton state with label q0 and not final")
  public void simpleTestNotFinal() {
    AutomatonState automatonState = new AutomatonStateImpl("q0");

    assert automatonState.getLabel().equals("q0");
    assert (!automatonState.isFinal());
  }

  @Test
  @DisplayName("Simple test for an automaton state with label q1 and final")
  public void simpleTestFinal() {
    AutomatonState automatonState = new AutomatonStateImpl("*q1");

    assert automatonState.getLabel().equals("q1");
    assert automatonState.isFinal();
  }

  @Test
  @DisplayName("Simple test for two automaton state that are equals")
  public void simpleTestEquals() {
    AutomatonState automatonState1 = new AutomatonStateImpl("q0");
    AutomatonState automatonState2 = new AutomatonStateImpl("q0");

    assert(automatonState1.equals(automatonState2));
  }

  @Test
  @DisplayName("Simple error test for two automaton state that are not equal same labels, diferent isFinal")
  public void simpleTestAlmostEquals() {
    AutomatonState automatonState1 = new AutomatonStateImpl("q0");
    AutomatonState automatonState2 = new AutomatonStateImpl("*q0");
    assertNotEquals(automatonState1, automatonState2);
  }

  @Test
  @DisplayName("Simple test for two automaton state that are not equals")
  public void simpleTestNotEquals() {
    AutomatonState automatonState1 = new AutomatonStateImpl("q0");
    AutomatonState automatonState2 = new AutomatonStateImpl("q1");

    assert(!automatonState1.equals(automatonState2));
  }

  @Test
  @DisplayName("Simple error test for an automaton state with an empty label")
  public void simpleErrorNull() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      AutomatonState automatonState = new AutomatonStateImpl(null);
      automatonState.getLabel();
    });
    assertEquals("stateLabel cannot be null", exception.getMessage());
  }

}
