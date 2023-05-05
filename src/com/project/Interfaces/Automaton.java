package com.project.Interfaces;

import java.util.Set;

public interface Automaton {

  public void setStates(Set<AutomatonState> state);
  public void setAlphabet(Set<String> alphabet);
  public void setInitialState(AutomatonState initialState);
  public void settransitions(Set<AutomatonTransition> transitions);
  public void setAcceptedStates(Set<AutomatonState> acceptedStates);
  public void setCurrentState(AutomatonState currentState);

  public Set<AutomatonState> getStates();
  public Set<AutomatonTransition> getTransitions();
  public Set<AutomatonState> getAcceptedStates();
  public Set<String> getAlphabet();
  public AutomatonState getInitialState();
  public AutomatonState getCurrentState();

  public void resetAutomaton();
  public boolean isInputAccepted(String input);
  public boolean isTestAccepted();
  
}
