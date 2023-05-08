package com.project.service;

import java.util.Scanner;

import com.project.Interfaces.AppMenu;

public class AppMainMenu implements AppMenu {

  @Override
  public int show() {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println(" - Welcome to a simple automaton application!\n");
      System.out.println(" - Here you can test your automatons");
      System.out.println(" - First your next step:\n");
      System.out.println(" - 1 - Start a new automaton;");
      System.out.println(" - 2 - Exit program;");
      return scanner.nextInt();
    }
  }
}
