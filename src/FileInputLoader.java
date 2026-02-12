import java.io.File;
import java.util.Scanner;

public class FileInputLoader {
    //Load file from path
    public static void loadFile(patron_manager manager) {
        //Variable declaration
        int id;
        String name;
        String address;
        double fine;
        int addedCount = 0;
        Scanner input = new Scanner(System.in);
        patron_manager patron_manager = new patron_manager();

        boolean fileLoaded = false;

        while (!fileLoaded) {
            System.out.print("Please enter file path to read or press \"b\" to go back: ");
            String path = input.nextLine().trim();

            if (path.equalsIgnoreCase("b")) {
                Menu.start(manager);
            }
            //Try scan and catch error
            try (Scanner scanFile = new Scanner(new File(path))) {

                while (scanFile.hasNextLine()) {
                    //Read each line
                    String line = scanFile.nextLine().trim();
                    if (line.isEmpty()) continue;

                    //Split every "," for catch each item
                    String[] parts = line.split(",");

                    //Check if found more items than expected
                    if (parts.length != 4) {
                        System.out.println("Skipping invalid line: " + line);
                        continue;
                    }

                    try {
                        id = Integer.parseInt(parts[0].trim());
                        name = parts[1].trim();
                        address = parts[2].trim();
                        fine = Double.parseDouble(parts[3].trim());

                        // Validation of each variable
                        if (id < 1000000 || id > 9999999) {
                            System.out.println("Skipping invalid ID: " + id);
                            continue;
                        }
                        //Name must be string and not empty and does not contain number
                        if (name.isEmpty() || !name.matches("[a-zA-Z ]+")) {
                            System.out.println("Skipping invalid name: " + name);
                            continue;
                        }
                        //Name must be string and not empty
                        if (address.isEmpty()) {
                            System.out.println("Skipping empty address");
                            continue;
                        }
                        //Fine must be between 0 and 250
                        if (fine < 0 || fine > 250) {
                            System.out.println("Skipping invalid fine: " + fine);
                            continue;
                        }

                        //Check if id is not already there
                        if (manager.addPatron(new Patron(id, name, address, fine))) {
                            addedCount++;
                            System.out.println("Successfully added patron: " + name);
                        } else {
                            System.out.println("Failed duplicate id: " + id);
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Line skipped, wrong format: " + line);
                    }
                }

                System.out.println("File loading completed");
                fileLoaded = true;
                Menu.start(manager);
            } catch (Exception e) {
                System.out.println("There may be a problem in path provided: ");
            }
        }
    }
}
