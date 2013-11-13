
public class Main {
	
	public static void main(String[] args){
		
		RedBlackTree tree = new RedBlackTree();
		tree.add(10);
		tree.add(12);
		tree.add(5);
		tree.add(2);
		tree.add(6);
		
		tree.printTreePreOrder();
		
		tree.rotateRightTest();
		System.out.println("-----Rotated------");
		
		tree.printTreePreOrder();
		
	}
}
