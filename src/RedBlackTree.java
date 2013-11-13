/* 
 * Properties: 
 *  1. A node is either red or black.
 *  2. The root is black. (This rule is sometimes omitted)
 *  3. All leaves (NIL) are black. (All leaves are same color as the root.)
 *  4. Every red node must have two black child nodes.
 *  	- Threatened When...
 *  		- Adding a Red Node
 *  		- Rotating
 *  		- Repainting Black node Red
 *  5. Every path from a given node to any of its descendant leaves contains the same number of black nodes.
 *  	- Threatened When...
 *  		- Adding a Black Node
 *  		- Repainting a Red Node Black
 *  		- Repainting a Black Node Red
 *  		- Rotation
 *  
 * Rules for Insertion (Node A): 
 *  - Insert (Node A) following the BinarySearch method
 *  - Color (Node A) red, give item two null children (leaves) colored black
 *  - Check for property 4 : "Every red node must have two black child nodes"
 *  	- Broken if (Node A) has red parent
 *  
 *  Solving insertion issues 
 *  - Case 1: Current Node is at Root
 *  	- Repaint Black
 *  - Case 2: Current Node has Black Parent
 *  	- Do Nothing
 *  - Case 3: Parent && Uncle are Red
 *  	- Paint Grandparent Red
 *  	- Paint Parent + Uncle Black
 *  	- Set Grandparent = Current -> Recursively Call
 *  - Case 4: 
 *  Parent  = Red
 *  Uncle   = Black
 *  Current = Right Child
 *  Parent  = Left Child
 *  	- Left Rotation on parent P
 *  	- Use Case 5 on former parent P
 *  			
 *  - Case 5:
 *  Parent = Red
 *  Uncle = Black
 *  Current = Left Child
 *  Parent = Left Child
 *  	- Right Rotation on Grandparent
 *  	- Parent = Black
 *  	- Grandparent = Red
 *  	
 *  Right Rotation
 *  	- Parent Right = Grandparent
 *  	- Grandparent Left = Parent Old Right
 *  Left Rotation
 *  	- Parent Left = Grandparent
 *  	- Grandparent Right = Parent Old Left
 *  
 *    
 *  
 *  
 *   
 */
public class RedBlackTree {

    public final static String COLOR_BLACK = "black";
    public final static String COLOR_RED = "red";

    public final static String SIDE_LEFT = "left";
    public final static String SIDE_RIGHT = "right";

    public RBNode root;

    public void add(Object data) {
        if (this.isEmpty()) {
            this.root = new RBNode(data, null, null, null, COLOR_BLACK, null);
        } else {
            RBNode node = root;
            boolean finished = false;
            while (!finished) {
                if (node.compareTo(data) > 0) {
                    if (node.left == null) {
                        node.left = new RBNode(data, node, null, null, COLOR_RED, SIDE_LEFT);
                        finished = true;
                    } else {
                        node = node.left;
                    }
                } else {
                    if (node.right == null) {
                        node.right = new RBNode(data, node, null, null, COLOR_RED, SIDE_RIGHT);
                        finished = true;
                    } else {
                        node = node.right;
                    }
                }
            }
        }
    }

    private void checkInsertCases(RBNode current) {
        boolean finished = false;
        while (!finished) {
            if (this.checkInsertCaseOne(current)) {
                current.paintBlack();
                finished = true;
            } else if (this.checkInsertCaseTwo(current)) {
                finished = true;
            } else if (this.checkInsertCaseThree(current)) {
                current.parent.paintBlack();
                current.getUncle().paintBlack();
                current = current.getGrandParent();
            } else if (this.checkInsertCaseFour(current)) {

            } else if (this.checkInsertCaseFive(current)) {

            }
        }
    }

    private boolean checkInsertCaseOne(RBNode current) {
        return (this.root == current);
    }

    private boolean checkInsertCaseTwo(RBNode current) {
        return current.parent.isBlack();
    }

    private boolean checkInsertCaseThree(RBNode current) {
        return (current.parent.isRed() && current.getUncle().isRed());
    }

    private boolean checkInsertCaseFour(RBNode current) {
        return (current.parent.isRed() && current.getUncle().isBlack() && current.isRightChild() && current.parent.isLeftChild());
    }

    private boolean checkInsertCaseFive(RBNode current) {
        return (current.parent.isRed() && current.getUncle().isBlack() && current.isLeftChild() && current.parent.isLeftChild());
    }

    private boolean isEmpty() {
        return (this.root == null);
    }

    public void printTree() {
        this.root.printNodes();
    }

    public RBNode rotateRight(RBNode current) {
        RBNode leftChild = current.left;
        current.left = leftChild.right;

        leftChild.right = current;
        leftChild.side = current.side;
        leftChild.parent = current.parent;

        current.parent = leftChild;
        current.side = SIDE_RIGHT;

        return leftChild;
    }

    public RBNode rotateLeft(RBNode current) {
        RBNode rightChild = current.right;
        current.right = rightChild.left;

        rightChild.left = current;
        rightChild.side = current.side;
        rightChild.parent = current.parent;

        current.parent = rightChild;
        current.side = SIDE_LEFT;

        return rightChild;
    }

    public void printTreePreOrder() {
        this.root.printPreOrder();
    }

}
