
import java.io.IOException;
import java.util.Scanner;

import com.project.Interfaces.AppMenu;
import com.project.service.AppMainMenu;
import com.project.setup.AppMainMenuSetup;

public class App {
    public static void main(String[] args) throws IOException {

        try (Scanner scanner = new Scanner(System.in)) {

            // Starting program
            AppMenu mainMenu = new AppMainMenu();
            int mainMenuOption = mainMenu.show(scanner);
            System.out.println("The choosen options was: " + mainMenuOption);
            AppMainMenuSetup appSetup = new AppMainMenuSetup();
            appSetup.run(mainMenuOption, scanner);

        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}