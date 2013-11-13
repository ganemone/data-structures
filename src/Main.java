
public class Main {
	
	public static void main(String[] args){
		
		RedBlackTree tree = new RedBlackTree();
		tree.add(10);
		tree.add(12);
		tree.add(15);
		tree.add(11);
		tree.add(2);
		
		tree.printTreePreOrder();
		
		tree.root = tree.rotateLeft(tree.root);
		
		System.out.println("-----Rotated------");
		
		tree.printTreePreOrder();
		
	}
}
