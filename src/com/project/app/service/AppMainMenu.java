package com.project.app.service;

import java.util.Scanner;

import com.project.app.Interfaces.AppMenu;

public class AppMainMenu implements AppMenu {

  @Override
  public int show(Scanner scanner) {
      System.out.println(" - Welcome to a simple automaton application!\n");
      System.out.println(" - Here you can test your automatons");
      System.out.println(" - First your next step:\n");
      System.out.println(" - 1 - Start a new automaton;");
      System.out.println(" - 2 - Exit program;\n");
      
      return scanner.nextInt();
  }
}
