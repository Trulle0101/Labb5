import java.io.IOException;
import java.io.PrintWriter;

public class MovieFileHandler
{
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
}
