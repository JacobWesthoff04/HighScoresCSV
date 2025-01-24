import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HighScoresCSV {
    public static void main(String[] args) throws IOException {
        List<Player> players = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("players.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            String initials = data[0];
            int highScore = Integer.parseInt(data[1]);
            players.add(new Player(initials, highScore));
        }
        br.close();

        displayScores("player.csv");
    }
}

class Player {
    private String initials;
    private int score;

    public Player(String initials, int score) {
        this.initials = initials;
        this.score = score;
    }

    public String getInitials() {
        return initials;
    }

    public int getScore() {
        return score;
    }
}