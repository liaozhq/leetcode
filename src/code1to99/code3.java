package code1to99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code3 {
	public int lengthOfLongestSubstring(String s) {
		char[] chars = s.toCharArray();
		List<List<String>> lists = new ArrayList<List<String>>();
		for (int i = 0; i < chars.length; i++) {
			List<String> list = new ArrayList<String>();
			for (char c : Arrays.copyOfRange(chars, i, chars.length)) {
				if (!list.contains(String.valueOf(c))) {
					list.add(String.valueOf(c));
				} else {
					break;
				}
			}
			lists.add(list);
		}
		int max = 0;
		for (List list : lists) {
			if (list.size() > max) {
				max = list.size();
			}
		}
		return max;
	}
}
