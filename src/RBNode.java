
public class RBNode implements Comparable {

	private Object data;
	public RBNode left;
	public RBNode right;
	private String color;
	private String side;
	private RBNode parent;
	
	public RBNode(Object data, RBNode parent, RBNode left, RBNode right, String color, String side) {
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
	
	public void printNodes() {
	    if(this.left != null) {
	        this.left.printNodes();
	    }
	    
	    System.out.println(this.data);
	    
	    if(this.right != null) {
	        this.right.printNodes();
	    }
	}
	
    public void rotateRight() {
        
        RBNode oldParent = this.parent;
        RBNode oldRight = this.right;
        RBNode oldParentParent = oldParent.parent;
        
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
