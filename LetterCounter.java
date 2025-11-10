import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LetterCounter {
    public void countUniqueLetters() {
        System.out.println("\n=== ЗАДАНИЯ 5.7 и 6.2: Подсчет разных букв в тексте ===");

        try {
            String text = Files.readString(Paths.get("text.txt")).toLowerCase();

            long uniqueLetters = text.chars()
                    .filter(Character::isLetter)
                    .filter(ch -> ch >= 'а' && ch <= 'я')
                    .distinct()
                    .count();

            System.out.println("Количество разных русских букв в тексте: " + uniqueLetters);

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}