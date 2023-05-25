package com.project.app.models;

import java.util.Set;

import com.project.app.Interfaces.Automaton;
import com.project.app.Interfaces.AutomatonState;
import com.project.app.Interfaces.AutomatonTransition;

public class DeterministicFiniteAutomaton implements Automaton{

  private Set<AutomatonState> statesSet;
  private Set<String> alphabetSet;
  private Set<AutomatonState> acceptedStatesSet;
  private Set<AutomatonTransition> transitionsSet;
  private AutomatonState initialState;
  private AutomatonState currentState;

  @Override
  public void setStates(Set<AutomatonState> states) {
    if( states.isEmpty() ){
      throw new IllegalArgumentException("States cannot be empty");
    }
    this.statesSet = states;
  }

  @Override
  public void setAlphabet(Set<String> alphabet) {
    if( alphabet.isEmpty() ){
      throw new IllegalArgumentException("Alphabet cannot be empty");
    }
    this.alphabetSet = alphabet;
  }

  @Override
  public void setInitialState(AutomatonState initialState) {
    if( initialState == null ){
      throw new IllegalArgumentException("Initial state cannot be null");
    }
    this.initialState = initialState;
  }

  @Override
  public void settransitions(Set<AutomatonTransition> transitions) {
    if( transitions.isEmpty() ){
      throw new IllegalArgumentException("Transitions cannot be empty");
    }
    this.transitionsSet = transitions;
  }

  @Override
  public void setAcceptedStates(Set<AutomatonState> acceptedStates) {
    if( acceptedStates.isEmpty() ){
      throw new IllegalArgumentException("Accepted states cannot be empty");
    }
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
