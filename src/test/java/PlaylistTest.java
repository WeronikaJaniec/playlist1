import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlaylistTest {

    //given everywhere
    private Playlist playlist = new Playlist();
    private Playlist lovePlaylist = new Playlist();
    private Playable music = new Music("Mamma-Mia!","Abba");
    private Playable movie = new Movie("Titanic");

    @Test
    public void returnsEmptyListWhenCreated() {
        //when
        List<Playable> playables = playlist.getPlayableList();
        //then
       assertThat(playables.size(), is (0));
    }

    @Test
    public void returnsListWithMusicElementWhenYouAddMusic(){
        //when
        playlist.addPlayable(music);
        List<Playable> playables = playlist.getPlayableList();
        //then
        assertThat(playables.contains(music), is (true));
    }

    @Test
    public void returnsListWithMovieElementWhenYouAddMovie(){
        //when
        playlist.addPlayable(movie);
        List<Playable> playables = playlist.getPlayableList();
        //then
        assertThat(playables.contains(movie), is (true));
    }

    @Test
    public void returnsListWithPlaylistElementWhenYouAddPlaylist(){
        //when
        playlist.addPlayable(lovePlaylist);
        List<Playable> playables = playlist.getPlayableList();
        //then
        assertThat(playables.contains(lovePlaylist), is (true));
    }

    @Test
    public void returnsPlaylistsContentWhenPlayed(){
        //when
        playlist.addPlayable(music);
        playlist.addPlayable(movie);
        lovePlaylist.addPlayable(music);
        playlist.addPlayable(lovePlaylist);
        String playPath = playlist.play();
        //then
        assertThat(playPath, is (music.play()+"\n"+movie.play()+"\n"+music.play()));
    }

    @Test
    public void returnsPlaylistsContentInLoopWhenPlayedInLoop(){
        //when
        playlist.addPlayable(music);
        playlist.addPlayable(movie);
        lovePlaylist.addPlayable(music);
        playlist.addPlayable(lovePlaylist);
        String playPath = playlist.play(Playstyle.LOOP);
        //then
        assertThat(playPath, is (music.play()+"\n"+movie.play()+"\n"+music.play()
                +music.play()+"\n"+movie.play()+"\n" +music.play()
                +music.play()+"\n"+movie.play()+"\n"+music.play()
                +music.play()+"\n"+movie.play()+"\n"+music.play()));
    }

    @Test
    public void returnsPlaylistsContentInShuffleWhenPlayedInShuffle(){
        //when
        playlist.addPlayable(music);
        playlist.addPlayable(movie);
        lovePlaylist.addPlayable(music);
        playlist.addPlayable(lovePlaylist);
        String playPath = playlist.play(Playstyle.SHUFFLE);
        //then
        assertThat(playPath, not (music.play()+"\n"+movie.play()+"\n"+music.play()));
    }












}
