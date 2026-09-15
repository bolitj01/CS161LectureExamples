package aggregation;

public class Instructor {

    private String name;
    private String officeNumber;

    public Instructor(String name, String officeNumber) {
        this.name = name;
        this.officeNumber = officeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public String toString() {
        return "Instructor: " + name + ", Office: " + officeNumber;
    }
}
