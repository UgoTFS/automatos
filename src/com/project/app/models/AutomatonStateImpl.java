package com.project.app.models;

import com.project.app.Interfaces.AutomatonState;

public class AutomatonStateImpl implements AutomatonState{
  
  private String stateLabel;
  private boolean isFinal;

  public AutomatonStateImpl(String stateLabel, boolean isFinal) {
    this.stateLabel = stateLabel;
    this.isFinal = isFinal;
  }

  @Override
  public String getLabel() {
    return this.stateLabel;
  }

  @Override
  public boolean isFinal() {
    return this.isFinal;
  }
}
