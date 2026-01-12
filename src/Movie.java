public class Movie
{
    private String title;
    private int reviewScore;

    public Movie(String title, int reviewScore)
    {
        this.title = title;
        this.reviewScore = reviewScore;
    }

    public String getTitle()
    {
        return title;
    }

    public int getReviewScore()
    {
        return reviewScore;
    }

    public String toFileString()
    {
        return title + ";" + reviewScore;
    }

    public static Movie fromFileString(String line)
    {
        String[] parts = line.split(";");
        return new Movie(parts[0], Integer.parseInt(parts[1]));
    }
}
