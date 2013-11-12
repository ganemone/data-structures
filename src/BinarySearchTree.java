
public class BinarySearchTree extends BinaryTree {

	public BinarySearchTree() {
		super(null);
	}
	
	@Override
	public void add(Object data) {
		if(this.isEmpty()) {
			this.data = data;
			this.left = new BinarySearchTree();
			this.right = new BinarySearchTree();
		}
		else if(((Comparable<Object>) this.data).compareTo(data) < 0) {
			this.left.add(data);
		}
		else {
			this.right.add(data);
		}
	}
	
}
