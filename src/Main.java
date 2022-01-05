import java.util.Iterator;

public class Main{
	public static void main(String args[]) {
		// test BST methods
		
		// create tree and add elements
		UnbalancedBST<String> tree = new UnbalancedBST<String>(); 
		for (String i : new String[] { "a", "b", "c", "d", "e", "f", "g" }) tree.insert(i);
		System.out.println("Added a, b, c, d, e, f, g to tree");
		
		// test traversals
		Iterator<String> inorderIter = tree.inorder();
		Iterator<String> preorderIter = tree.preorder();
		Iterator<String> postorderIter = tree.postorder();
		System.out.println("In-order Traversal:");
		while(inorderIter.hasNext()) {
			System.out.print(inorderIter.next());
		}
		System.out.println();
		System.out.println("Pre-order Traversal:");
		while(preorderIter.hasNext()) {
			System.out.print(preorderIter.next());
		}
		System.out.println();
		System.out.println("Post-order Traversal:");
		while(postorderIter.hasNext()) {
			System.out.print(postorderIter.next());
		}
		System.out.println();
		
		// test delete method
		tree.delete("a");
		System.out.println("Removed a"); 
		inorderIter = tree.inorder();
		while(inorderIter.hasNext()) {
			System.out.print(inorderIter.next());
		}
		System.out.println();
		
		// test search
		System.out.println("a is in the tree? " +tree.search("a")); // should return false
		System.out.println("b is in the tree? " +tree.search("b")); // should return true
		
		
	}
}