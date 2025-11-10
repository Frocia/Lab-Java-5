import java.util.*;
import java.util.stream.Collectors;

public class PointProcessor {
    public void processPointsStream() {
        System.out.println("\n=== ЗАДАНИЯ 7.1 и 7.2: Обработка точек и создание ломаной ===");

        List<Point> points = Arrays.asList(
                new Point(1, 2),
                new Point(3, 4),
                new Point(1, 2),
                new Point(5, -6),
                new Point(2, 8),
                new Point(5, -6),
                new Point(0, -3)
        );

        System.out.println("Исходные точки: " + points);

        Polyline polyline = new Polyline(
                points.stream()
                        .distinct()
                        .sorted(Comparator.comparingDouble(Point::getX))
                        .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                        .collect(Collectors.toList())
        );

        System.out.println("Результирующая ломаная: " + polyline);
    }
}