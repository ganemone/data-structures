import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args){
		
		RedBlackTree tree = new RedBlackTree();
		tree.add(10);
		tree.add(12);
		tree.add(5);
		tree.add(2);
		tree.add(6);
		
		System.out.println("The tree depth is: " + tree.depth());
		System.out.println("The num leafs is: " + tree.numLeafs());
		System.out.println("The tree depth is: " + tree.depth());
		
		ArrayList<Object> orderedList = tree.inOrderTraversal();
		System.out.println("Ordered list: " + orderedList.toString());
		
		tree.left.rotateRight();
		System.out.println(tree.inOrderTraversal().toString());
		
	}
}
