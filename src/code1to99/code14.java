package code1to99;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"] 输出: "fl" 示例 2:
 * 
 * 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。
 * 
 */
public class code14 {
	
	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] {"a"}) );
	}
	
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length <= 0) {
			return "";
		}
		String maxstr = "";
		int maxlength = 0;
		String str = strs[0];

		for (int i = 0; i <= str.toCharArray().length; i++) {
			String commstr = String.valueOf(Arrays.copyOfRange(str.toCharArray(), 0, i));
			boolean flag = compara(strs, commstr);
			if (flag == true) {
				if(commstr.toCharArray().length > maxlength) {
					maxstr = commstr;
				}
			}
		}
		
		return maxstr;
	}

	public static boolean compara(String[] strs, String commstr) {
		boolean visit = true;
		for (String str : strs) {
			if (!str.startsWith(commstr)) {
				visit = false;
			}
		}
		return visit;
	}
}
