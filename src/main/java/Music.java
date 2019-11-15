public class Music  implements Playable {
    private String title;
    private String creator;

    public Music(String title, String creator) {
        this.title = title;
        this.creator = creator;
    }

    public String play() {
        return "Song " + title + " by: " + creator;
    }
}
