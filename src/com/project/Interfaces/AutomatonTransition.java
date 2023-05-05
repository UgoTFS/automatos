package com.project.Interfaces;

public interface AutomatonTransition {

  public void setCurrentState(AutomatonState state);
  public void setNextState(AutomatonState state);
  public void setInput(String input);

  public String getInput();
  public AutomatonState getCurrentState();
  public AutomatonState getNextState();

}
