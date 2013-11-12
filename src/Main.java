import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args){
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.add(5);
		tree.add(2);
		tree.add(11);
		tree.add(3);
		tree.add(10);
		tree.add(11);
		tree.add(-2);
		tree.add(0);
		
		System.out.println("The tree depth is: " + tree.depth());
		System.out.println("The num leafs is: " + tree.numLeafs());
		System.out.println("The tree depth is: " + tree.depth());
		
		ArrayList<Object> orderedList = tree.inOrderTraversal();
		System.out.println("Ordered list: " + orderedList.toString());
		
		

		
		
	}
}
