public class BSTRunner {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(80);
		TreeNode node2 = new TreeNode(10);
		TreeNode node3 = new TreeNode(90);
		TreeNode node4 = new TreeNode(5);
		BinarySearchTree bst = new BinarySearchTree(node1);
		bst.insert(node2);
		bst.insert(node3);
		bst.insert(node4);
		System.out.println("Inorder");
		bst.inorder(node1);
		System.out.println("PreOrder");
		bst.preorder(node1);
		System.out.println("PostOrder");
		bst.postorder(node1);
		
		
		TreeNode node = bst.find(5);
		System.out.println("max val " + bst.findMax());
		System.out.println("min val " +bst.findMin());
		if(node!=null)
		System.out.println("Data found");
	}
}
