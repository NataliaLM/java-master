package usantatecla.movies.v25;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerMovieTest {

    @Test
    public void regularRental_movieIsCorrect() {
        Movie movie = new MovieBuilder().title("Regular Movie").regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();

        assertEquals(movie, rental.getMovie());
    }

    @Test
    public void newReleaseRental_movieIsCorrect() {
        Movie movie = new MovieBuilder().title("New Release Movie").newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();

        assertEquals(movie, rental.getMovie());
    }

    @Test
    public void childrensRental_movieIsCorrect() {
        Movie movie = new MovieBuilder().title("Children's Movie").childrens().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(4).build();

        assertEquals(movie, rental.getMovie());
    }
}
