
public class RBNode implements Comparable<Object> {

	public Object data;
	public RBNode left;
	public RBNode right;
	public String color;
	public String side;
	public RBNode parent;
	
	public RBNode(Object data, RBNode parent, RBNode left, RBNode right, String color, String side) {
		this.data = data;
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.color = color;
		this.side = side;
		
	}

	@Override
	public int compareTo(Object data) {
		return ((Comparable<Object>)this.data).compareTo(data);
	}
	
	public void paintBlack() {
	    this.color = RedBlackTree.COLOR_BLACK;
	}
	public void paintRed() {
	    this.color = RedBlackTree.COLOR_RED;
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
	
	public void printNodes() {
	    if(this.left != null) {
	        this.left.printNodes();
	    }
	    
	    System.out.println(this.data);
	    
	    if(this.right != null) {
	        this.right.printNodes();
	    }
	}
	
	public void printPreOrder() {
	    System.out.println(this.data);
	    if(this.left != null) {
            this.left.printPreOrder();
        }
	    if(this.right != null) {
            this.right.printPreOrder();
        }
	}
	
	public RBNode getGrandParent() {
	    return this.parent.parent;
	}
	
	public RBNode getUncle() {
	    return this.parent.getSibling();
	}
	
	public RBNode getSibling() {
	    if(this.side == RedBlackTree.SIDE_LEFT) {
	        return this.parent.right;
	    }
	    else if(this.side == RedBlackTree.SIDE_RIGHT) {
	        return this.parent.left;
	    }
	    return null;
	}
}
