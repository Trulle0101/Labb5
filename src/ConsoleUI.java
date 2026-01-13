import java.util.List;
import java.util.Scanner;

public class ConsoleUI
{
    public ConsoleUI(MovieDatabase database)
    {
        this.database = database;
        this.scanner = new Scanner(System.in);
    }

    public void start()
    {
        boolean running = true;

        while (running)
        {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1 -> searchTitle();
                case 2 -> searchScore();
                case 3 -> addMovie();
                case 4 ->
                {
                    MovieFileHandler.saveMovies(database.getAllMovies());
                    running = false;
                }
            }
        }
    }
}
