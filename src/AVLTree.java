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
		this.setRoot((AVLNode<T>)super.root);
	}

	public AVLNode<T> getRoot() {
		return root;
	}
	
	public void setRoot(AVLNode<T> root){
		this.root = root;
	}
	
	public int height(AVLNode<T> node) {
		if(node == null) return 0;
		return node.getHeight();
	}

	public boolean insert(T data) {
		if(data == null) throw new NullPointerException();
		if(search(data)) return false; // returns false for duplicate data	
		setRoot(insertHelper(getRoot(), new AVLNode<T>(data))); // call helper
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
		cur.setHeight(Math.max(height(cur.getLeft()), height(cur.getRight())) + 1); 
		
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
	
	public AVLNode<T> rightRotate(AVLNode<T> z){
		if(z == null) throw new NullPointerException();
		
		AVLNode<T> y = z.getLeft(); // z's right child y will be the new root of this subtree
		AVLNode<T> yRight = y.getRight(); // save y's right subtree for setting links

		// set new links
		y.setRight(z); // set z as right child of y
		z.setLeft(yRight); // set y's saved right subtree as z's left subtree
		
		// update heights
		z.setHeight(Math.max(height(z.getLeft()), height(z.getRight())) + 1); // set z's new height first
		y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1); // set y's height (root height)
		
		return y;
	}
	
	public AVLNode<T> leftRotate(AVLNode<T> z){
		if(z == null) throw new NullPointerException();
		
		AVLNode<T> y = z.getRight(); // z's right child y will be the new root of this subtree
		AVLNode<T> yLeft = y.getLeft(); // save y's right subtree for setting links

		// set new links
		y.setLeft(z); // set z as left child of y
		z.setRight(yLeft); // set y's saved left subtree as z's right subtree
		
		// update heights
		z.setHeight(Math.max(height(z.getLeft()), height(z.getRight())) + 1); // set z's new height first
		y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1); // set y's height (root height)
		
		return y;
	}
	
	@Override
	public boolean delete(T data) {
		//TODO
		return false;
	}

	
}