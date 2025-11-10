import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Инициализация процессоров
        CompetitionProcessor competitionProcessor = new CompetitionProcessor();
        LetterCounter letterCounter = new LetterCounter();
        PointProcessor pointProcessor = new PointProcessor();

        System.out.println("ЛАБОРАТОРНАЯ РАБОТА - ВСЕ 8 ЗАДАНИЙ");
        System.out.println("====================================");

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1 - Демонстрация работы всех классов");
            System.out.println("2 - Задание 1.1: Дробь с кэшированием");
            System.out.println("3 - Задание 2.1: Кот и мяуканье");
            System.out.println("4 - Задание 3.3: Упорядоченные списки");
            System.out.println("5 - Задание 4.3: Результаты соревнований");
            System.out.println("6 - Задания 5.7 и 6.2: Подсчет разных букв");
            System.out.println("7 - Задания 7.1 и 7.2: Обработка точек");
            System.out.println("8 - Выполнить все задания");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        demonstrateAllClasses();
                        break;
                    case 2:
                        demonstrateFraction();
                        break;
                    case 3:
                        demonstrateCats();
                        break;
                    case 4:
                        demonstrateListMerger();
                        break;
                    case 5:
                        competitionProcessor.processCompetitionResults();
                        break;
                    case 6:
                        letterCounter.countUniqueLetters();
                        break;
                    case 7:
                        pointProcessor.processPointsStream();
                        break;
                    case 8:
                        demonstrateAllClasses();
                        demonstrateFraction();
                        demonstrateCats();
                        demonstrateListMerger();
                        competitionProcessor.processCompetitionResults();
                        letterCounter.countUniqueLetters();
                        pointProcessor.processPointsStream();
                        break;
                    case 0:
                        System.out.println("Выход из программы.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите число!");
                scanner.nextLine();
            }
        }
    }

    private static void demonstrateAllClasses() {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ РАБОТЫ ВСЕХ КЛАССОВ ===");

        // Демонстрация Point, Line, Polyline
        Point p1 = new Point(10, 20);
        Point p2 = new Point(30, 40);
        System.out.println("Точка 1: " + p1);
        System.out.println("Точка 2: " + p2);

        Line line = new Line(p1, p2);
        System.out.println("Линия: " + line);

        List<Point> polyPoints = Arrays.asList(
                new Point(1, 1),
                new Point(2, 3),
                new Point(4, 2)
        );
        Polyline polyline = new Polyline(polyPoints);
        System.out.println("Ломаная: " + polyline);

        // Демонстрация CompetitionResult
        int[] scores = {5, 8, 6, 3};
        CompetitionResult result = new CompetitionResult("Иванова", "Мария", scores);
        System.out.println("Результат соревнований: " + result);
    }

    private static void demonstrateFraction() {
        System.out.println("\n=== ЗАДАНИЕ 1.1: Дробь с кэшированием ===");

        Fraction fraction1 = new Fraction(3, 4);
        System.out.println("Дробь 1: " + fraction1);
        System.out.println("Вещественное значение: " + fraction1.getDecimalValue());
        System.out.println("Вещественное значение (из кэша): " + fraction1.getDecimalValue());

        Fraction fraction2 = new Fraction(-2, -3);
        System.out.println("Дробь 2: " + fraction2);
        System.out.println("Вещественное значение: " + fraction2.getDecimalValue());

        Fraction fraction3 = new Fraction(1, -2);
        System.out.println("Дробь 3: " + fraction3);
        System.out.println("Вещественное значение: " + fraction3.getDecimalValue());

        // Изменение значений
        fraction1.setNumerator(5);
        System.out.println("После изменения числителя: " + fraction1);
        System.out.println("Вещественное значение (пересчитано): " + fraction1.getDecimalValue());

        // Сравнение дробей
        Fraction fraction4 = new Fraction(3, 4);
        System.out.println("Дробь 1 и Дробь 4 равны: " + fraction1.equals(fraction4));
    }

    private static void demonstrateCats() {
        System.out.println("\n=== ЗАДАНИЕ 2.1: Кот и мяуканье ===");

        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Мурка");

        System.out.println("Созданы коты: " + cat1 + ", " + cat2);

        List<Meowable> cats = Arrays.asList(cat1, cat2);

        System.out.println("Вызываем мяуканье:");
        CatProcessor.makeCatsMeow(cats);
        CatProcessor.makeCatsMeow(cats);

        System.out.println("Количество мяуканий:");
        System.out.println(cat1.getName() + ": " + cat1.getMeowCount() + " раз");
        System.out.println(cat2.getName() + ": " + cat2.getMeowCount() + " раз");
    }

    private static void demonstrateListMerger() {
        System.out.println("\n=== ЗАДАНИЕ 3.3: Упорядоченные списки ===");

        List<Integer> L1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> L2 = Arrays.asList(2, 4, 6, 8);

        System.out.println("Список L1: " + L1);
        System.out.println("Список L2: " + L2);

        List<Integer> merged = ListMerger.mergeSortedLists(L1, L2);
        System.out.println("Объединенный список: " + merged);

        // Пример со строками
        List<String> stringsL1 = Arrays.asList("apple", "cherry");
        List<String> stringsL2 = Arrays.asList("banana", "date");

        System.out.println("Строковый список L1: " + stringsL1);
        System.out.println("Строковый список L2: " + stringsL2);

        List<String> stringsMerged = ListMerger.mergeSortedLists(stringsL1, stringsL2);
        System.out.println("Объединенный строковый список: " + stringsMerged);
    }
}