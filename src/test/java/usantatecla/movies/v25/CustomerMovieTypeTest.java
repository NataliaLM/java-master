package usantatecla.movies.v25;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerMovieTypeTest {

    @Test
    public void regularMovie_movieTypeIsCorrect() {
        Movie movie = new MovieBuilder().regular().build();
        assertEquals(Movie.MovieType.REGULAR, movie.getMovieType());
    }

    @Test
    public void newReleaseMovie_movieTypeIsCorrect() {
        Movie movie = new MovieBuilder().newRelease().build();
        assertEquals(Movie.MovieType.NEW_RELEASE, movie.getMovieType());
    }

    @Test
    public void childrensMovie_movieTypeIsCorrect() {
        Movie movie = new MovieBuilder().childrens().build();
        assertEquals(Movie.MovieType.CHILDREN, movie.getMovieType());
    }
}
