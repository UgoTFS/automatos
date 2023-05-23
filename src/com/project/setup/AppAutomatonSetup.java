package com.project.setup;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.project.test.AutomatonTestSuite;
import com.project.utils.AutomatonType;

public class AppAutomatonSetup {

  List<String> setupLines;
  List<String> testLines;

  public void run(int automatonOption, Scanner scanner) throws IOException {

    AutomatonSetupSuite automatonSetupSuite = new AutomatonSetupSuite();
    AutomatonTestSuite testSuite;

    System.out.println("Executing tests...");

    switch (automatonOption) {
      case 1: /* DFA */

        testSuite = new AutomatonTestSuite(AutomatonType.DFA);

        testSuite.writeTestLine("Starting the deterministic finite automaton now...");
        setupLines = automatonSetupSuite.getLines(scanner);

        break;
      case 2: /* PDA */

        testSuite = new AutomatonTestSuite(AutomatonType.PDA);

        testSuite.writeTestLine("Starting the push-down automaton now...");
        setupLines = automatonSetupSuite.getLines(scanner);

        break;
      case 3: /* TM */

        testSuite = new AutomatonTestSuite(AutomatonType.TM);

        testSuite.writeTestLine("Starting the turing machine automaton now...");
        setupLines = automatonSetupSuite.getLines(scanner);

        break;
      default:
        System.out.println("Opção inválida.");
        break;
    }

    System.out.println("Tests executed successfully, check the tests files");

  }

}
