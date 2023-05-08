package com.project.service;

import java.util.Scanner;

import com.project.Interfaces.AppMenu;

public class AppAutomatonMenu implements AppMenu {

  @Override
  public int show() {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println(" - Now choose what type of automaton you would like to use:");
      System.out.println(" - Your options are:\n");
      System.out.println(" - 1. Deterministic Finite Automaton;");
      System.out.println(" - 2. Push Down Automaton;");
      System.out.println(" - 3. Turing Machine;");
      return scanner.nextInt();
    }
  }
}
