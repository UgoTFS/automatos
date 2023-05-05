import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.project.setup.AutomatonSetup;
import com.project.test.AutomatonTestSuite;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to a simple automaton application!\n");
        System.out.println("Please enter the file name with the automaton: \n");
        
        Scanner userInput = new Scanner(System.in);
        String fileName = userInput.nextLine();
        AutomatonTestSuite testFileOutput = new AutomatonTestSuite();

        System.out.println("\nOpenning the file: " + fileName + "\n");
        List<String> fileLineList = AutomatonSetup.getLines(fileName);
        
        System.out.println("File has " + fileLineList.size() + " lines\n");
        
        for(int i = 0; i < fileLineList.size(); i++){
            System.out.println("line " + (i+1) + ": " + fileLineList.get(i));
        }
        
        System.out.println("\nOrganizing file content...\n");
        System.out.println("First line contains automaton states, and they are: \n");
        
        List<String> statesList = Arrays.asList(fileLineList.get(0).split(" "));
        for(int i = 0; i < statesList.size(); i++){
            System.out.println("state " + (i+1) + " : " + statesList.get(i));
        }
        System.out.println("\nNow getting the alphabet that the automaton accepts, and it is: \n");
        
        List<String> alphaList = Arrays.asList(fileLineList.get(1).split(" "));
        for(int i = 0; i < alphaList.size(); i++){
            System.out.println("character " + (i+1) + " : " + alphaList.get(i));
        }

        System.out.println("\nClosing test file: " + testFileOutput.getFileName());
        testFileOutput.closeFile();

    }
}