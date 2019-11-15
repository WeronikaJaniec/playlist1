import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Playlist implements Playable{
    private List<Playable> playableList = new ArrayList<Playable>();

    public List<Playable> getPlayableList() {
        return playableList;
    }

    public String play() {
       return playableList.stream().map(p -> p.play()).collect(Collectors.joining("\n"));
    }

    public String play(Playstyle  playstyle) {
        switch (playstyle){
            case SEQUENCE:
                return play();
            case LOOP:
                return playInLoop();
            case SHUFFLE:
                return playShuffled();
        }
        //to make your own exception
        return play();
    }

    private String playShuffled() {
        List<Playable> copy = new ArrayList<>(playableList);
        Collections.shuffle(copy);
        return copy.stream().map(p -> p.play()).collect(Collectors.joining("\n"));
    }

    private String playInLoop() {
        String loop = "";
        for (int i = 0; i < 4; i++) {
            loop += play();
        }
        return loop;
    }


    public void addPlayable(Playable playable) {
        playableList.add(playable);
    }

}
