import ConsoleUI.ConsoleUI;
import MovieDatabase.MovieDatabase;
import MovieFileHandler.MovieFileHandler;

public class Main
{
    public static void main(String[] args)
    {
        MovieDatabase database = new MovieDatabase();
        MovieFileHandler.loadMovies(database);
        ConsoleUI ui = new ConsoleUI(database);
        ui.start();
    }
}