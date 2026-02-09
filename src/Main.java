import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        patron_manager patron_manager = new patron_manager();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome to our program:\n");
        System.out.print("Type the location of a file or press Enter to enter in the menu: ");

        //If file is loaded, read by line
        String path = scanner.nextLine();

        //Check path before loading it
        if (!path.isBlank()) {
            FileInputLoader.loadFile(path, patron_manager);
        }
        Menu.start(patron_manager);
    }
}
