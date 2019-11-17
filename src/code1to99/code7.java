package code1to99;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123 输出: 321  示例 2:
 * 
 * 输入: -123 输出: -321 示例 3:
 * 
 * 输入: 120 输出: 21 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 
 */
public class code7 {
	public static void main(String[] args) {
		System.out.println(reverse(1534236463));
		System.out.println(reverse(-2147483412));
	}

	public static int reverse(int x) {
		if (x == 0) {
			return 0;
		}
		long num = 0;
		if (x < 0) { // 负数
			num = 0 - x; // 转正，负负得正
			int i = 0;
			long returnum = 0;
			while (num > 0) {
				long n = num % 10;
				if (!(i == 0 && n == 0)) {
					if (returnum != 0) {
						returnum = (returnum * 10) + n;
					} else {
						returnum = n;
					}
				}
				if (returnum > Integer.MAX_VALUE)
					return 0; // 考虑溢出问题 数值范围 [-2^31, 2^31 - 1]
				if (returnum < Integer.MIN_VALUE)
					return 0;

				num /= 10;
				i++;
			}

			num = 0 - returnum;
		} else {
			num = x;
			int i = 0;
			long returnum = 0;
			while (num > 0) {
				long n = num % 10;
				if (!(i == 0 && n == 0)) {
					if (returnum != 0) {
						returnum = (returnum * 10) + n;
					} else {
						returnum = n;
					}
				}
				if (returnum > Integer.MAX_VALUE)
					return 0; // 考虑溢出问题 数值范围 [-2^31, 2^31 - 1]
				if (returnum < Integer.MIN_VALUE)
					return 0;
				num /= 10;
				i++;
			}

			num = returnum;
		}
		return (int) num;
	}
}
