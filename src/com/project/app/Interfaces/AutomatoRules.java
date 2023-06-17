package com.project.app.Interfaces;

import java.io.IOException;

import com.project.test.AutomatonTestSuite;

public interface AutomatoRules {
  public boolean isFinalState(DFAutomaton automaton);
  public void reset(DFAutomaton automaton);
  public void processInput(DFAutomaton automaton, String input, AutomatonTestSuite testSuite) throws IOException;
  public AutomatonState getCurrentState(DFAutomaton automaton);
  public AutomatonState getNextState(DFAutomaton automaton, String input);
  public boolean isTransitionPossible(DFAutomaton automaton, String input);
}
