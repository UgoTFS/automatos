package com.project.app.Interfaces;

public interface PDATransition extends DFATransition{
  public String getTopQueue();
  public void setTopQueue(String topQueue);
  public String getInputQueue();
  public void setInputQueue(String inputQueue);
}
