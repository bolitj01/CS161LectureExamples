package debug_solution;
public class DebugPracticePartnerSum_Solution {
	
	public static void main(String[] args) {
        //Number list and target sum
		int[] numbers = {1, 2, 3, 4, 5, 6};
        int[] targets = {7, 8, 9, 10, 11, 12};

        //Find all pairs for each target (with no repeats)
        for (int target: targets) {
			partnerSum(numbers, target);
		}
    }

    public static void partnerSum(int[] nums, int target) {
        System.out.printf("Possible sums for %d:\n", target);
    	for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                //Check sum of each two numbers
            	if (nums[i] + nums[j] == target) {
                    System.out.printf("%d + %d\n", nums[i], nums[j]);
                }
            }
        }
    }
	
}
