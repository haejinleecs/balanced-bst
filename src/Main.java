import java.util.Iterator;

public class Main{
	public static void main(String args[]) {
		// test BST methods on unbalanced tree
		
		System.out.println("BST Tests:");
		System.out.println();
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
		
		
		System.out.println();
		// test AVL Tree
		System.out.println("AVL Tree Test:");
		System.out.println();
		
		// create tree
		AVLTree<String> tree2 = new AVLTree<String>();
		
		// add elements
		for (String i : new String[] { "a", "b", "c", "d", "e", "f", "g" }) {
			tree2.insert(i);
			// check balance
			System.out.println("Added "+i+" to tree");
			System.out.println("The balance factor of tree2 is: "+tree2.getBalance(tree2.getRoot()));
			System.out.println("In-order Traversal:");
			tree.printTree(tree2.inorder());
		}

		System.out.println();

		// delete elements
		for (String i : new String[] { "a", "b", "c", "d", "e", "f", "g" }) {
			if(tree2.delete(i))
				System.out.println("Deleted "+i+" from tree");
			else
				System.out.println("Could not delete " +i+" from tree.");
			// check balance
			System.out.println("The balance factor of tree2 is: "+tree2.getBalance(tree2.getRoot()));
			System.out.println("In-order Traversal:");
			tree.printTree(tree2.inorder());
		}
		
	}
}