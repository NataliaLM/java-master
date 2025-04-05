package usantatecla.movies.v25;

public class Movie {

    private String title;
    private MovieType movieType;

    public enum MovieType {
        REGULAR, NEW_RELEASE, CHILDREN
    }

    public Movie(String title, MovieType movieType) {
        this.title = title;
        this.movieType = movieType;
    }

    public double getCharge(int daysRented) {
        switch (movieType) {
            case NEW_RELEASE:
                return 3.0;
            case CHILDREN:
                if (daysRented > 3) {
                    return 1.5 + (daysRented - 1) * 1.5;
                } else {
                    return 1.5;
                }
            case REGULAR:
                if (daysRented > 2) {
                    return 2.0 + (daysRented - 2) * 1.5;
                } else {
                    return 2.0;
                }
            default:
                throw new IllegalArgumentException("Unknown movie type");
        }
    }

    public int getFrequentRenterPoints(int daysRented) {
        switch (movieType) {
            case NEW_RELEASE:
                if (daysRented > 1) {
                    return 2; // New release gives extra points if rented more than 1 day
                }
                return 1; // Regular points for new release rented for 1 day
            default:
                return 1; // Regular movies and children movies always earn 1 point
        }
    }

    public String getTitle() {
        return title;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }
}
