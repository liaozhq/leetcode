package code1to99;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class code21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		List<Integer> list = new ArrayList<Integer>();
		while(l1 != null) {
			list.add(l1.val);
			l1 = l1.next;
		}
		
		while(l2 != null) {
			list.add(l2.val);
			l2 = l2.next;
		}
		
		Collections.sort(list);
		if(list.size() <= 0) {
			return l1;
		}
		ListNode root = new ListNode(list.get(0));
		ListNode tmproot = root;
		for(int i = 1; i < list.size() ; i++) {
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
