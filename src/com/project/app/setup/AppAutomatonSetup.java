package com.project.app.setup;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.project.app.models.DeterministicFiniteAutomaton;
import com.project.app.service.DFARules;
import com.project.app.utils.AutomatonType;
import com.project.test.AutomatonTestSuite;

public class AppAutomatonSetup {

  List<String> setupLines;
  List<String> testLines;

  public void run(int automatonOption, Scanner scanner) throws IOException {

    AutomatonSetupSuite automatonSetupSuite = new AutomatonSetupSuite();
    StringInputSuite stringInputSuite = new StringInputSuite();
    AutomatonTestSuite testSuite;

    System.out.println("Executing tests...");

    switch (automatonOption) {
      case 1: /* DFA */

        DeterministicFiniteAutomaton dfAutomatom = new DeterministicFiniteAutomaton();
        DFASetup automatonSetup = new DFASetup();
        DFARules automatonMotor = new DFARules();

        testSuite = new AutomatonTestSuite(AutomatonType.DFA);

        testSuite.writeTestLine("Starting the deterministic finite automaton now...\n");
        setupLines = automatonSetupSuite.getLines(scanner, testSuite);
        testLines = stringInputSuite.getLines(scanner, testSuite);

        automatonSetup.initialize(dfAutomatom, setupLines);

        for (String line : testLines) {
          automatonMotor.processInput(dfAutomatom, line, testSuite);
        }

        testSuite.closeFile();
        break;
      case 2: /* PDA */

        testSuite = new AutomatonTestSuite(AutomatonType.PDA);

        testSuite.writeTestLine("Starting the push-down automaton now...");
        setupLines = automatonSetupSuite.getLines(scanner, testSuite);
        testLines = stringInputSuite.getLines(scanner, testSuite);

        break;
      case 3: /* TM */

        testSuite = new AutomatonTestSuite(AutomatonType.TM);

        testSuite.writeTestLine("Starting the turing machine automaton now...");
        setupLines = automatonSetupSuite.getLines(scanner, testSuite);
        testLines = stringInputSuite.getLines(scanner, testSuite);

        break;
      case 4: /* back */
        System.out.println("Returning.");
        return;
      default:
        System.out.println("Opção inválida.");
        break;
    }

    System.out.println("Tests executed successfully, check the tests files");

  }

}
