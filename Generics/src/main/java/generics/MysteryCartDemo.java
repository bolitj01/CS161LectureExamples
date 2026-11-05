package generics;

public class MysteryCartDemo {
	public static void main(String[] args) {
		MysteryCart<String> cart = new MysteryCart<String>(5);
		cart.addItem("apple");
		cart.addItem("banana");
		cart.addItem("carrot");
		cart.addItem("date");
		cart.addItem("eggplant");
		
		System.out.println("Get: " + cart.getItem("banana"));
		System.out.println("Get: " + cart.getItem("grape"));
		System.out.println("Remove: " + cart.removeItem("date"));
		System.out.println("Remove: " + cart.removeItem("carrot"));
		cart.addItem("peaches");
		System.out.println(cart);

		PassengerCart<String, Baby> babyCart = new PassengerCart<String, Baby>(5, new Baby("Alice", 2));
		babyCart.addItem("Chocolate Milk");
		System.out.println(babyCart);
	}
}
