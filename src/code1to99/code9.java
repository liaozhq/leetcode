package code1to99;

public class code9 {
	public boolean isPalindrome(int x) {
		if (x < 0) { // 负数
//			int num = 0 - x;
//			int i = 0;
//			long returnum = 0;
//			while (num > 0) {
//				long n = num % 10;
//				if (!(i == 0 && n == 0)) {
//					if (returnum != 0) {
//						returnum = (returnum * 10) + n;
//					} else {
//						returnum = n;
//					}
//				}
//				num /= 10;
//				i++;
//			}
//
//			if (x == returnum) {
//				return true;
//			} else {
//				return false;
//			}
			return false;
		} else {
			int num = x;
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
				num /= 10;
				i++;
			}

			if (x == returnum) {
				return true;
			} else {
				return false;
			}
		}
	}
}
