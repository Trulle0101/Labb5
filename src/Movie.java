public class Movie
{
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
        return title + "" + reviewScore;
    }

}
