package com.project.app.models;

import com.project.app.Interfaces.AutomatonState;

public class AutomatonStateImpl implements AutomatonState {

  private String stateLabel;
  private boolean isFinal;

  public AutomatonStateImpl(String stateLabel) {
    if (stateLabel == null) {
      throw new IllegalArgumentException("stateLabel cannot be null");
    }

    this.isFinal = stateLabel.contains("*");
    this.stateLabel = stateLabel.replace("*", "");
  }

  @Override
  public String getLabel() {
    return this.stateLabel;
  }

  @Override
  public boolean isFinal() {
    return this.isFinal;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((stateLabel == null) ? 0 : stateLabel.hashCode());
    result = prime * result + (isFinal ? 1231 : 1237);
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
    AutomatonStateImpl other = (AutomatonStateImpl) obj;
    if (stateLabel == null) {
      if (other.stateLabel != null)
        return false;
    } else if (!stateLabel.equals(other.stateLabel))
      return false;
    return (isFinal == other.isFinal);
  }
}
