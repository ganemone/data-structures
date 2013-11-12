
public class RBNode implements Comparable {

	private Object data;
	public RBNode left;
	public RBNode right;
	private String color;
	private String side;
	
	public RBNode(Object data, RBNode left, RBNode right, String color, String side) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.color = color;
		this.side = side;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(Object data) {
		return ((Comparable<Object>)this.data).compareTo(data);
	}
	
	public boolean isLeftChild() {
		return (this.side == RedBlackTree.SIDE_LEFT);
	}
	
	public boolean isRightChild() {
		return (this.side == RedBlackTree.SIDE_RIGHT);
	}
	
	public boolean isRed() {
		return (this.color == RedBlackTree.COLOR_RED);
	}
	
	public boolean isBlack() {
		return (this.color == RedBlackTree.COLOR_BLACK);
	}
	
	public boolean isLeaf() {
		return (this.data != null && this.left == null && this.right == null);
	}
	
	public boolean isEmpty() {
		return (this.data == null);
	}
	
}
