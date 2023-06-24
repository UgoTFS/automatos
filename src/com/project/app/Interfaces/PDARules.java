package com.project.app.Interfaces;

import java.io.IOException;

import com.project.test.AutomatonTestSuite;

public interface PDARules {
  public boolean isFinalState(PDAutomaton automaton);
  public void reset(PDAutomaton automaton);
  public void processInput(PDAutomaton automaton, String input, AutomatonTestSuite testSuite) throws IOException;
  public AutomatonState getCurrentState(PDAutomaton automaton);
  public AutomatonState getNextState(PDAutomaton automaton, String input);
  public boolean isTransitionPossible(PDAutomaton automaton, String input);

  public void resetStack(PDAutomaton automaton);
  public boolean isStackOperationPossible(PDAutomaton automaton, String inputOperation);
  public void stackOperation(PDAutomaton automaton, String inputOperation);
}
