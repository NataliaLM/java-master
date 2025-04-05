package usantatecla.movies.v24;

public class MovieBuilder {

    private String title;
    private Movie.MovieType movieType;

    public MovieBuilder() {
        this.title = "movieName";
        this.movieType = Movie.MovieType.REGULAR;
    }

    public MovieBuilder title(String title) {
        this.title = title;
        return this;
    }

    public MovieBuilder childrens() {
        this.movieType = Movie.MovieType.CHILDREN;
        return this;
    }

    public MovieBuilder regular() {
        this.movieType = Movie.MovieType.REGULAR;
        return this;
    }

    public MovieBuilder newRelease() {
        this.movieType = Movie.MovieType.NEW_RELEASE;
        return this;
    }

    public Movie build() {
        return new Movie(title, movieType);
    }
}
