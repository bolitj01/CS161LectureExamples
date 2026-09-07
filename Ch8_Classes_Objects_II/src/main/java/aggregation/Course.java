package aggregation;

public class Course {

    private String courseName;
    private Instructor instructor;
    private TextBook textBook;

    public Course(String name, Instructor instr, TextBook text) {
        this.courseName = name;
        this.instructor = instr;
        this.textBook = text;
    }

    public String getName() {
        return courseName;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public TextBook getTextBook() {
        return textBook;
    }

    public String toString() {
        return "Course: " + courseName + "\n" + instructor + "\n" + textBook;
    }
}
