package MovieDatabase;

import Movie.Movie;
import java.util.ArrayList;
import java.util.List;

/**
 * Ansvarar för att lagra och söka filmer i filmdatabasen
 */
public class MovieDatabase
{

    private List<Movie> movies = new ArrayList<>();

    /**
     * Lägger till en film i databasen
     * @param movie filmen som ska läggas till
     */
    public void addMovie(Movie movie)
    {
        movies.add(movie);
    }

    /**
     * Söker filmer baserat på deras titel
     * @param keyword sökord
     * @return lista med matchande filmer
     */
    public List<Movie> searchByTitle(String keyword)
    {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies)
        {
            if (movie.getTitle().toLowerCase().contains(keyword.toLowerCase()))
            {
                result.add(movie);
            }
        }
        return result;
    }

    /**
     * Söker filmer med ett visst minsta betyg
     * @param minScore lägsta betyg
     * @return lista med matchande filmer
     */
    public List<Movie> searchByScore(int minScore)
    {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies)
        {
            if (movie.getReviewScore() >= minScore)
            {
                result.add(movie);
            }
        }
        return result;
    }

    /**
     * @return returnerar alla filmer i databasen
     */
    public List<Movie> getAllMovies()
    {
        return movies;
    }
}
