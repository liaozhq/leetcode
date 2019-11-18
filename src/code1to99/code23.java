package code1to99;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * */
public class code23 {
	public ListNode mergeKLists(ListNode[] lists) {
		List<Integer> list = new ArrayList<Integer>();
		for (ListNode l1 : lists) {
			while (l1 != null) {
				list.add(l1.val);
				l1 = l1.next;
			}
		}
		ListNode node = null;
		Collections.sort(list);
		if (list.size() <= 0) {
			return node;
		}
		ListNode root = new ListNode(list.get(0));
		ListNode tmproot = root;
		for (int i = 1; i < list.size(); i++) {
			tmproot.next = new ListNode(list.get(i));
			tmproot = tmproot.next;
		}
		return root;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
