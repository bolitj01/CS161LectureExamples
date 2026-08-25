package methods;

public class Params_PBV_PBR {
	
	public static void main(String[] args) {
		//primitive variables
		int first = 1;
		int second = 2;

		System.out.println("Pass by value");

		swapByValue(first, second);

		System.out.println("In main: " + first + ", " + second);
		
		//reference variable
		int[] places = {1, 2};

		System.out.println("\nPass by reference");

		swapByReference(places);

		System.out.println("In main: " + places[0] + ", " + places[1]);
	}
	
	static void swapByValue(int first, int second) {
		int temp = first;
		first = second;
		second = temp;
		
		System.out.println("In method: " + first + ", " + second);
	}
	
	static void swapByReference(int[] places) {
		int temp = places[0];
		places[0] = places[1];
		places[1] = temp;
		
		System.out.println("In method: " + places[0] + ", " + places[1]);
	}
}
