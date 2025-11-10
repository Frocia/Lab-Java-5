import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CompetitionProcessor {
    private List<CompetitionResult> participants;

    public CompetitionProcessor() {
        this.participants = new ArrayList<>();
    }

    public void processCompetitionResults() {
        System.out.println("\n=== ЗАДАНИЕ 4: Результаты соревнований по многоборью ===");

        try {
            List<String> lines = Files.readAllLines(Paths.get("competition.txt"));

            if (lines.isEmpty()) {
                System.out.println("Файл пуст!");
                return;
            }

            int n = Integer.parseInt(lines.get(0).trim());

            for (int i = 1; i <= n && i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split(" ");

                if (parts.length >= 6) {
                    String lastName = parts[0];
                    String firstName = parts[1];
                    int[] scores = new int[4];

                    for (int j = 0; j < 4; j++) {
                        scores[j] = Integer.parseInt(parts[2 + j]);
                    }

                    participants.add(new CompetitionResult(lastName, firstName, scores));
                }
            }

            participants.sort((p1, p2) -> Integer.compare(p2.getTotalScore(), p1.getTotalScore()));

            Set<Integer> topScores = new HashSet<>();
            for (int i = 0; i < Math.min(3, participants.size()); i++) {
                topScores.add(participants.get(i).getTotalScore());
            }

            System.out.println("Лучшие участники:");
            for (CompetitionResult participant : participants) {
                if (topScores.contains(participant.getTotalScore())) {
                    System.out.println(participant);
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка формата данных: " + e.getMessage());
        }
    }
}