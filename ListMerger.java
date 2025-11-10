import java.util.*;

public class ListMerger {
    public static <T extends Comparable<T>> List<T> mergeSortedLists(List<T> L1, List<T> L2) {
        List<T> result = new ArrayList<>(L1);

        for (T element : L2) {
            // Находим позицию для вставки
            int insertIndex = 0;
            while (insertIndex < result.size() && element.compareTo(result.get(insertIndex)) > 0) {
                insertIndex++;
            }
            result.add(insertIndex, element);
        }

        return result;
    }
}