package com.project.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AutomatonTestSuite {
  private BufferedWriter testOutput;
  private String testFileName;

  public AutomatonTestSuite() throws IOException{
    this.testFileName = "test0.txt";
    for (int i = 0; hasTestFile(this.testFileName); i++) {
      System.out.println(this.testFileName);
      this.testFileName = addExtension("test" + i);
    }
    System.out.println(this.testFileName);
    System.out.println("Saida loop nome...");
    this.testOutput = new BufferedWriter(new FileWriter(this.testFileName));
  }

  public void writeTestLine(String testLine) throws IOException {
    this.testOutput.write(testLine + "\n");
  }

  public void writeTestAllLines(String testAllLines) throws IOException {
    this.testOutput.write(testAllLines);
  }

  public boolean hasTestFile(String testFileName) {
    return new File(testFileName).exists();
  }

  public String addExtension(String filename) {
    return filename + ".txt";
  }

  public void closeFile() throws IOException {
    this.testOutput.close();
  }

  public String getFileName(){
    return this.testFileName;
  }
}
