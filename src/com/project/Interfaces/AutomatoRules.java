package com.project.Interfaces;

public interface AutomatoRules {
  public boolean isFinalState(Automaton automaton);
  public void reset(Automaton automaton);
  public void processInput(Automaton automaton, String input);
  public AutomatonState getCurrentState(Automaton automaton);
  public boolean isTransitionPossible(Automaton automaton, String input);
}
