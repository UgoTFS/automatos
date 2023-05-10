package com.project.service;

import java.util.concurrent.atomic.AtomicBoolean;

import com.project.Interfaces.AutomatoRules;
import com.project.Interfaces.Automaton;
import com.project.Interfaces.AutomatonState;

public class DFARules implements AutomatoRules {

  @Override
  public boolean isFinalState(Automaton automaton) {
    return automaton.getAcceptedStates().contains(automaton.getCurrentState());
  }

  @Override
  public void reset(Automaton automaton) {
    automaton.setCurrentState(automaton.getInitialState());
  }

  @Override
  public void processInput(Automaton automaton, String input) {

    if (automaton.getAlphabet().contains(input) && isTransitionPossible(automaton, input)) {
      // TODO: Implement this method
    }
  }

  @Override
  public AutomatonState getCurrentState(Automaton automaton) {
    return automaton.getCurrentState();
  }

  @Override
  public boolean isTransitionPossible(Automaton automaton, String input) {
    AtomicBoolean transitionFound = new AtomicBoolean(false);
    automaton.getTransitions().stream().forEach(transition -> {
      if (transition.getInput().equals(input)) {
        transitionFound.set(true);
      }
    });
    return transitionFound.get();
  }
}
