package com.project.app.setup;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringInputSuite {
  
  List<String> lines;

  public List<String> getLines(Scanner scanner) {

    System.out.println("Now we need to get the Strings input to test the automaton,");
    System.out.println("please insert the file name with the String to be tested,");
    System.out.println("(in the README file there is how to configure the files): ");
    String fileName = scanner.next();

    System.out.println("Now opening file: " + fileName);
    this.lines = Collections.emptyList();

    try {
      this.lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("The string input for testing the automaton: ");

    for(int i = 0; i < this.lines.size(); i++) {
      System.out.println("Test " + i + ": " + this.lines.get(i));
    }

    System.out.println("File read success!!!");

    return this.lines;
  }
}
