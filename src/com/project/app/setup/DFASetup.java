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
        setAllStates(automaton, elements, finalStates, states);
      }
      // setuplines(1) = alphabet
      else if (i == 1) {
        alphabet.addAll(Arrays.asList(setupLines.get(i).split(" ")));
        automaton.setAlphabet(alphabet);
      }
      // setuplines(2+) = transitions
      else {
        singleTransition.addAll(Arrays.asList(setupLines.get(i).split(" ")));
        transitions.add(
            new AutomatonTransitionImpl(singleTransition.get(0), singleTransition.get(1), singleTransition.get(2)));
      }
    }
    automaton.settransitions(transitions);
  }

  public void setAllStates(Automaton automaton, List<String> elements, Set<AutomatonState> finalStates,
      Set<AutomatonState> states) {

    var terminal = "*";

    for (int j = 0; j < elements.size(); j++) {

      if (elements.get(j).contains(terminal)) {
        String temp = elements.get(j).replace("*", "");
        finalStates.add(new AutomatonStateImpl(temp, true));
        states.add(new AutomatonStateImpl(temp, true));
      } else {
        finalStates.add(new AutomatonStateImpl(elements.get(j), false));
        states.add(new AutomatonStateImpl(elements.get(j), false));
      }

      if (j == 0) {
        if (elements.get(j).contains(terminal)) {
          automaton.setInitialState(new AutomatonStateImpl(elements.get(0), true));
        } else {
          automaton.setInitialState(new AutomatonStateImpl(elements.get(0), false));
        }
      }

    }
  }

}
