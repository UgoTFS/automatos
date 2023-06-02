package com.project.app.service;

import java.util.Scanner;

import com.project.app.Interfaces.AppMenu;

public class AppAutomatonMenu implements AppMenu {

  @Override
  public int show(Scanner scanner) {
    System.out.println(" - Now choose what type of automaton you would like to use:");
    System.out.println(" - Your options are:\n");
    System.out.println(" - 1. Deterministic Finite Automaton;");
    System.out.println(" - 2. Push Down Automaton;");
    System.out.println(" - 3. Turing Machine;\n");
    System.out.println(" - 4. Back;\n");

    return scanner.nextInt();
  }
}