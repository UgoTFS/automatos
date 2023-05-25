package com.project.app.setup;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AutomatonSetupSuite {

  List<String> lines;

  public List<String> getLines(Scanner scanner) {

    System.out.println("First we need to setup the automaton,");
    System.out.println("please insert the file name with the automaton settings,");
    System.out.println("(in the README file there is how to configure the automaton): ");
    String fileName = scanner.next();

    System.out.println("Now opening file: " + fileName);
    this.lines = Collections.emptyList();

    try {
      this.lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("The settings gotten for the automaton: ");
    System.out.println("States names: " + this.lines.get(0));
    System.out.println("Alphabetic: " + this.lines.get(1));
    System.out.println("transitions from the file: ");
    for (int i = 2; i < this.lines.size(); i++) {
      System.out.println(this.lines.get(i));
    }

    System.out.println("File read success!!!");

    return this.lines;
  }
}