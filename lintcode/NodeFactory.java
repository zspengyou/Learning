package lintcode;

public class NodeFactory {

	public ListNode createList(int n) {
		ListNode[] array = new ListNode[n];
		for (int i = 0; i < n; i++) {
			array[i] = new ListNode(i);
		}
		for (int i = 0; i < n - 1; i++) {
			array[i].next = array[i + 1];
		}
		return array[0];
	}

}
