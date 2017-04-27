package lintcode;

public class IntersectionTwoLinkedList {
	static NodeFactory factory = new NodeFactory();

	public static void main(String[] args) {

		ListNode root1 = factory.createList(7);
		ListNode root2 = factory.createList(4);
		ListNode intersection = root1;
		for (int i = 0; i < 7; i++) {
			intersection = intersection.next;
		}
		ListNode list2End = root2;
		while (list2End.next != null)
			list2End = list2End.next;
		list2End.next = intersection;
		ListNode result = getIntersection(root1, root2);
		System.out.println(result);
	}

	public static ListNode getIntersection(ListNode headA, ListNode headB) {
		int length1 = getLength(headA);
		int length2 = getLength(headB);
		while(length1 > length2){
			length1 --;
			headA = headA.next;
		}
		while( length2 > length1){
			length2 --;
			headB = headB.next;
		}
		while (headA != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}

	public static int getLength(ListNode root) {
		int count = 0;
		while (root != null) {
			count++;
			root = root.next;
		}
		return count;
	}

}
