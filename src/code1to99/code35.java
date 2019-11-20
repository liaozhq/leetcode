package code1to99;

public class code35 {

	public int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length;
		int middler = (left + right) / 2;
		while (middler != 0) {
			if (nums[middler] == target) {
				return middler;
			}

			if (nums[middler] > target) {
				
			} else if (nums[middler] < target) {

			}

		}

		return 0;
	}
}
