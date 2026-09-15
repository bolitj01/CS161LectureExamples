package dog;

import java.util.ArrayList;

public class DogTest {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        Dog ellieDog = new Dog("Niko", "Schnauzer", 8);
        dogs.add(ellieDog);
        dogs.add(new Dog("Bindi", "Sheltie", 4));
        dogs.add(new Dog("Hunter", "Boxer", 10));

        System.out.println("Dogs enrolled: " + Dog.DOG_ENROLLMENT);


        Dog oldestDog = null;

        for (Dog d: dogs){
            d.doTrick("Sit");
            d.doTrick("Speak");

            System.out.println("Age in dog years: " + d.getDogYears());

            if (oldestDog == null || d.getAge() > oldestDog.getAge()){
                oldestDog = d;
            }
        }

        System.out.println("Oldest dog: " + oldestDog.getName());
    }
}
