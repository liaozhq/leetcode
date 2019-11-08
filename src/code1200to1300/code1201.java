package code1200to1300;

/**
 * 请你帮忙设计一个程序，用来找出第 n 个丑数。 丑数是可以被 a 或 b 或 c 整除的 正整数。
 */
public class code1201 {

	public static void main(String[] args) {
		System.out.println(nthUglyNumber(1000000000, 2, 217983653, 336916467));
	}

		public static int nthUglyNumber(int n, int a, int b, int c) {
			int tmp = 0;
			if (b < a) {
				tmp = b;
				b = a;
				a = tmp;
			}
			
			if (c < b) {
				tmp = c;
				c = b;
				c = tmp;
			}
			
			int cnt = 0;
			for(int i = 1; cnt != n ; i++) {
				if(i % a == 0 || i % b == 0 || i % c == 0) {
					cnt++;
					if(cnt == n) {
						return i;
					}
				}
			}
			return 1;
		}
}
