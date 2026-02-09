import java.util.ArrayList;
import java.util.List;

//Class to manage patron
public class patron_manager {

    //List of patron in an Arraylist
    private List<Patron> patrons = new ArrayList<>();

    //logic to add patron
    public boolean addPatron(Patron patron) {
        //Check if id is already in the system
        for (Patron p : patrons) {
            if (p.getPatronID() == patron.getPatronID()) {
                return false;
            }
        }

        //if not, add patron and return
        patrons.add(patron);
        return true;
    }

    //function to remove patron
    public boolean removePatron(int id) {
        return patrons.removeIf(p -> p.getPatronID() == id);
    }

    //function to display all patron
    public List<Patron> getAllPatrons() {
        return patrons;
    }
}
