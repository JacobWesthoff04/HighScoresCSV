import java.util.Scanner;

public class HighScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your initials: ");
        String initials = scanner.nextLine();

        System.out.print("Enter your score: ");
        int score = scanner.nextInt();

        scanner.close();

        Player player = new Player(initials, score);

        System.out.println("Player: " + player.getInitials() + ", " + player.getScore());
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