package com.project.app.models;

import com.project.app.Interfaces.AutomatonState;
import com.project.app.Interfaces.DFATransition;

public class DFATransitionImpl implements DFATransition{
  private AutomatonState currentState;
  private AutomatonState nextState;
  private String input;
  
  public DFATransitionImpl(AutomatonState currentState, AutomatonState nexState, String entrada){
    setCurrentState(currentState);
    setNextState(nexState);
    setInput(entrada);
  }

  @Override
  public void setCurrentState(AutomatonState state) {
    if( state == null ){
      throw new IllegalArgumentException("currentState cannot be null");
    }
    this.currentState = state;
  }

  @Override
  public void setNextState(AutomatonState state) {
    if( state == null ){
      throw new IllegalArgumentException("nextState cannot be null");
    }
    this.nextState = state;
  }

  @Override
  public void setInput(String input) {
    this.input = input;
  }

  @Override
  public String getInput() {
    return this.input;
  }

  @Override
  public AutomatonState getCurrentState() {
    return this.currentState;
  }

  @Override
  public AutomatonState getNextState() {
    return this.nextState;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((currentState == null) ? 0 : currentState.hashCode());
    result = prime * result + ((nextState == null) ? 0 : nextState.hashCode());
    result = prime * result + ((input == null) ? 0 : input.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DFATransitionImpl other = (DFATransitionImpl) obj;
    if (currentState == null) {
      if (other.currentState != null)
        return false;
    } else if (!currentState.equals(other.currentState))
      return false;
    if (nextState == null) {
      if (other.nextState != null)
        return false;
    } else if (!nextState.equals(other.nextState))
      return false;
    if (input == null) {
      if (other.input != null)
        return false;
    } else if (!input.equals(other.input))
      return false;
    return true;
  }
}