import java.util.Scanner;

public class Menu {

    public static void start(PatronManager manager) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nPress 1 to add a patron");
            System.out.println("Press 2 to remove patron");
            System.out.println("Press 3 to display all patrons");
            System.out.println("Press 4 to exit the program");
            System.out.print("Choose an option: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            while (choice < 1 || choice > 4) {
                System.out.print("Please enter a valid option (1–4): ");
                while (!scanner.hasNextInt()) {
                    scanner.next();
                }
                choice = scanner.nextInt();
                scanner.nextLine();
            }

            switch (choice) {
                case 1 -> addPatron(scanner, manager);
                case 2 -> removePatron(scanner, manager);
                case 3 -> displayPatrons(manager);
                case 4 -> System.out.println("Thank you for using our program");
            }

        } while (choice != 4);
    }

    private static void addPatron(Scanner scanner, PatronManager manager) {

        int id;
        do {
            System.out.print("Please type the patron's 7-digit ID: ");
            while (!scanner.hasNextInt()) {
                System.out.print("ID must be numeric. Try again: ");
                scanner.next();
            }
            id = scanner.nextInt();
            scanner.nextLine();
        } while (id < 1000000 || id > 9999999);

        String name;
        do {
            System.out.print("Please type the patron's name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty() || !name.matches("[a-zA-Z ]+")) {
                System.out.println("Name cannot contain numbers and cannot be empty.");
            }
        } while (name.isEmpty() || !name.matches("[a-zA-Z ]+"));


        String address;
        do {
            System.out.print("Please type the patron's address: ");
            address = scanner.nextLine().trim();
            if (address.isEmpty() || !address.matches("[a-zA-Z ]+")) {
                System.out.println("Please check the address.");
            }
        } while (address.isEmpty() || !address.matches("[a-zA-Z ]+"));


        double fine;
        do {
            System.out.print("Please type the overdue fine amount (0–250): ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Please enter a valid amount: ");
                scanner.next();
            }
            fine = scanner.nextDouble();
            if (fine < 0 || fine > 250) {
                System.out.print("Wrong amount entry: \n");
            }
        } while (fine < 0 || fine > 250);

        if (manager.addPatron(new Patron(id, name, address, fine))) {
            System.out.println("Patron added.");
        } else {
            System.out.println("Duplicate ID. Patron not added.");
        }
    }

    private static void removePatron(Scanner scanner, PatronManager manager) {
        System.out.print("Enter patron ID to remove: ");

        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid ID: ");
            scanner.next();
        }

        int id = scanner.nextInt();

        if (manager.removePatron(id)) {
            System.out.println("Patron removed successfully.");
        } else {
            System.out.println("Patron ID not found.");
        }
    }

    private static void displayPatrons(PatronManager manager) {
        if (manager.getAllPatrons().isEmpty()) {
            System.out.println("No patrons found.");
        } else {
            manager.getAllPatrons().forEach(System.out::println);
        }
    }
}
