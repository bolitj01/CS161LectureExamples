package exercises;

import java.util.ArrayList;
import java.util.Random;

public class Shuffler_Solution<T> {
    private final ArrayList<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public boolean removeItem(T item) {
        return items.remove(item);
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = items.size() - 1; i > 0; i--) {
            int randomIndex = random.nextInt(i + 1);
            T item = items.get(i);
            items.set(i, items.get(randomIndex));
            items.set(randomIndex, item);
        }
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
