package usantatecla.movies.v24;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        rentals = new ArrayList<Rental>();
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Iterator<Rental> rentalsIterator = this.rentals.iterator();
        String result = "Rental Record for " + this.getName() + "\n";

        double totalCharge = 0;
        int totalFrequentRenterPoints = 0;

        while (rentalsIterator.hasNext()) {
            Rental each = rentalsIterator.next();

            totalCharge += each.getCharge();
            totalFrequentRenterPoints += each.getFrequentRenterPoints();

            result += "\t" + each.getMovieTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        result += "Amount owed is " + String.valueOf(totalCharge) + "\n";
        result += "You earned " + String.valueOf(totalFrequentRenterPoints) + " frequent renter points";

        return result;
    }
}
