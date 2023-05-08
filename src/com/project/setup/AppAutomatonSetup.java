package com.project.setup;

import java.util.List;
import java.util.Scanner;

public class AppAutomatonSetup {

  List<String> lines;

  public void run(int automatonOption, Scanner scanner){

    AutomatonSetupSuite automatonSetupSuite = new AutomatonSetupSuite();

    switch (automatonOption) {
      case 1: /* DFA */

        System.out.println("Starting the deterministic finite automaton now...");
        lines = automatonSetupSuite.getLines(scanner);

        break;
      case 2: /* PDA */

        System.out.println("Starting the push-down automaton now...");
        lines = automatonSetupSuite.getLines(scanner);

        break;
      case 3: /* TM */

        System.out.println("Starting the turing machine automaton now...");
        lines = automatonSetupSuite.getLines(scanner);

        break;
      default:
        System.out.println("Opção inválida.");
        break;
    }

  }

}
