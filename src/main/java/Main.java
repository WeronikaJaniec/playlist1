import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Playlist lovePlaylist = new Playlist();

        Playable lovesong1 = new Music("Can't help falling in love","Elvis Presley");
        Playable lovesong2 = new Music("All I want for Christmas","Maria Carrey");

        Playable regularsong = new Music("WINALOTO","Tommy Cash");
        Playable movie = new Movie("Space Oddity");

        lovePlaylist.addPlayable(lovesong1);
        lovePlaylist.addPlayable(lovesong2);

        playlist.addPlayable(regularsong);
        playlist.addPlayable(movie);
        playlist.addPlayable(lovePlaylist);

        System.out.println(playlist.play(Playstyle.SHUFFLE));

    }
}
