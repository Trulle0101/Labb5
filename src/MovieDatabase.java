import java.util.ArrayList;

public class MovieDatabase
{

    public void addMovie(Movie movie)
    {
        movies.add(movie);
    }

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

    public List<Movie> getAllMoives()
    {
        return movies;
    }
}
