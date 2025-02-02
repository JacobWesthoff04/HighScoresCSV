import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class HighScoresCSV {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 to enter your information");
        System.out.println("Press 2 to see the scoreboard");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            int lineNumber = lastLineNumber() + 1;
            System.out.print("Enter your initials: ");
            String initials = scanner.nextLine();

            System.out.print("Enter your score: ");
            String score = scanner.nextLine();

            try (FileWriter fw = new FileWriter("players.csv", true)) {
                fw.append("#").append(String.valueOf(lineNumber)).append(" ");
                fw.append(initials).append(",");
                fw.append(score).append("\n");
            }
        } else {
            List<String[]> scores = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("players.csv"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        scores.add(parts);
                    }
                    System.out.println(line);
                }
            }
        }
        scanner.close();
    }

    private static int lastLineNumber() {
        int lastNumber = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("players.csv"))) {
            String line, lastLine = null;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) lastLine = line;
            }
            
            if (lastLine != null) {
                String[] parts = lastLine.split(" ");
                if (parts.length > 0 && parts[0].startsWith("#")) {
                    lastNumber = Integer.parseInt(parts[0].substring(1));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("No previouse scores recored, starting at #1");
        }
        return lastNumber;
    }

}