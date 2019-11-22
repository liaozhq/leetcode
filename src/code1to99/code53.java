package code1to99;

/**
 * 输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class code53 {

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}

	/**
	 * 动态规划解法
	 * 时间复杂度: O(n)
	 */
	public static int maxSubArray(int[] nums) {
		int max = nums[0];
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i] = i > 0 ? Math.max(dp[i - 1] + nums[i], nums[i]) : nums[i];
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		return max;
	}
}
