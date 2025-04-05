package usantatecla.movies.v25;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CustomerDaysRentedTest {

    @Test
    public void regularRental3DaysTest() {
        String movieName = "movieName";
        int daysRented = 3; 

        Movie movie = new MovieBuilder().title(movieName).regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(daysRented).build();
 
        assertEquals(daysRented, rental.getDaysRented()); 
    }

    @Test
    public void newReleaseRental2DaysTest() {
        String movieName = "movieName";
        int daysRented = 2; 

        Movie movie = new MovieBuilder().title(movieName).newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(daysRented).build();
 
        assertEquals(daysRented, rental.getDaysRented()); 
    }

    @Test
    public void childrensRental4DaysTest() {
        String movieName = "movieName";
        int daysRented = 4; 

        Movie movie = new MovieBuilder().title(movieName).childrens().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(daysRented).build();
 
        assertEquals(daysRented, rental.getDaysRented()); 
    }
 
}
