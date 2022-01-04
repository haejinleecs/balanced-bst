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
		if(search(data)) return false; // return false for duplicate data
		if(root == null) this.root = new BSTNode<T>(data, null, null); // if tree is empty, insertion at root 
		insertHelper(root, data); // call helper method
		return true;
	}
	protected void insertHelper(BSTNode<T> cur, T data){ // helper method for insert
		int result = data.compareTo(cur.getData()); // compare data value to cur's value
		if(result > 0) { // data value is greater than cur's value
			if(cur.getRight() == null) // found correct spot
				cur.setRight(new BSTNode<T>(data, null, null)); // insert new node as current node's right child
			else insertHelper(cur.getRight(), data); // recursive move into right child
		}
		if(result < 0) { // data value is less than cur's value
			if(cur.getLeft() == null) // found correct spot
				cur.setLeft(new BSTNode<T>(data, null, null)); // insert new node as current node's left child
			else insertHelper(cur.getLeft(), data); // recursive move into left child
		}
	}
	@Override
	public boolean delete(BSTNode<T> node) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}