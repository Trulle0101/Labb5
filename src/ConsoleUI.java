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

    private void printMenu()
    {
        System.out.println("\n** MOVIE DATABASE **");
        System.out.println("-------------------");
        System.out.println("1. Search title");
        System.out.println("2. Search review score");
        System.out.println("-------------------");
        System.out.println("4. Close program");
    }

    private void searchTitle()
    {
        System.out.print("Enter key word: ");
        String keyword = scanner.nextLine();
        printMovies(database.searchByScore(score));
    }

    private void addMovie()
    {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Review score (1 – 5): ");
        int score = scanner.nextInt();
        scanner.nextLine();

        database.addMovie(new Movie(title, score));
    }
}
