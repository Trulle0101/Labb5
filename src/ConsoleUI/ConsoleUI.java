package ConsoleUI;
import MovieDatabase.MovieDatabase;
import MovieFileHandler.MovieFileHandler;
import Movie.Movie;

import java.util.List;
import java.util.Scanner;

/**
 * Hanterar programmets användargränssnit i konsolen
 */
public class ConsoleUI
{
    private MovieDatabase database;
    private Scanner scanner;

    /**
     * Skapar ett användargränssnitt kopplat till filmdatabas
     * @param database filmdatabasen
     */
    public ConsoleUI(MovieDatabase database)
    {
        this.database = database;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Startar programmets huvudmeny
     */
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
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    /**
     * Skriver ut huvudmenyn
     */
    private void printMenu()
    {
        System.out.println("\n** MOVIE DATABASE **");
        System.out.println("-------------------");
        System.out.println("1. Search title");
        System.out.println("2. Search review score");
        System.out.println("3. Add movie");
        System.out.println("-------------------");
        System.out.println("4. Close program");
    }

    /**
     * Söker filmer baserat på titel
     */
    private void searchTitle()
    {
        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine();
        printMovies(database.searchByTitle(keyword));
    }

    /**
     * Söker filmer baserat på betyg
     */
    private void searchScore()
    {
        System.out.print("Enter minimum review score (1-5): ");
        int score = scanner.nextInt();
        scanner.nextLine();
        printMovies(database.searchByScore(score));
    }

    /**
     * Lägger till en ny film
     */
    private void addMovie()
    {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Review score (1 – 5): ");
        int score = scanner.nextInt();
        scanner.nextLine();

        database.addMovie(new Movie(title, score));
    }

    /**
     * Skriver ut en lista med filmer
     * @param movies lsita med filmer
     */
    private void printMovies(List<Movie> movies)
    {
        for (Movie movie : movies)
        {
            System.out.println("Title: " + movie.getTitle() +
                    "Review score: " + movie.getReviewScore() + "/5");
        }
    }
}
