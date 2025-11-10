import java.util.Arrays;
import java.util.stream.Collectors;

public class CompetitionResult {
    private String lastName;
    private String firstName;
    private int[] scores;
    private int totalScore;

    public CompetitionResult(String lastName, String firstName, int[] scores) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.scores = scores;
        this.totalScore = Arrays.stream(scores).sum();
    }

    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public int[] getScores() { return scores; }
    public int getTotalScore() { return totalScore; }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " +
                Arrays.stream(scores)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")) +
                " (Сумма: " + totalScore + ")";
    }
}