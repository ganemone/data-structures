import java.util.ArrayList;


public class BinaryTree {

	public final static String SIDE_LEFT = "left";
	public final static String SIDE_RIGHT = "right";
	
	protected Object data;
	protected BinaryTree left;
	protected BinaryTree right;
	protected BinaryTree parent;
	protected String side;
	
	public BinaryTree(BinaryTree parent, String side) {
		this.data = null;
		this.left = null;
		this.right = null;
		this.parent = parent;
		this.side = side;
	}
	
	public BinaryTree getLeftTree() { return this.left; }
	public BinaryTree getRightTree() { return this.right; }
	public Object getData() { return this.data; }
	
	public void add(Object data) {
		if(this.isEmpty()) {
			this.data = data;
			this.left = new BinaryTree(this, BinaryTree.SIDE_LEFT);
			this.right = new BinaryTree(this, BinaryTree.SIDE_RIGHT);
		}
		else if(this.left.depth() <= this.right.depth()) {
			this.left.add(data);	
		}
		else {
			this.right.add(data);
		}
	}
	
	public int depth() {
		if(this.isEmpty()) {
			return 0;
		}
		else {
			return Math.max(1 + this.left.depth(), 1 + this.right.depth());
		}
	}
	
	public boolean isLeaf() {
		return (!this.isEmpty() && this.left.isEmpty() && this.right.isEmpty()) ? true : false;
	}
	
	public boolean isEmpty() {
		return (this.data == null) ? true : false;
	}
	
	public int numLeafs() {
		if(this.isEmpty()) {
			return 0;
		}
		else if(this.isLeaf()) {
			return 1;
		}
		else if(this.left != null && this.right != null) {
			return this.left.numLeafs() + this.right.numLeafs();
		}
		else if(this.left == null) {
			return this.right.numLeafs();
		}
		else {
			return this.left.numLeafs();
		}
	}
	
	public ArrayList<Object> preOrderTraversal() {
		ArrayList<Object> list = new ArrayList<Object>();
		if(this.isEmpty()) {
			return list;
		}
		else {
			list.add(this.data);
			list.addAll(this.left.preOrderTraversal());
			list.addAll(this.right.preOrderTraversal());
		}
		
		return list;
	}
	
	public ArrayList<Object> inOrderTraversal() {
		ArrayList<Object> list = new ArrayList<Object>();
		if(this.isEmpty()) {
			return list;
		}
		else {
			if(this.parent != null) {
				System.out.println("Item: " + this.data);
				System.out.println("Parent: " + this.parent.data);
				System.out.println("Side: " + this.side);
			} else {
				System.out.println("Root: " + this.data);
			}
			list.addAll(this.left.inOrderTraversal());
			list.add(this.data);
			list.addAll(this.right.inOrderTraversal());
		}
		return list;
	}
	
	public ArrayList<Object> postOrderTraversal() {
		ArrayList<Object> list = new ArrayList<Object>();
		if(this.isEmpty()) {
			return list;
		}
		else {
			list.addAll(this.left.postOrderTraversal());
			list.addAll(this.right.postOrderTraversal());
			list.add(this.data);
		}
		return list;
	}
	
	public ArrayList<Object> breadthFirstTraversal() {
		ArrayList<Object> list = new ArrayList<Object>();
		
		return list;
	}
	
	public BinaryTree getParent() {
		return this.parent;
	}
	
	public void rotateRight() {
		
		BinaryTree oldParent = this.parent;
		BinaryTree oldRight = this.right;
		BinaryTree oldParentParent = oldParent.parent;
		
		this.right = oldParent;
		this.parent = oldParentParent;
		this.side = oldParent.side;
		
		if(this.parent != null) {
			if(this.side == BinaryTree.SIDE_LEFT) {
				this.parent.left = this;
			}
			else if(this.side == BinaryTree.SIDE_RIGHT) {
				this.parent.right = this;
			}
		}
		
		oldParent.left = oldRight;
		oldParent.parent = this;
		oldParent.side = BinaryTree.SIDE_RIGHT;
		oldParent.left.side = BinaryTree.SIDE_LEFT;
		
	}
	
	public void rotateLeft() {
		
	}
	
}
