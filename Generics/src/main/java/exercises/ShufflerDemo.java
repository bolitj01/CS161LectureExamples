package exercises;

public class ShufflerDemo {
    public static void main(String[] args) {
        Shuffler<String> shuffler = new Shuffler<String>();
        shuffler.addElement("apple");
        shuffler.addElement("banana");
        shuffler.addElement("cherry");
        shuffler.addElement("date");

        System.out.println("Original items: " + shuffler);
        System.out.println("Removed banana: " + shuffler.removeElement("banana"));
        System.out.println("Before shuffle: " + shuffler);

        shuffler.shuffle();
        System.out.println("After shuffle: " + shuffler);
    }
}
