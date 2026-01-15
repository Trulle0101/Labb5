package MovieFileHandler;
import MovieDatabase.MovieDatabase;
import Movie.Movie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MovieFileHandler
{
    private static final String FILE_NAME = "movies.txt";

    public static void saveMovies(Iterable<Movie> movies)
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME)))
        {
            for (Movie movie:movies)
            {
                writer.println(movie.toFileString());
            }
        } catch (IOException e)
        {
            System.out.println("Error saving file.");
        }
    }

    public static void loadMovies(MovieDatabase database)
    {
        File file = new File(FILE_NAME);
        if (!file.exists())
        {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                database.addMovie(Movie.fromFileString(line));
            }
        } catch (IOException e)
        {
            System.out.println("Error reading file.");
        }
    }
}
