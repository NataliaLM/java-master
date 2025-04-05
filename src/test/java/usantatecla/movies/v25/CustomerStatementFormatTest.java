package usantatecla.movies.v25;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerStatementFormatTest {

    @Test
    public void withoutRentals_statementIsCorrect() {
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).build();

        String expected = new StatementBuilder()
            .customerName(customerName)
            .totalAmount(0)
            .frequentRenterPoints(0)
            .build();

        assertEquals(expected, customer.statement());
    }

    @Test
    public void regularRental3Day_statementIsCorrect() {
        String movieName = "movieName";
        Movie movie = new MovieBuilder().title(movieName).regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        String customerName = "customerName";

        Customer customer = new CustomerBuilder()
            .name(customerName)
            .rental(rental)
            .build();

        String expected = new StatementBuilder()
            .customerName(customerName)
            .movie(movieName, 3.5)
            .totalAmount(3.5)
            .frequentRenterPoints(1)
            .build();

        assertEquals(expected, customer.statement());
    }

    @Test
    public void newReleaseRental2Day_statementIsCorrect() {
        String movieName = "movieName";
        Movie movie = new MovieBuilder().title(movieName).newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        String customerName = "customerName";

        Customer customer = new CustomerBuilder()
            .name(customerName)
            .rental(rental)
            .build();

        String expected = new StatementBuilder()
            .customerName(customerName)
            .movie(movieName, 3)
            .totalAmount(3)
            .frequentRenterPoints(2)
            .build();

        assertEquals(expected, customer.statement());
    }

    @Test
    public void childrensRental4Day_statementIsCorrect() {
        String movieName = "movieName";
        Movie movie = new MovieBuilder().title(movieName).childrens().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(4).build();
        String customerName = "customerName";

        Customer customer = new CustomerBuilder()
            .name(customerName)
            .rental(rental)
            .build();

        String expected = new StatementBuilder()
            .customerName(customerName)
            .movie(movieName, 6)
            .totalAmount(6)
            .frequentRenterPoints(1)
            .build();

        assertEquals(expected, customer.statement());
    }

    @Test
    public void multipleRentals_statementIsCorrect() {
        String regularMovie = "regularMovieName";
        String newReleaseMovie = "newReleaseMovieName";
        String childrensMovie = "childrensMovieName";

        Rental regularRental = new RentalBuilder()
            .movie(new MovieBuilder().title(regularMovie).regular().build())
            .daysRented(10)
            .build();

        Rental newReleaseRental = new RentalBuilder()
            .movie(new MovieBuilder().title(newReleaseMovie).newRelease().build())
            .daysRented(10)
            .build();

        Rental childrensRental = new RentalBuilder()
            .movie(new MovieBuilder().title(childrensMovie).childrens().build())
            .daysRented(10)
            .build();

        Customer customer = new CustomerBuilder()
            .name("customerName")
            .rental(regularRental)
            .rental(newReleaseRental)
            .rental(childrensRental)
            .build();

        String expected = new StatementBuilder()
            .customerName("customerName")
            .movie(regularMovie, 14)
            .movie(newReleaseMovie, 3)
            .movie(childrensMovie, 15)
            .totalAmount(32)
            .frequentRenterPoints(4)
            .build();

        assertEquals(expected, customer.statement());
    }
}
