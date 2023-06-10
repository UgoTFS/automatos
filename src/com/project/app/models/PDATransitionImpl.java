package com.project.app.models;

import com.project.app.Interfaces.AutomatonState;
import com.project.app.Interfaces.AutomatonTransition;

public class PDATransitionImpl implements AutomatonTransition{
  private AutomatonState currentState;
  private AutomatonState nextState;
  private String input;

  private String topQueue;
  private String inputQueue;
  
  public PDATransitionImpl(AutomatonState currentState, AutomatonState nexState, String input, String topQueue, String inputQueue){
    setCurrentState(currentState);
    setNextState(nexState);
    setInput(input);
    setTopQueue(topQueue);
    setInputQueue(inputQueue);
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
  
  public String getTopQueue() {
    return topQueue;
  }

  public void setTopQueue(String topQueue) {
    this.topQueue = topQueue;
  }

  public String getInputQueue() {
    return inputQueue;
  }

  public void setInputQueue(String inputQueue) {
    this.inputQueue = inputQueue;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((currentState == null) ? 0 : currentState.hashCode());
    result = prime * result + ((nextState == null) ? 0 : nextState.hashCode());
    result = prime * result + ((input == null) ? 0 : input.hashCode());
    result = prime * result + ((topQueue == null) ? 0 : topQueue.hashCode());
    result = prime * result + ((inputQueue == null) ? 0 : inputQueue.hashCode());
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
    PDATransitionImpl other = (PDATransitionImpl) obj;
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
    if (topQueue == null) {
      if (other.topQueue != null)
        return false;
    } else if (!topQueue.equals(other.topQueue))
      return false;
    if (inputQueue == null) {
      if (other.inputQueue != null)
        return false;
    } else if (!inputQueue.equals(other.inputQueue))
      return false;
    return true;
  }

}