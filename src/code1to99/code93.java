package code1to99;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 
 * 示例:
 * 
 * 输入: "25525511135" 输出: ["255.255.11.135", "255.255.111.35"]
 * 
 */

public class code93 {
	public List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<String>();
		int length = s.length() - 1;
	}

	public List<String> ipStr(List<String> list, String s) {
		String common = "";
		String str = "";
		for (int i = 0; i < s.length() - 1; i++) {
			String sstr = String.valueOf(s.charAt(i));
			str += sstr;
		}
	}
}
