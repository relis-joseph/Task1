public class Patron {
    //Declare patron's variable as final
    private final int id_patron;
    private final String patron_name;
    private final String patron_address;
    private final double overdue_fine;

    public Patron(int id_patron, String patron_name, String patron_address, double overdue_fine) {
        this.id_patron = id_patron;
        this.patron_name = patron_name;
        this.patron_address = patron_address;
        this.overdue_fine = overdue_fine;
    }

    //Getter of patron's id
    public int getPatronID() {
        return id_patron;
    }

    //Getter of patron's name
    public String getName() {
        return patron_name;
    }

    //Getter of patron's address
    public String getAddress() {
        return patron_address;
    }

    //Getter of patron's fine
    public double getOverdueFine() {
        return overdue_fine;
    }

    //toString return
    @Override
    public String toString() {
        return id_patron + " ** " + patron_name + " ** " + patron_address + " ** Fine: " + overdue_fine;
    }
}
