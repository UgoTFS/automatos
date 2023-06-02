package com.project.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.project.app.utils.AutomatonType;

public class AutomatonTestSuite {
  private BufferedWriter testOutput;
  private String testFileName;

  public AutomatonTestSuite(AutomatonType automatonType) throws IOException{
    this.testFileName = automatonType.toString() + "_test_0.txt";
    for (int i = 0; hasTestFile(this.testFileName); i++) {
      System.out.println(this.testFileName);
      this.testFileName = nameTestFile(automatonType, i).toLowerCase();
    }
    System.out.println(this.testFileName);
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

  public String nameTestFile(AutomatonType automatonType, int testNumber) {
    return automatonType.toString().toLowerCase() + "_test_" + testNumber + ".txt";
  }

  public void closeFile() throws IOException {
    this.testOutput.close();
  }

  public String getFileName(){
    return this.testFileName;
  }
}
