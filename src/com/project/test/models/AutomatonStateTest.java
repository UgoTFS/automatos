package com.project.test.models;

import org.junit.Test;

import com.project.app.Interfaces.AutomatonState;
import com.project.app.models.AutomatonStateImpl;

public class AutomatonStateTest {
  @Test
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

}
