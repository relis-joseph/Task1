import java.io.File;
import java.util.Scanner;

public class FileInputLoader {
    //Load file from path
    public static void loadFile(String path, PatronManager manager) {
        //Declare id, name, address and fine
        int id;
        String name;
        String address;
        double fine;

        try (Scanner scan_file = new Scanner(new File(path))) {
            while (scan_file.hasNextLine()) {
                String line = scan_file.nextLine();

                //Break the file every "," to check the validity of each patron
                String[] brakeline = line.split(",");

                //each patron mush contains 4 lines otherwise skip
                if (brakeline.length != 4) continue;

                //Assign the variable
                id = Integer.parseInt(brakeline[0].trim());
                name = brakeline[1].trim();
                address = brakeline[2].trim();
                fine = Double.parseDouble(brakeline[3].trim());

                //Id must contain 7 unique digits otherwise skip
                if (id < 1000000 || id > 9999999) continue;
                //name an address must not be empty otherwise skip
                if (name.isEmpty() || address.isEmpty()) continue;
                //fine must be between 0 and 250 otherwise skip
                if (fine < 0 || fine > 250) continue;

                //If condition are met. add patron
                manager.addPatron(new Patron(id, name, address, fine));
            }
        }
        //Show error if any problem found in the file
        catch (Exception e) {
            System.out.println("There may be a problem in the path or file");
        }
    }
}
