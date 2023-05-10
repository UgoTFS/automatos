package com.project.setup;

import java.io.IOException;
import java.util.Scanner;

import com.project.Interfaces.AppMenu;
import com.project.service.AppAutomatonMenu;

public class AppMainMenuSetup {

  public void run(int mainMenuOption, Scanner scanner) throws IOException{

    boolean isRunning = true;

    while (isRunning) {
      switch (mainMenuOption) {
        case 1:
          AppMenu automatoMenu = new AppAutomatonMenu();
          int automatonOption = automatoMenu.show(scanner);
          System.out.println("The choosen options was: " + automatonOption);
          AppAutomatonSetup automatonOptionsSetup = new AppAutomatonSetup();
          automatonOptionsSetup.run(automatonOption, scanner);
          break;
        case 2:
          System.out.println("Thank you for utilizing my automaton project!!!\n");
          isRunning = false;
          break;
        default:
          System.out.println("Invalid option");
      }
    }
  }
}
