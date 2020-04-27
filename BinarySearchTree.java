
public class BinarySearchTree {

	TreeNode root;
	BinarySearchTree(TreeNode root){
		this.root=root;
		root.leftChild=null;
		root.rightChild=null;
		
	}
	
	public int insert(TreeNode node){
		if(root==null) {
			root=node;
			return 1;
		}
		TreeNode parent;
		TreeNode current=root;
		while(true) {
			parent=current;
			if(current.key > node.key) {
				current=current.leftChild;
				if(current==null) {
					parent.leftChild=node;
					return 1;
				}
			}
			else {
				current=current.rightChild;
				if(current==null) {
					parent.rightChild=node;
					return 1;
				}
			}
		}
	}
	
	  public TreeNode find(int key){
	  TreeNode current=root;
	  while(current!=null) {
		  if(key<current.key) {
			  current=current.leftChild;
		  }
		  else if(key>current.key) {
			  current=current.rightChild;
		  }
		  else if(key == current.key) {
			  return current;
			  
		  }
		  
	  }
	  return null;
	  }
	 
	  public int findMin() {
		  TreeNode current=root;
		  TreeNode parent=root;
		  while(current!=null) {
			  parent=current;
			  current=current.leftChild;
		  }
		  
		  return parent.key;
	  }
	  
	  public int findMax() {
		  TreeNode current=root;
		  TreeNode parent=root;
		  while(current!=null) {
			  parent=current;
			  current=current.rightChild;
		  }
		  
		  return parent.key;
	  }
	
	//traversal functions -- inorder, preorder, postorder
	
	public void inorder(TreeNode node) {
		if(node!=null) {
		inorder(node.leftChild);
		System.out.print(node.key+" ");
		inorder(node.rightChild);
		}
	}
	
	public void preorder(TreeNode node) {
		if(node!=null) {
		System.out.print(node.key+ " ");
		preorder(node.leftChild);
		preorder(node.rightChild);
		}
	}
	
	public void postorder(TreeNode node) {
		if(node!=null) {
		postorder(node.leftChild);
		postorder(node.rightChild);
		System.out.print(node.key+" ");
		}
	}
}
