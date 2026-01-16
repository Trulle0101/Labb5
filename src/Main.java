import ConsoleUI.ConsoleUI;
import MovieDatabase.MovieDatabase;
import MovieFileHandler.MovieFileHandler;

/**
 * Start klass för filmdatabasprogrammet.
 * Ansvarar för att starta programmet och koppla ihop programmets olika klasser
 */
public class Main
{
    /**
     * Programemt startpunkt.
     * Skapar databasen, laddar filmer från fil och startar användargränssnittet.
     * @param args
     */
    public static void main(String[] args)
    {
        MovieDatabase database = new MovieDatabase();
        MovieFileHandler.loadMovies(database);
        ConsoleUI ui = new ConsoleUI(database);
        ui.start();
    }
}