package com.project.Interfaces;

import java.io.IOException;

import com.project.test.AutomatonTestSuite;

public interface AutomatoRules {
  public boolean isFinalState(Automaton automaton);
  public void reset(Automaton automaton);
  public void processInput(Automaton automaton, String input, AutomatonTestSuite testSuite) throws IOException;
  public AutomatonState getCurrentState(Automaton automaton);
  public AutomatonState getNextState(Automaton automaton, String input);
  public boolean isTransitionPossible(Automaton automaton, String input);
}
