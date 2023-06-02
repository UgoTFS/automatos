package com.project.app.service;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import com.project.app.Interfaces.AutomatoRules;
import com.project.app.Interfaces.Automaton;
import com.project.app.Interfaces.AutomatonState;
import com.project.app.Interfaces.AutomatonTransition;
import com.project.test.AutomatonTestSuite;

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
  public void processInput(Automaton automaton, String input, AutomatonTestSuite testSuite) throws IOException {

    // implement test suite exit

    int step = 1;
    boolean isStringAccepted = true;

    for (char charInput : input.toCharArray()) {

      if (step == 1) {
        reset(automaton);
        testSuite.writeTestLine("New test will start now. \n");
        testSuite.writeTestLine("String input to be tested: " + input);
      }

      testSuite.writeTestLine("--------------------------------");
      testSuite.writeTestLine("Step " + step);
      testSuite.writeTestLine("Character to be tested: " + charInput);
      testSuite.writeTestLine("Current state: " + automaton.getCurrentState().getLabel());
      if (automaton.getAlphabet().contains((String.valueOf(charInput)))
          && isTransitionPossible(automaton, String.valueOf(charInput))) {
        testSuite.writeTestLine("Char accepted");
        automaton.setCurrentState(getNextState(automaton, String.valueOf(charInput)));
      } else {
        testSuite.writeTestLine("Char not accepted");
        isStringAccepted = false;
        break;
      }
      step++;
    }

    if (isStringAccepted && isFinalState(automaton)) {
      testSuite.writeTestLine("String input accepted\n");
    } else {
      testSuite.writeTestLine("String input not accepted\n");
    }
    testSuite.writeTestLine("Test completed successfully\n");
    testSuite.writeTestLine("--------------------------------");
  }

  @Override
  public AutomatonState getCurrentState(Automaton automaton) {
    return automaton.getCurrentState();
  }

  @Override
  public boolean isTransitionPossible(Automaton automaton, String input) {
    AtomicBoolean transitionFound = new AtomicBoolean(false);
    automaton.getTransitions().stream().forEach(transition -> {
      if (automaton.getCurrentState().equals(transition.getCurrentState()) && transition.getInput().equals(input)) {
        transitionFound.set(true);
      }
    });
    return transitionFound.get();
  }

  @Override
  public AutomatonState getNextState(Automaton automaton, String input) {
    for (AutomatonTransition transition : automaton.getTransitions()) {
      if (transition.getCurrentState().equals(automaton.getCurrentState())) {
        return transition.getNextState();
      }
    }
    return null;
  }
}
