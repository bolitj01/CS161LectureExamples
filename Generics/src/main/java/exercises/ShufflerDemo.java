package exercises;

public class ShufflerDemo {
    public static void main(String[] args) {
        Shuffler_Solution<String> shuffler = new Shuffler_Solution<>();
        shuffler.addItem("apple");
        shuffler.addItem("banana");
        shuffler.addItem("cherry");
        shuffler.addItem("date");

        System.out.println("Original items: " + shuffler);
        System.out.println("Removed banana: " + shuffler.removeItem("banana"));
        System.out.println("Before shuffle: " + shuffler);

        shuffler.shuffle();
        System.out.println("After shuffle: " + shuffler);
    }
}
