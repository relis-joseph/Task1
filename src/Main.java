import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PatronManager patron_manager = new PatronManager();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type the location of a file to read or press Enter to enter in the menu: ");
        //If file is loaded, read by line
        String path = scanner.nextLine();

        if (!path.isBlank()) {
            FileInputLoader.loadFile(path, patron_manager);
        }

        Menu.start(patron_manager);
    }
}
