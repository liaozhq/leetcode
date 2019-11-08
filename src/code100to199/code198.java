package code100to199;

/**
 * dp 方程 dp[i] = max(dp[i-2]+nums[i], dp[i-1])
 */
public class code198 {
	public static void main(String[] args) {
		int[] nums = new int[] { 2,1};
		System.out.println(rob(nums));
	}

	public static int rob(int[] nums) {
		int dp[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		if (nums.length >= 1) {
			return dp[nums.length - 1];
		} else {
			return 0;
		}

	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

}
