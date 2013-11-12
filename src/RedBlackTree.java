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
public class RedBlackTree extends BinarySearchTree {

	public final static String COLOR_BLACK = "black";
	public final static String COLOR_RED = "red";

	// Must equal COLOR_BLACK or COLOR_RED
	private String color;
	
	public RedBlackTree() {
		super();
	} 
	
}
