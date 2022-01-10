import java.util.Iterator;

public class Main{
	public static void main(String args[]) {
		// test BST methods on unbalanced tree
		
		// create tree and add elements
		UnbalancedBST<String> tree = new UnbalancedBST<String>(); 
		for (String i : new String[] { "a", "b", "c", "d", "e", "f", "g" }) tree.insert(i);
		System.out.println("Added a, b, c, d, e, f, g to tree");
		
		// test traversals
		Iterator<String> inorderIter = tree.inorder();
		Iterator<String> preorderIter = tree.preorder();
		Iterator<String> postorderIter = tree.postorder();
		
		System.out.println("In-order Traversal:");
		tree.printTree(inorderIter);
		
		System.out.println("Pre-order Traversal:");
		tree.printTree(preorderIter);

		System.out.println("Post-order Traversal:");
		tree.printTree(postorderIter);
		
		// test delete method
		tree.delete("a");
		System.out.println("Removed a"); 
		tree.printTree(tree.inorder());
		
		// test search
		System.out.println("a is in the tree? " +tree.search("a")); // should return false
		System.out.println("b is in the tree? " +tree.search("b")); // should return true
		
		
		
		// test AVL Tree
		
		// create tree
		AVLTree<String> tree2 = new AVLTree<String>();
		
		// add elements
		for (String i : new String[] { "a", "b", "c", "d", "e", "f", "g" }) tree2.insert(i);
		System.out.println("Added a, b, c, d, e, f, g to tree");
		
		// traversal
		System.out.println("In-order traversal:");
		tree.printTree(tree2.inorder());
		
		// check balance
		System.out.println("The balance factor of tree2 is: "+tree2.getBalance(tree2.getRoot()));
		
	}
}