package Movie;

/**
 * Den här klassen representerar en film med titel och betyg.
 */
public class Movie
{
    private String title;
    private int reviewScore;

    /**
     * Skapar en ny film i databasen
     * @param title filmens titel
     * @param reviewScore filmens betyg (1-5)
     */
    public Movie(String title, int reviewScore)
    {
        this.title = title;
        this.reviewScore = reviewScore;
    }

    /**
     * @return returnerar filmens titel
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @return returnerar filmens betyg
     */
    public int getReviewScore()
    {
        return reviewScore;
    }

    /**
     * Omvandlar filme till en sträng som kan sparas i fil.
     * @return returnerar filmdata som text
     */
    public String toFileString()
    {
        return title + ";" + reviewScore;
    }

    /**
     * Skapar en film från en rad i en fil
     * @param line en textrad från filen
     * @return returnar ett film-objekt
     */
    public static Movie fromFileString(String line)
    {
        String[] parts = line.split(";");
        return new Movie(parts[0], Integer.parseInt(parts[1]));
    }
}
