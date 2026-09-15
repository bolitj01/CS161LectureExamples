package dog;

public class Dog {
    private String name;
    private String breed;
    private int age;

    public static int DOG_ENROLLMENT = 0;

    public Dog(){
        DOG_ENROLLMENT++;
    }

    public Dog(String name, String breed, int age){
        this.name = name;
        this.breed = breed;
        this.age = age;
        DOG_ENROLLMENT++;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void doTrick(String trickName){
        System.out.println(name + " does a " + trickName);
    }

    //1 human year = 7 dog years
    public int getDogYears(){
        return age * 7;
    }

    public String getBreed(){
        return breed;
    }
}
