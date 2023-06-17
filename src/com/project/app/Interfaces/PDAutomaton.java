package com.project.app.Interfaces;

import java.util.Deque;
import java.util.Set;

public interface PDAutomaton extends DFAutomaton{
  
  public void setPDATransitions(Set<PDATransition> transitions);
  public Set<PDATransition> getPDATransitions();
  
  public Set<String> getStackAlphabetSet();
  public void setStackAlphabetSet(Set<String> stackAlphabetSet);
  public void setStackMemoryDeque(Deque<String> stack);
  public String getInitialSymbol();
  public void setInitialSymbol(String initialSymbol);
  public Deque<String> getStackMemoryDeque();
  public void addStackMemoryElement(String value);
  public String removeStackMemoryElement();
  public boolean equalsTopStackMemoryElement(String value);

}
