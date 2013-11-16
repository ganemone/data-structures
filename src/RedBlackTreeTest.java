import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class RedBlackTreeTest {

    @Test
    public void testGetNodesPreOrder() {
        RedBlackTree tree = new RedBlackTree();
        tree.add(10);
        tree.add(12);
        tree.add(15);
        tree.add(11);
        tree.add(2);

        ArrayList<RBNode> nodesPreOrder = tree.getNodesPreOrder(new ArrayList<RBNode>(), tree.root);
        int[] arr = new int[5];
        for (int i = 0; i < nodesPreOrder.size(); i++) {
            arr[i] = (Integer) nodesPreOrder.get(i).data;
        }

        assertArrayEquals(new int[] { 10, 2, 12, 11, 15 }, arr);

    }

    @Test
    public void testRotateRight() {
        RedBlackTree tree = new RedBlackTree();
        tree.add(12);
        tree.add(15);
        tree.add(10);
        tree.add(11);
        tree.add(2);

        tree.root = tree.rotateRight(tree.root);

        ArrayList<RBNode> nodesPreOrder = tree.getNodesPreOrder(new ArrayList<RBNode>(), tree.root);
        int[] arr = new int[5];
        for (int i = 0; i < nodesPreOrder.size(); i++) {
            arr[i] = (Integer) nodesPreOrder.get(i).data;
        }

        assertArrayEquals(new int[] { 10, 2, 12, 11, 15 }, arr);

    }

    @Test
    public void testRotateLeft() {
        RedBlackTree tree = new RedBlackTree();
        tree.add(10);
        tree.add(12);
        tree.add(15);
        tree.add(11);
        tree.add(2);

        tree.root = tree.rotateLeft(tree.root);

        ArrayList<RBNode> nodesPreOrder = tree.getNodesPreOrder(new ArrayList<RBNode>(), tree.root);
        int[] arr = new int[5];
        for (int i = 0; i < nodesPreOrder.size(); i++) {
            arr[i] = (Integer) nodesPreOrder.get(i).data;
        }

        assertArrayEquals(new int[] { 12, 10, 2, 11, 15 }, arr);
    }

    @Test
    public void testLargeTreePreOrder() {
        RedBlackTree tree = new RedBlackTree();
        tree.add(10);
        tree.add(12);
        tree.add(15);
        tree.add(11);
        tree.add(6);
        tree.add(5);
        tree.add(7);
        tree.add(1);
        tree.add(2);

        ArrayList<RBNode> nodesPreOrder = tree.getNodesPreOrder(new ArrayList<RBNode>(), tree.root);
        int[] arr = new int[9];
        for (int i = 0; i < nodesPreOrder.size(); i++) {
            arr[i] = (Integer) nodesPreOrder.get(i).data;
        }

        assertArrayEquals(new int[] { 10, 6, 5, 1, 2, 7, 12, 11, 15 }, arr);
    }

    @Test
    public void testLargeRotateRight() {
        RedBlackTree tree = new RedBlackTree();
        tree.add(10);
        tree.add(12);
        tree.add(15);
        tree.add(11);
        tree.add(6);
        tree.add(5);
        tree.add(7);
        tree.add(1);
        tree.add(2);

        tree.rotateRight(tree.root);
        
        ArrayList<RBNode> nodesPreOrder = tree.getNodesPreOrder(new ArrayList<RBNode>(), tree.root);
        int[] arr = new int[9];
        for (int i = 0; i < nodesPreOrder.size(); i++) {
            arr[i] = (Integer) nodesPreOrder.get(i).data;
        }

        assertArrayEquals(new int[] {6,5,1,2,10,7,12,11,15}, arr);
    }
    
    @Test
    public void testLargeRotateRightNotFromRoot() {
        RedBlackTree tree = new RedBlackTree();
        tree.add(10);
        tree.add(12);
        tree.add(15);
        tree.add(11);
        tree.add(8);
        tree.add(9);
        tree.add(5);
        tree.add(1);
        tree.add(7);
        
        tree.rotateRight(tree.root.left);
        
        ArrayList<RBNode> nodesPreOrder = tree.getNodesPreOrder(new ArrayList<RBNode>(), tree.root);
        int[] arr = new int[9];
        for (int i = 0; i < nodesPreOrder.size(); i++) {
            arr[i] = (Integer) nodesPreOrder.get(i).data;
        }

        assertArrayEquals(new int[] {10,5,1,8,7,9,12,11,15}, arr);
    }
    
    @Test
    public void testLargeRotateLeft() {
        RedBlackTree tree = new RedBlackTree();
        tree.add(5);
        tree.add(10);
        tree.add(8);
        tree.add(15);
        tree.add(6);
        tree.add(7);
        tree.add(11);
        tree.add(17);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        
        tree.rotateLeft(tree.root);
        
        ArrayList<RBNode> nodesPreOrder = tree.getNodesPreOrder(new ArrayList<RBNode>(), tree.root);
        int[] arr = new int[11];
        for (int i = 0; i < nodesPreOrder.size(); i++) {
            arr[i] = (Integer) nodesPreOrder.get(i).data;
        }
        
        assertArrayEquals(new int[] {10,5,3,2,4,8,6,7,15,11,17}, arr);
    }
    
    @Test
    public void testLargeRotateLeftNotFromRoot() {
        RedBlackTree tree = new RedBlackTree();
        tree.add(5);
        tree.add(10);
        tree.add(8);
        tree.add(15);
        tree.add(6);
        tree.add(7);
        tree.add(11);
        tree.add(17);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        
        tree.rotateLeft(tree.root.right);
        
        ArrayList<RBNode> nodesPreOrder = tree.getNodesPreOrder(new ArrayList<RBNode>(), tree.root);
        int[] arr = new int[11];
        for (int i = 0; i < nodesPreOrder.size(); i++) {
            arr[i] = (Integer) nodesPreOrder.get(i).data;
        }
        
        assertArrayEquals(new int[] {5,3,2,4,15,10,8,6,7,11,17}, arr);
    }
    
    @Test
    public void testEntireTree() {
        RedBlackTree tree = new RedBlackTree();
        tree.add(5);
        tree.add(10);
        tree.add(8);
        tree.add(15);
        tree.add(6);
        tree.add(9);
        tree.add(11);
        tree.add(17);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        
        // ------- Level One ---------
        // Data
        assertEquals(5, tree.root.data);
        assertEquals(10, tree.root.right.data);
        assertEquals(3, tree.root.left.data);
        // Parent
        assertEquals(5, tree.root.right.parent.data);
        assertEquals(5, tree.root.left.parent.data);
        // Side
        assertEquals(RedBlackTree.SIDE_LEFT, tree.root.left.side);
        assertEquals(RedBlackTree.SIDE_RIGHT, tree.root.right.side);
        
        assertEquals(15, tree.root.right.right.data);
        assertEquals(10, tree.root.right.right.parent.data);
        assertEquals(RedBlackTree.SIDE_RIGHT, tree.root.right.right.side);
        
        assertEquals(8, tree.root.right.left.data);
        assertEquals(10, tree.root.right.left.parent.data);
        assertEquals(RedBlackTree.SIDE_LEFT, tree.root.right.left.side);
        
        assertEquals(11, tree.root.right.right.left.data);
        assertEquals(15, tree.root.right.right.left.parent.data);
        assertEquals(RedBlackTree.SIDE_LEFT, tree.root.right.right.left.side);
        
        assertEquals(17, tree.root.right.right.right.data);
        assertEquals(15, tree.root.right.right.right.parent.data);
        assertEquals(RedBlackTree.SIDE_RIGHT, tree.root.right.right.right.side);
        
        assertEquals(6, tree.root.right.left.left.data);
        assertEquals(8, tree.root.right.left.left.parent.data);
        assertEquals(RedBlackTree.SIDE_LEFT, tree.root.right.left.left.side);
        
        assertEquals(9, tree.root.right.left.right.data);
        assertEquals(8, tree.root.right.left.right.parent.data);
        assertEquals(RedBlackTree.SIDE_RIGHT, tree.root.right.left.right.side);
        
        assertEquals(2, tree.root.left.left.data);
        assertEquals(3, tree.root.left.left.parent.data);
        assertEquals(RedBlackTree.SIDE_LEFT, tree.root.left.left.side);
        
        assertEquals(4, tree.root.left.right.data);
        assertEquals(3, tree.root.left.right.parent.data);
        assertEquals(RedBlackTree.SIDE_RIGHT, tree.root.left.right.side);
    }
    
    @Test
    public void testEntireTreeAfterRotationRight() {
        RedBlackTree tree = new RedBlackTree();
        tree.add(5);
        tree.add(10);
        tree.add(8);
        tree.add(15);
        tree.add(6);
        tree.add(9);
        tree.add(11);
        tree.add(17);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        
        tree.rotateRight(tree.root);
        
        assertEquals(3, tree.root.data);
        
        assertEquals(2, tree.root.left.data);
        assertEquals(3, tree.root.left.parent.data);
        assertEquals(RedBlackTree.SIDE_LEFT, tree.root.left.side);
        
        assertEquals(5, tree.root.right.data);
        assertEquals(3, tree.root.right.parent.data);
        assertEquals(RedBlackTree.SIDE_RIGHT, tree.root.right.side);
        
        assertEquals(4, tree.root.right.left.data);
        assertEquals(5, tree.root.right.left.parent.data);
        assertEquals(RedBlackTree.SIDE_LEFT, tree.root.right.left.side);
        
        assertEquals(10, tree.root.right.right.data);
        assertEquals(5, tree.root.right.right.parent.data);
        assertEquals(RedBlackTree.SIDE_RIGHT, tree.root.right.right.side);
        
        assertEquals(8, tree.root.right.right.left.data);
        assertEquals(10, tree.root.right.right.left.parent.data);
        assertEquals(RedBlackTree.SIDE_LEFT, tree.root.right.right.left.side);
        
        assertEquals(15, tree.root.right.right.right.data);
        assertEquals(10, tree.root.right.right.right.parent.data);
        assertEquals(RedBlackTree.SIDE_RIGHT, tree.root.right.right.right.side);

    }
    
    @Test
    public void testEntireTreeAfterRotationLeft() {
        RedBlackTree tree = new RedBlackTree();
        tree.add(5);
        tree.add(10);
        tree.add(8);
        tree.add(15);
        tree.add(6);
        tree.add(9);
        tree.add(11);
        tree.add(17);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        
        tree.rotateLeft(tree.root);
        
        assertEquals(10, tree.root.data);
        
        assertEquals(5, tree.root.left.data);
        assertEquals(10, tree.root.left.parent.data);
        assertEquals(RedBlackTree.SIDE_LEFT, tree.root.left.side);
        
        assertEquals(15, tree.root.right.data);
        assertEquals(10, tree.root.right.parent.data);
        assertEquals(RedBlackTree.SIDE_RIGHT, tree.root.right.side);
        
        assertEquals(3, tree.root.left.left.data);
        assertEquals(5, tree.root.left.left.parent.data);
        assertEquals(RedBlackTree.SIDE_LEFT, tree.root.left.left.side);
        
        assertEquals(8, tree.root.left.right.data);
        assertEquals(5, tree.root.left.right.parent.data);
        assertEquals(RedBlackTree.SIDE_RIGHT, tree.root.left.right.side);
        
        // I'm convinced
    }
    
    @Test 
    public void testLeftRightRotate() {
        RedBlackTree tree = new RedBlackTree();
        tree.add(10);
        tree.add(6);
        tree.add(2);
        tree.add(8);
        tree.add(7);
        tree.add(9);
        tree.add(15);
        tree.add(1);
        tree.add(3);
        tree.add(14);
        tree.add(16);
        
        tree.leftRightRotation(tree.root.left.right);
        
        ArrayList<RBNode> nodesPreOrder = tree.getNodesPreOrder(new ArrayList<RBNode>(), tree.root);
        int[] arr = new int[11];
        for (int i = 0; i < nodesPreOrder.size(); i++) {
            arr[i] = (Integer) nodesPreOrder.get(i).data;
        }
        
        assertArrayEquals(new int[] {8,6,2,1,3,7,10,9,15,14,16}, arr);
        assertEquals(8, tree.root.data);
        
    }
    
    @Test
    public void testRightLeftRotate() {
        RedBlackTree tree = new RedBlackTree();
        tree.add(10);
        tree.add(15);
        tree.add(12);
        tree.add(11);
        tree.add(13);
        tree.add(17);
        tree.add(8);
        
        tree.rightLeftRotation(tree.root.right.left);
        
        ArrayList<RBNode> nodesPreOrder = tree.getNodesPreOrder(new ArrayList<RBNode>(), tree.root);
        int[] arr = new int[7];
        for (int i = 0; i < nodesPreOrder.size(); i++) {
            arr[i] = (Integer) nodesPreOrder.get(i).data;
        }
        
        assertArrayEquals(new int[] {12,10,8,11,15,13,17}, arr);
        assertEquals(12, tree.root.data);
        assertEquals(10, tree.root.left.data);
        assertEquals(15, tree.root.right.data);
        assertEquals(8, tree.root.left.left.data);
        assertEquals(11, tree.root.left.right.data);
        assertEquals(13, tree.root.right.left.data);
        assertEquals(17, tree.root.right.right.data);
        
    }
    @Test
    public void testRightLeftRotateOutsideRoot() {
        RedBlackTree tree = new RedBlackTree();
        tree.add(7);
        tree.add(5);
        tree.add(10);
        tree.add(15);
        tree.add(12);
        tree.add(11);
        tree.add(13);
        tree.add(17);
        tree.add(8);
        
        tree.rightLeftRotation(tree.root.right.right.left);
        
        ArrayList<RBNode> nodesPreOrder = tree.getNodesPreOrder(new ArrayList<RBNode>(), tree.root);
        int[] arr = new int[9];
        for (int i = 0; i < nodesPreOrder.size(); i++) {
            arr[i] = (Integer) nodesPreOrder.get(i).data;
        }
        
        assertArrayEquals(new int[] {7,5,12,10,8,11,15,13,17}, arr);
        assertEquals(7, tree.root.data);
        assertEquals(5, tree.root.left.data);
        assertEquals(12, tree.root.right.data);
        
    }
}
