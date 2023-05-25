package com.project.app.models;

import com.project.app.Interfaces.AutomatonState;
import com.project.app.Interfaces.AutomatonTransition;

public class AutomatonTransitionImpl implements AutomatonTransition{
  private AutomatonState currentState;
  private AutomatonState nextState;
  private String input;
  
  public AutomatonTransitionImpl(String estadoAtual, String proxEstado, String entrada){
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
}