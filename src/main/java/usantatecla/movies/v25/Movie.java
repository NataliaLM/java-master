package usantatecla.movies.v25;

public class Movie {

    private String title;
    private MovieType movieType;
    private static final int FREQUENT_RENTER_POINTS = 1;
    private static final int DAYS_RENTED_THRESHOLD = 1;
    private static final int FREQUENT_RENTER_POINTS_EXTRA = 2;

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
                if (daysRented > DAYS_RENTED_THRESHOLD) {
                    return FREQUENT_RENTER_POINTS_EXTRA;  
                }
                return FREQUENT_RENTER_POINTS; 
            default:
                return FREQUENT_RENTER_POINTS; 
        }
    }

    public String getTitle() {
        return title;
    }

    public MovieType getMovieType() {
        return movieType;
    }

}
