package com.project.app.models;

import java.util.Deque;
import java.util.Set;

import com.project.app.Interfaces.Automaton;
import com.project.app.Interfaces.AutomatonState;
import com.project.app.Interfaces.AutomatonTransition;

public class PushDownAutomaton implements Automaton {
  private Set<AutomatonState> statesSet;
  private Set<String> alphabetSet;
  private Set<AutomatonState> acceptedStatesSet;
  private Set<AutomatonTransition> transitionsSet;
  private AutomatonState initialState;
  private AutomatonState currentState;

  private Deque<String> stackMemoryDeque;

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

  public void setStackMemoryDeque(Deque<String> stack) {
    this.stackMemoryDeque = stack;
  }
}
