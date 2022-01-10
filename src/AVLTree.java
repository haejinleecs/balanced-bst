/**
 * AVL tree:
 * 		Self-balancing BST whose height difference between left and right subtree is no more than 1
 * @author haejinlee
 *
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
	
	private AVLNode<T> root;
	
	public AVLTree() {
		this.root = (AVLNode<T>)super.root;
	}
	
	@Override
	public boolean insert(T data) {
		if(data == null) throw new NullPointerException();
		if(search(data)) return false; // returns false for duplicate data	
		root = insertHelper(root, new AVLNode<T> (data)); // perform insertion
		return true;
	}
	private AVLNode<T> insertHelper(AVLNode<T> cur, AVLNode<T> add){ // helper method for insert
		if(cur == null) return add; // found the right spot so returns node to add (to set the links)
		int result = add.getData().compareTo(cur.getData()); // compare node to add's value to cur's value
		if(result > 0) // if add's value is greater than cur's value
			cur.setRight(insertHelper(cur.getRight(), add)); // set cur's right as updated right subtree
		if(result < 0) // if the data value is less than cur's value
			cur.setLeft(insertHelper(cur.getLeft(), add)); // set cur's left as updated left subtree
		cur.setHeight(Math.max(cur.getLeft().getHeight(), cur.getRight().getHeight()));
		return cur; // returns new root after insertion is complete
	}

	@Override
	public boolean delete(T data) {
		// TODO Auto-generated method stub
		return false;
	}
	
}