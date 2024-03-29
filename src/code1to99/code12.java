package code1to99;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 
 * 字符 数值 I 1 V 5 X 10 L 50 C 100 D 500 M 1000 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12
 * 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
 * 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * 
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 X 可以放在 L (50) 和 C (100) 的左边，来表示 40
 * 和 90。  C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 给定一个整数，将其转为罗马数字。输入确保在 1 到
 * 3999 的范围内。
 * 
 * 示例 1:
 * 
 * 输入: 3 输出: "III" 示例 2:
 * 
 * 输入: 4 输出: "IV" 示例 3:
 * 
 * 输入: 9 输出: "IX" 示例 4:
 * 
 * 输入: 58 输出: "LVIII" 解释: L = 50, V = 5, III = 3. 示例 5:
 * 
 * 输入: 1994 输出: "MCMXCIV" 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * 
 */
public class code12 {

	public static void main(String[] args) {
		System.out.println(intToRoman(200));
	}

	/**
	 * 解体思路:暴力破解法
	 */
	public static String intToRoman(int num) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "I");
		map.put(5, "V");
		map.put(10, "X");
		map.put(50, "L");
		map.put(100, "C");
		map.put(500, "D");
		map.put(1000, "M");
		map.put(4, "IV");
		map.put(9, "IX");
		map.put(40, "XL");
		map.put(90, "XC");
		map.put(400, "CD");
		map.put(900, "CM");

		Stack<String> stack = new Stack<String>();
		String romastr = "";
		int bit = 1;  //表示是多少位的个位是1,十位是10,百位是100
		while (num != 0) {   //依次把数字提取出来
			int bitnum = num % 10;
			bitnum *= bit;
			bit *= 10;
			num /= 10;
			if (bitnum != 0) { //从个位开始将数字转换为罗马字符,然后push到stack中
				stack.push(getIntByStr(map, bitnum));
			}
		}

		while (!stack.isEmpty()) { //拼接罗马字符
			romastr += stack.pop();
		}

		return romastr;
	}

	/**
	 * description:该方法将每位的正整数数字转换位罗马字符,如:10,100,500,600
	 * 
	 */
	public static String getIntByStr(Map<Integer, String> map, int bitnum) {
		String romastr = "";
		String value = map.get(bitnum);
		if (value != null) {
			return value;
		}

		int min = 0;
		int keynumber = 0;
		for (Integer key : map.keySet()) {
			if (key < bitnum && !String.valueOf(key).startsWith("4") && !String.valueOf(key).startsWith("9")) {
				int keynum = bitnum - key;
				if (keynum < min || min == 0) {
					min = keynum;
					keynumber = key;
				}
			}
		}

		if (String.valueOf(keynumber).startsWith("5")) {
			romastr += map.get(keynumber);
			bitnum -= keynumber;

			for (Integer key : map.keySet()) {
				if (key <= bitnum && !String.valueOf(key).startsWith("4") && !String.valueOf(key).startsWith("9")) {
					int keynum = bitnum - key;
					if (keynum < min) {
						min = keynum;
						keynumber = key;
					}
				}
			}

			int n = bitnum / keynumber;
			for (int i = 0; i < n; i++) {
				romastr += map.get(keynumber);
			}

		} else {
			int n = bitnum / keynumber;
			for (int i = 0; i < n; i++) {
				romastr += map.get(keynumber);
			}
		}
		return romastr;
	}
}
