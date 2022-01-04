/**
 * Unbalanced BST for testing purposes
 * 
 * @author haejinlee
 *
 * @param <T>
 */
public class UnbalancedBST<T extends Comparable<T>> extends BinarySearchTree<T>{

	public UnbalancedBST() {
		this.root = super.root;
	}

	@Override
	public boolean insert(T data) {
		if(data == null) throw new NullPointerException();
		if(search(data)) return false; // returns false for duplicate data
		if(root == null) this.root = new BSTNode<T>(data, null, null); // if tree is empty, insert new node as root
		insertHelper(root, data); // calls helper method
		return true;
	}
	private void insertHelper(BSTNode<T> cur, T data){ // helper method for insert
		int result = data.compareTo(cur.getData()); // compare data value to cur's value
		if(result > 0) { // if the data value is greater than cur's value
			if(cur.getRight() == null) // found correct spot
				cur.setRight(new BSTNode<T>(data, null, null)); // insert new node as current node's right child
			else insertHelper(cur.getRight(), data); // recursive move into right child
		}
		if(result < 0) { // if the data value is less than cur's value
			if(cur.getLeft() == null) // found correct spot
				cur.setLeft(new BSTNode<T>(data, null, null)); // insert new node as current node's left child
			else insertHelper(cur.getLeft(), data); // recursive move into left child
		}
	}

	@Override
	public boolean delete(T data) {
		if(data == null) throw new NullPointerException();
		if(!search(data)) return false; // returns false if the node to delete isn't in the tree
		root = deleteHelper(root, data); // calls helper method
		return true; // returns true after successful deletion
	}
	private BSTNode<T> deleteHelper(BSTNode<T> cur, T data) {
		//TODO
		return null;
	}
	
	
}