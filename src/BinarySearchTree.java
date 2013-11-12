
public class BinarySearchTree extends BinaryTree {

	public BinarySearchTree(BinarySearchTree parent, String side) {
		super(parent, side);
	}
	
	@Override
	public void add(Object data) {
		if(this.isEmpty()) {
			this.data = data;
			this.left = new BinarySearchTree(this, BinaryTree.SIDE_LEFT);
			this.right = new BinarySearchTree(this, BinaryTree.SIDE_RIGHT);
		}
		else if(((Comparable<Object>) this.data).compareTo(data) > 0) {
			this.left.add(data);
		}
		else {
			this.right.add(data);
		}
	}
	
}
