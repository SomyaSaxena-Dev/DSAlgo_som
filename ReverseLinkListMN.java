import LinkedList.Node;

public class ReverseLinkListMN {
	/*
	 * static private boolean stop=false; static private LinkedList.Node left;
	 * static private LinkedList.Node right; public static void
	 * recurseRecursive(LinkedList.Node left,LinkedList.Node right, int m, int n) {
	 * 
	 * if(n==1) return; right=right.next;
	 * 
	 * if(m>1) left=left.next; recurseRecursive(left,right, m - 1, n - 1);
	 * if(left==right || right.next==left) stop=true;
	 * 
	 * if(!stop) { String temp = left.nodeName; left.nodeName=right.nodeName;
	 * right.nodeName=temp; left=left.next; } } public static void
	 * reverse(LinkedList.Node head, int m,int n) { left=head; right=head;
	 * stop=false; recurseRecursive(left,right,m,n); }
	 */

	// LEETCODE
	static private boolean stop;
	static private LinkedList.Node left;

	public static  void recurseAndReverse(LinkedList.Node right, int m, int n) {

		// base case. Don't proceed any further
		if (n == 1) {
			return;
		}

		// Keep moving the right pointer one step forward until (n == 1)
		right = right.next;

		// Keep moving left pointer to the right until we reach the proper node
		// from where the reversal is to start.
		if (m > 1) {
			left = left.next;
		}

		// Recurse with m and n reduced.
		recurseAndReverse(right, m - 1, n - 1);

		// In case both the pointers cross each other or become equal, we
		// stop i.e. don't swap data any further. We are done reversing at this
		// point.
		if (left == right || right.next == left) {
			stop = true;
		}

		// Until the boolean stop is false, swap data between the two pointers
		if (!stop) {
			String t = left.nodeName;
			left.nodeName = right.nodeName;
			right.nodeName = t;

			// Move left one step to the right.
			// The right pointer moves one step back via backtracking.
			left = left.next;
		}
	}

	public static void reverseBetween(LinkedList.Node head, int m, int n) {
		left = head;
		stop = false;
		recurseAndReverse(head, m, n);
	}

	public static void main(String args[]) {
		LinkedList ll = new LinkedList();
		LinkedList.Node node1 = ll.new Node("1");
		LinkedList.Node node2 = ll.new Node("2");
		LinkedList.Node node3 = ll.new Node("3");
		LinkedList.Node node4 = ll.new Node("4");
		LinkedList.Node node5 = ll.new Node("5");

		ll.insertFirst(node1);
		ll.insertLast(node2);
		ll.insertLast(node3);
		ll.insertLast(node4);
		ll.insertLast(node5);

		ll.displayList(node1);

		//reverse(node1, 2, 4);
		
		//LEETCODE
		reverseBetween(node1, 2, 4);

		System.out.println("After Reverse: ");
		ll.displayList(node1);
	}
}
