package code1to99;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 */

/**
 * 解题目思维和算法描述:一个括号必须要有"(", 才能有")", 用一个stack来表示是否有"(", 如果stack为空则没有"(", 算法描述:
 */
public class code22 {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}

	public static List<String> generateParenthesis(int n) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("(", ")");
		Stack<String> stack = new Stack<String>();
		return mergestr("", n, stack, map);
	}

	/**
	 * @param str
	 *        n 有多少对()
	 *        map ()的键值对
	 * 一个括号必须要有"(", 才能有")",而且有(，必须要有),stack就可以表示前面有多少个(, 所以有两个回溯算法即可解决,
	 * 第一个回溯前面继续+一个括号, n-1(n就少一个)
	 * 第二个回溯弹出stack(如果stack不为空就弹出),合并一个括号
	 */
	public static List<String> mergestr(String str, int n, Stack<String> stack, HashMap<String, String> map) {
		List<String> list = new ArrayList<String>();
		if (n > 0) {
			Stack<String> stack2 = new Stack<String>();
			for (String s : stack) { // 拷贝一个stack
				stack2.add(s);
			}
			stack2.push("(");
			List<String> backlist = mergestr(str + "(", n - 1, stack2, map); // 递归+回溯,第一个回溯前面继续+一个括号, n-1(n就少一个)
			list.addAll(backlist);
			if (!stack.isEmpty()) {
				String pop = stack.pop();
				List<String> backlist2 = mergestr(str + map.get(pop), n, stack, map); // 递归+回溯,第二个回溯弹出stack(如果stack不为空就弹出),合并一个括号
				list.addAll(backlist2);
			}
		} else {  //如果n 小于等于0,就表示前面的(已经加完
			while (!stack.isEmpty()) {  //弹出stack全部，合并括号
				str += map.get(stack.pop());
			}
			list.add(str);
		}
		return list;
	}
}
