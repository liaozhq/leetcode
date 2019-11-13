package code1to99;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code2 {
	public static void main(String[] args) {
		System.out.println();
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int val = l1.val + l2.val;
		boolean isTen = false;
		if (val >= 10) {
			isTen = true;
		}
		ListNode node = new ListNode(val % 10);
		ListNode tmpnode = node;
		while (l1.next != null || l2.next != null) {
			if (l1.next == null) {
				l1.next = new ListNode(0);
				l1 = l1.next;
			} else {
				l1 = l1.next;
			}
			if (l2.next == null) {
				l2.next = new ListNode(0);
				l2 = l2.next;
			} else {
				l2 = l2.next;
			}
			if (isTen) {
				val = l1.val + l2.val + 1;
			} else {
				val = l1.val + l2.val;
			}
			tmpnode.next = new ListNode(val % 10);
			tmpnode = tmpnode.next;
			if (val >= 10) {
				isTen = true;
			} else {
				isTen = false;
			}
		}

		if (isTen && l1.next == null && l2.next == null) {
			tmpnode.next = new ListNode(1);
		}
		return node;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}