package com.project.app.service;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

import com.project.app.Interfaces.AutomatonState;
import com.project.app.Interfaces.PDARules;
import com.project.app.Interfaces.PDATransition;
import com.project.app.Interfaces.PDAutomaton;
import com.project.test.AutomatonTestSuite;

public class PDARulesImpl implements PDARules{

  @Override
  public boolean isFinalState(PDAutomaton automaton) {
    return automaton.getAcceptedStates().contains(automaton.getCurrentState());
  }

  @Override
  public void reset(PDAutomaton automaton) {
    automaton.setCurrentState(automaton.getInitialState());
    resetStack(automaton);
  }

  @Override
  public void processInput(PDAutomaton automaton, String input, AutomatonTestSuite testSuite) throws IOException {
    
    // TODO copy+paste from dfa rules needs to implement pushdown routines

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
  public AutomatonState getCurrentState(PDAutomaton automaton) {
    return automaton.getCurrentState();
  }

  @Override
  public AutomatonState getNextState(PDAutomaton automaton, String input) {
    for (PDATransition transition : automaton.getPDATransitions()) {
      if (transition.getCurrentState().equals(automaton.getCurrentState())) {
        return transition.getNextState();
      }
    }
    return null;
  }

  @Override
  public boolean isTransitionPossible(PDAutomaton automaton, String input) {AtomicBoolean transitionFound = new AtomicBoolean(false);
    automaton.getPDATransitions().stream().forEach(transition -> {
      if (automaton.getCurrentState().equals(transition.getCurrentState()) && transition.getInput().equals(input)) {
        transitionFound.set(true);
      }
    });
    return transitionFound.get();
  }

  @Override
  public void resetStack(PDAutomaton automaton) {
    automaton.getStackAlphabetSet().clear();
    automaton.addStackMemoryElement(automaton.getInitialSymbol());
  }

  @Override
  public boolean isStackOperationPossible(PDAutomaton automaton, String inputOperation) {
    // inputOperation possibilities: null, <char>^, <char><char>, <char>
    /*
     * null: no operation
     * <char>^: add char on the empty stack
     * <char><char>: add char over another char on the stack
     * <char>: verify the top of the stack, if its the same char do nothing, if its diferent exchange the char
     */
    if (inputOperation.isEmpty()){
      return true;
    }
    if(Pattern.matches("[a-z]|[A-Z]^", inputOperation)){
      return true;
    }
    if(Pattern.matches("[a-z]|[A-Z]{2}", inputOperation)){
      return true;
    }
    if(Pattern.matches("[a-z]|[A-Z]", inputOperation)){
      return true;
    }
    return false;
  }

  @Override
  public void stackOperation(PDAutomaton automaton, String inputOperation) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'stackOperation'");
  }
  
}
