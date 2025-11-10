import java.util.List;

public class CatProcessor {
    public static void makeCatsMeow(List<Meowable> cats) {
        for (Meowable cat : cats) {
            cat.meow();
        }
    }
}