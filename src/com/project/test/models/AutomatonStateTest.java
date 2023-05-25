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
    AutomatonState automatonState = new AutomatonStateImpl("q0", false);

    assert automatonState.getLabel().equals("q0");
    assert automatonState.isFinal() == false;
  }

  @Test
  public void SimpleTestFinal() {
    AutomatonState automatonState = new AutomatonStateImpl("q1", true);

    assert automatonState.getLabel().equals("q1");
    assert automatonState.isFinal() == true;
  }

  @Test
  public void simpleTestEquals() {
    AutomatonState automatonState1 = new AutomatonStateImpl("q0", false);
    AutomatonState automatonState2 = new AutomatonStateImpl("q0", false);

    assertEquals(automatonState1.getLabel(), automatonState2.getLabel());
    assertEquals(automatonState1.isFinal(), automatonState2.isFinal());
  }

  @Test
  public void simpleTestNotEquals() {
    AutomatonState automatonState1 = new AutomatonStateImpl("q0", false);
    AutomatonState automatonState2 = new AutomatonStateImpl("q1", false);

    assertNotEquals(automatonState1.getLabel(), automatonState2.getLabel());
    assertEquals(automatonState1.isFinal(), automatonState2.isFinal());
  }

  @Test
  public void simpleErrorNull() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      AutomatonState automatonState = new AutomatonStateImpl(null, false);
      automatonState.getLabel();
    });
    assertEquals("stateLabel cannot be null", exception.getMessage());
  }
}
