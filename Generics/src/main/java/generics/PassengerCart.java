package generics;

public class PassengerCart <I , H extends Human> extends MysteryCart<I>{

	private H passenger;
	
	public PassengerCart(int size, H passenger) {
		super(size);
		this.passenger = passenger;
	}
	
	public H getPassenger() {
		return passenger;
	}
	
	public void setPassenger(H passenger) {
		this.passenger = passenger;
	}
	
	public int getPassengerAge() {
		return passenger.getAge();
	}

	public String toString() {
		return passenger + " is a passenger\n\n" + super.toString();
	}
}

//Human and Baby demo classes
abstract class Human {
	private String name;
	private int age;
	
	public Human(String name, int age) {
		this.name = name;
        this.age = age;
	}
	
	public String toString() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
}

class Baby extends Human {
	
	public Baby(String name, int age) {
		super(name, age);
	}
	
	
}
