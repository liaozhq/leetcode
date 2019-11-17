package code1to99;

import java.util.ArrayList;
import java.util.List;

public class code26 {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] {1,1,2}));
	}

	public static int removeDuplicates(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		for (int num : nums) {
			if (!list.contains(num)) {
				list.add(num);
			}
		}
		return list.size();
	}
}
