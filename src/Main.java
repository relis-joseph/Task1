import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        patron_manager patron_manager = new patron_manager();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome to our program:\n");
        System.out.print("Press enter to go the menu or any other key to read a file: ");

        //If file is loaded, read by line
        String path = scanner.nextLine();

        //Check path before loading it
        if (!path.isBlank()) {
            FileInputLoader.loadFile(patron_manager);
        } else {
            Menu.start(patron_manager);
        }
    }
}
