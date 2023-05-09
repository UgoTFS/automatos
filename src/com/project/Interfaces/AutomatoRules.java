package com.project.Interfaces;

public interface AutomatoRules {
  public boolean isFinalState(AutomatonState state);
  public void reset(Automaton automaton);
  public void processInput(Automaton automaton, String input);
  public AutomatonState getCurrentState(Automaton automaton);
}
