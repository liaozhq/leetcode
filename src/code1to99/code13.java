package code1to99;

import java.util.HashMap;
import java.util.Map;

public class code13 {

	public static void main(String[] args) {
		System.out.println(romanToInt("IV"));
	}

	public static int romanToInt(String s) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
		map.put("IV", 4);
		map.put("IX", 9);
		map.put("XL", 40);
		map.put("XC", 90);
		map.put("CD", 400);
		map.put("CM", 900);
		int sum = 0;

		for (int i = s.length() - 1; i >= 0;) {
			if (i > 0) {
				String str = String.valueOf(s.charAt(i - 1))+String.valueOf(s.charAt(i));
				Integer value = map.get(str);
				if (value != null) {
					sum += value;
					i -= 2;
					continue;
				} else {
					str = String.valueOf(s.charAt(i));
					value = map.get(str);
					if (value != null) {
						sum += value;
						i--;
					}
				}
			} else {
				String str = String.valueOf(s.charAt(i));
				Integer value = map.get(str);
				if (value != null) {
					sum += value;
					i--;
				}
			}
		}

		return sum;
	}
}
