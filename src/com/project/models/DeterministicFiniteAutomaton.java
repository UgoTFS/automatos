package com.project.models;

import java.util.Set;

import com.project.Interfaces.Automaton;
import com.project.Interfaces.AutomatonState;
import com.project.Interfaces.AutomatonTransition;

public class DeterministicFiniteAutomaton implements Automaton{

  private Set<AutomatonState> statesSet;
  private Set<String> alphabetSet;
  private Set<AutomatonState> acceptedStatesSet;
  private Set<AutomatonTransition> transitionsSet;
  private AutomatonState initialState;
  private AutomatonState currentState;

  @Override
  public void setStates(Set<AutomatonState> states) {
    this.statesSet = states;
  }

  @Override
  public void setAlphabet(Set<String> alphabet) {
    this.alphabetSet = alphabet;
  }

  @Override
  public void setInitialState(AutomatonState initialState) {
    this.initialState = initialState;
  }

  @Override
  public void settransitions(Set<AutomatonTransition> transitions) {
    this.transitionsSet = transitions;
  }

  @Override
  public void setAcceptedStates(Set<AutomatonState> acceptedStates) {
    this.acceptedStatesSet = acceptedStates;
  }

  @Override
  public Set<AutomatonState> getStates() {
    return this.statesSet;
  }

  @Override
  public Set<AutomatonTransition> getTransitions() {
    return this.transitionsSet;
  }

  @Override
  public Set<AutomatonState> getAcceptedStates() {
    return this.acceptedStatesSet;
  }

  @Override
  public Set<String> getAlphabet() {
    return this.alphabetSet;
  }

  @Override
  public AutomatonState getInitialState() {
    return this.initialState;
  }

  @Override
  public void setCurrentState(AutomatonState currentState) {
    this.currentState = currentState;
  }

  @Override
  public AutomatonState getCurrentState() {
    return this.currentState;
  }

  
}
