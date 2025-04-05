package usantatecla.movies.v25;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerChargeTest {

    @Test
    public void regularRental1Day_chargeIsCorrect() {
        Movie movie = new MovieBuilder().regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        assertEquals(2.0, rental.getCharge(), 0.001);
    }

    @Test
    public void regularRental2Day_chargeIsCorrect() {
        Movie movie = new MovieBuilder().regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        assertEquals(2.0, rental.getCharge(), 0.001);
    }

    @Test
    public void regularRental3Day_chargeIsCorrect() {
        Movie movie = new MovieBuilder().regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        assertEquals(3.5, rental.getCharge(), 0.001);
    }

    @Test
    public void newReleaseRental1Day_chargeIsCorrect() {
        Movie movie = new MovieBuilder().newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        assertEquals(3.0, rental.getCharge(), 0.001);
    }

    @Test
    public void newReleaseRental2Day_chargeIsCorrect() {
        Movie movie = new MovieBuilder().newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        assertEquals(3.0, rental.getCharge(), 0.001);
    }

    @Test
    public void childrensRental1Day_chargeIsCorrect() {
        Movie movie = new MovieBuilder().childrens().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        assertEquals(1.5, rental.getCharge(), 0.001);
    }

    @Test
    public void childrensRental4Day_chargeIsCorrect() {
        Movie movie = new MovieBuilder().childrens().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(4).build();
        assertEquals(6.0, rental.getCharge(), 0.001);
    }
}
