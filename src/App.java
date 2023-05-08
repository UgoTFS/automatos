
import java.util.Scanner;

import com.project.Interfaces.AppMenu;
import com.project.service.AppMainMenu;
import com.project.setup.AppMainMenuSetup;

public class App {
    public static void main(String[] args) throws Exception {

        try (Scanner scanner = new Scanner(System.in)) {

            // Starting program
            AppMenu mainMenu = new AppMainMenu();
            int mainMenuOption = mainMenu.show(scanner);
            System.out.println("The choosen options was: " + mainMenuOption);
            AppMainMenuSetup appSetup = new AppMainMenuSetup();
            appSetup.run(mainMenuOption, scanner);

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}