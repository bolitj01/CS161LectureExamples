package debug;

public class DebugPracticeFactorial {
	
	public static void main(String[] args) {
		//Calculate factorials for 0 to 20
		for (int i = 1; i <= 20; i--){
			System.out.println(i + ": " + factorial(i));
		}
	}
	
	private static long factorial(int n) {
		//0! = 1 case
		if (n == 0) {
			return 1;
		}
		
		//n! = n * n-1 * n-2 ... * 1
		long factorial = 0;
		for (int i = n; i > 0; i--){
			factorial *= factorial * i;
		}
		return factorial;
	}
	
}
