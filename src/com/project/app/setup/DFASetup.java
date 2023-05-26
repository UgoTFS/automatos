package com.project.app.setup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.project.app.Interfaces.Automaton;
import com.project.app.Interfaces.AutomatonSetup;
import com.project.app.Interfaces.AutomatonState;
import com.project.app.Interfaces.AutomatonTransition;
import com.project.app.models.AutomatonStateImpl;
import com.project.app.models.AutomatonTransitionImpl;

public class DFASetup implements AutomatonSetup {

  @Override
  public void initialize(Automaton automaton, List<String> setupLines) {

    Set<AutomatonState> finalStates = new HashSet<>();
    Set<AutomatonState> states = new HashSet<>();
    Set<String> alphabet = new HashSet<>();
    List<String> singleTransition = new ArrayList<>();
    Set<AutomatonTransition> transitions = new HashSet<>();

    // Automaton variables split
    for (int i = 0; i < setupLines.size(); i++) {
      List<String> elements = Arrays.asList(setupLines.get(i).split(" "));

      // setuplines(0) = states , (*) -> final states, first element = initial state
      if (i == 0) {
        for (int j = 0; j < elements.size(); j++) {

          AutomatonState automatonState = new AutomatonStateImpl(elements.get(j));

          if (automatonState.isFinal()) {
            finalStates.add(automatonState);
          }

          if (j == 0) {
            automaton.setInitialState(automatonState);
          }

          states.add(automatonState);
        }
      }
      // setuplines(1) = alphabet
      else if (i == 1) {
        alphabet.addAll(Arrays.asList(setupLines.get(i).split(" ")));
        automaton.setAlphabet(alphabet);
      }
      // setuplines(2+) = transitions
      else {
        singleTransition.addAll(Arrays.asList(setupLines.get(i).split(" ")));
        // singleTransition: (0) -> current state, (1) -> input, (2) -> next state
        AutomatonState currentState = states.stream()
            .filter(element -> element.getLabel().equals(singleTransition.get(0)))
            .findAny().orElse(null);
        AutomatonState nextState = states.stream()
            .filter(element -> element.getLabel().equals(singleTransition.get(2)))
            .findAny().orElse(null);
        new AutomatonTransitionImpl(currentState, nextState, singleTransition.get(1));
      }
    }
    automaton.setTransitions(transitions);
  }
}