package com.project.app.Interfaces;

import java.util.Set;

public interface DFAutomaton {

  public void setStates(Set<AutomatonState> state);
  public void setAlphabet(Set<String> alphabet);
  public void setInitialState(AutomatonState initialState);
  public void setDFATransitions(Set<DFATransition> transitions);
  public void setAcceptedStates(Set<AutomatonState> acceptedStates);
  public void setCurrentState(AutomatonState currentState);

  public Set<AutomatonState> getStates();
  public Set<DFATransition> getDFATransitions();
  public Set<AutomatonState> getAcceptedStates();
  public Set<String> getAlphabet();
  public AutomatonState getInitialState();
  public AutomatonState getCurrentState();

}
