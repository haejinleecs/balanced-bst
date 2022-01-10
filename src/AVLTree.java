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
	

	public boolean insert(T data) {
		if(data == null) throw new NullPointerException();
		if(search(data)) return false; // returns false for duplicate data	
		root = insertHelper(root, new AVLNode<T>(data)); // call helper
		return true;
	}
	private AVLNode<T> insertHelper(AVLNode<T> cur, AVLNode<T> add){ // helper method for insert
		if(cur == null) return add; // found the right spot so returns node to add (to set the links)
		int result = add.getData().compareTo(cur.getData()); // compare node to add's value to cur's value
		if(result > 0) // if add's value is greater than cur's value
			cur.setRight(insertHelper(cur.getRight(), add)); // set cur's right as updated right subtree
		if(result < 0) // if the data value is less than cur's value
			cur.setLeft(insertHelper(cur.getLeft(), add)); // set cur's left as updated left subtree
		
		// update height of nodes
		cur.setHeight(Math.max(cur.getLeft().getHeight(), cur.getRight().getHeight()) + 1); 
		
		// obtain the balance factor of the tree
		int balance = getBalance(cur);
		
		
		// 1. right right case
		if(balance < -1 && (cur.getRight().getData().compareTo(add.getData()) < 0)) { // added node is on right right
			return leftRotate(cur); // left rotate whole tree
		}
		
		// 2. right left case
		if(balance < -1 && (cur.getRight().getData().compareTo(add.getData()) > 0)) { // added node is on right left
			cur.setRight(rightRotate(cur.getRight())); // right rotate the right subtree to make it right right case
			return leftRotate(cur); // then left rotate the whole tree
		}
		
		// 3. left left case
		if(balance > 1 && (cur.getLeft().getData().compareTo(add.getData()) > 0)) { // added node is on left left
			return rightRotate(cur); // right rotate whole tree
		}
		
		// 4. left right case
		if(balance > 1 && (cur.getLeft().getData().compareTo(add.getData()) < 0)) { // added node is on left right
			cur.setLeft(leftRotate(cur.getLeft())); // left rotate the left subtree to make it left left case
			return rightRotate(cur); // right rotate whole tree
		}
				
		return cur; // returns new root after insertion and re-balancing is complete
	}
	
	public int getBalance(AVLNode<T> cur) {
		if(cur == null) return 0;
		return cur.getLeft().getHeight() - cur.getRight().getHeight();
	}
	
	public AVLNode<T> rightRotate(AVLNode<T> cur){
		//TODO
		
		return null;
	}
	public AVLNode<T> leftRotate(AVLNode<T> cur){
		//TODO
		return null;
	}
	
	@Override
	public boolean delete(T data) {
		// TODO Auto-generated method stub
		return false;
	}
	
}