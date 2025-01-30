import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class HighScoresCSV {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your initials: ");
            String initials = scanner.nextLine();

            System.out.print("Enter your score: ");
            String score = scanner.nextLine();

            try (FileWriter fw = new FileWriter("players.csv", true)) {
                fw.append(initials).append(",");
                fw.append(score).append("\n");
            }
        }
    }
}