package usantatecla.movies.v25;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerFrequentRenterPointsTest {

    @Test
    public void regularRental_frequentRenterPointsIsCorrect() {
        Movie movie = new MovieBuilder().regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        assertEquals(1, rental.getFrequentRenterPoints());
    }

    @Test
    public void newReleaseRental1Day_frequentRenterPointsIsCorrect() {
        Movie movie = new MovieBuilder().newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        assertEquals(1, rental.getFrequentRenterPoints());
    }

    @Test
    public void newReleaseRental2Day_frequentRenterPointsIsCorrect() {
        Movie movie = new MovieBuilder().newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        assertEquals(2, rental.getFrequentRenterPoints());
    }

    @Test
    public void childrensRental_frequentRenterPointsIsCorrect() {
        Movie movie = new MovieBuilder().childrens().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(4).build();
        assertEquals(1, rental.getFrequentRenterPoints());
    }
}
