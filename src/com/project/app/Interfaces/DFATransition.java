package com.project.app.Interfaces;

public interface DFATransition {

  public void setCurrentState(AutomatonState state);
  public void setNextState(AutomatonState state);
  public void setInput(String input);

  public String getInput();
  public AutomatonState getCurrentState();
  public AutomatonState getNextState();

}
