public class Movie implements Playable{
    private String title;

    public Movie(String title) {
        this.title =  title;
    }

    public String play() {
        return "Movie: " + title;
    }
}
