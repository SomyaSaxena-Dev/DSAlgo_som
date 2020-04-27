public class LinkedList {

	private static Node head;
	public class Node{
		public String nodeName;
		Node next;
		public Node(String nodeName){
			this.nodeName=nodeName;
			
		}
	}
	LinkedList(){
		head=null;
	}
	
	public  void displayList(Node head) {
		while(head!=null) {
		
			System.out.println(head.nodeName+" ");
			head=head.next;
		}
	}
	public static boolean isEmpty() {
		return (head==null);
	}
	
	public void insertFirst(Node node) {
		if (head == null)
			head = node;
		else {
			node.next = head;
			head = node;
		}
	}
	
	public void insertLast(Node node) {
		Node temp = head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=node;
	}
	
	public void deleteFirst() {
		head=head.next;
	}
	
	public void reverseList() {
		
	}
	public static void main(String[] args) {
		LinkedList obj = new LinkedList();
		Node node = obj.new Node("Sangam");
		Node node2 = obj.new Node("loves");
		Node node3 = obj.new Node("Somya");
		Node node4 = obj.new Node("a lot");
		obj.insertFirst(node);
		obj.insertLast(node2);
		obj.insertLast(node3);
		obj.insertLast(node4);
		
		//obj.deleteFirst();
		obj.displayList(node);
		//obj.deleteFirst();
		
		//obj.displayList();
		
		
	}
}
