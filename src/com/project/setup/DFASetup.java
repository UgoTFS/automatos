package com.project.setup;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.project.Interfaces.Automaton;
import com.project.Interfaces.AutomatonSetup;
import com.project.Interfaces.AutomatonState;
import com.project.Interfaces.AutomatonTransition;
import com.project.models.AutomatonStateImpl;
import com.project.models.AutomatonTransitionImpl;

public class DFASetup implements AutomatonSetup {

  private Set<AutomatonState> finalStates;
  private Set<AutomatonState> states;
  private Set<String> alphabet;
  private List<String> singleTransition;
  private Set<AutomatonTransition> transitions;

  @Override
  public void initialize(Automaton automaton, List<String> setupLines) {
    
    String terminal = "*";

    // Automaton variables split TODO this line
    for(int i = 0; i < setupLines.size(); i++){
      List<String> elements = Arrays.asList(setupLines.get(i).split(" "));
      
      // setuplines(0) = states , (*) -> final states, first element = initial state
      if(i== 0){
        for(int j = 0; j < elements.size(); j++){
          
          if(elements.get(j).contains(terminal)){
            finalStates.add(new AutomatonStateImpl(elements.get(j), true));
            states.add(new AutomatonStateImpl(elements.get(j), true));
          }
          else{
            finalStates.add(new AutomatonStateImpl(elements.get(j), false));
            states.add(new AutomatonStateImpl(elements.get(j), false));
          }

          if(j == 0){
            if(elements.get(j).contains(terminal)){
              automaton.setInitialState(new AutomatonStateImpl(elements.get(0), true));
            } 
            else{
              automaton.setInitialState(new AutomatonStateImpl(elements.get(0), false));
            }
          }

        }
      }
      // setuplines(1) = alphabet
      else if(i == 1){
        alphabet.addAll(Arrays.asList(setupLines.get(i).split(" ")));
        automaton.setAlphabet(alphabet);
      }
      // setuplines(2+) = transitions
      else{
        singleTransition.addAll(Arrays.asList(setupLines.get(i).split(" ")));
        transitions.add(new AutomatonTransitionImpl(singleTransition.get(0), singleTransition.get(1), singleTransition.get(2)));
      }
    }
    automaton.settransitions(transitions);
  }

}
