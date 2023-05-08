package com.project.setup;

import com.project.Interfaces.AppMenu;
import com.project.service.AppAutomatonMenu;

public class AppMainMenuSetup {

  public void run(int mainMenuOption) {

    boolean isRunning = true;

    while (isRunning) {
      switch (mainMenuOption) {
        case 1:
          AppMenu automatoMenu = new AppAutomatonMenu();
          int automatonOption = automatoMenu.show();
          System.out.println("The choosen options was: " + automatonOption);
          AppAutomatonSetup automatonOptionsSetup = new AppAutomatonSetup();
          automatonOptionsSetup.run(automatonOption);
          break;
        case 2:
          System.out.println("Thank you for utilizing my automaton project!!!\n");
          isRunning = false;
          break;
        default:
          System.out.println("Opção inválida.");
      }
    }
  }
}
