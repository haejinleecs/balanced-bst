/**
 * AVL tree:
 * 		Self-balancing BST whose height difference between left and right subtree is no more than 1
 * @author haejinlee
 *
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
	
	
	public AVLTree() {
		this.setRoot((AVLNode<T>)super.root);
	}

	public AVLNode<T> getRoot() {
		return (AVLNode<T>)root;
	}
	
	public void setRoot(AVLNode<T> root){
		this.root = root;
	}
	
	/**
	 * @param node
	 * @return the height of the node
	 */
	public int height(AVLNode<T> node) {
		if(node == null) return 0;
		return node.getHeight();
	}
	
	@Override
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
		
		// balance the tree
		return balance(cur); // returns new root after insertion and re-balancing is complete
	}
	
	/**
	 * @param cur
	 * @return balance factor of tree rooted at cur
	 */
	public int getBalance(AVLNode<T> cur) {
		if(cur == null) return 0;
		return height(cur.getLeft()) - height(cur.getRight());
	}

	/**
	 * @param z
	 * @return the tree after right-rotation
	 */
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
	
	/**
	 * @param z
	 * @return the tree after left-rotation
	 */
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
	
	/**
	 * @param cur
	 * @return the subtree at cur after balancing
	 */
	public AVLNode<T> balance(AVLNode<T> cur){
		// obtain the balance factor of the tree
		int balance = getBalance(cur);
		
		// 1. right right case
		if(balance < -1 && (getBalance(cur.getRight()) <= 0)) { // added node is on right right
			return leftRotate(cur); // left rotate whole tree
		}
		
		// 2. right left case
		if(balance < -1 && (getBalance(cur.getRight()) > 0)) { // added node is on right left
			cur.setRight(rightRotate(cur.getRight())); // right rotate the right subtree to make it right right case
			return leftRotate(cur); // then left rotate the whole tree
		}
		
		// 3. left left case
		if(balance > 1 && (getBalance(cur.getLeft()) >= 0)) { // added node is on left left
			return rightRotate(cur); // right rotate whole tree
		}
		
		// 4. left right case
		if(balance > 1 && (getBalance(cur.getLeft()) < 0)) { // added node is on left right
			cur.setLeft(leftRotate(cur.getLeft())); // left rotate the left subtree to make it left left case
			return rightRotate(cur); // right rotate whole tree
		}
		return cur;
	}
	
	@Override
	public boolean delete(T data) {
		if(data == null) throw new NullPointerException();
		if(!super.search(data)) return false; // returns false if the node to delete isn't in the tree
		root = deleteSubtree((AVLNode<T>)root, data);
		return true; // returns true after successful deletion
	}
	private AVLNode<T> deleteSubtree(AVLNode<T> cur, T data) { // helper for delete()
		// node must not be null
		int result = data.compareTo(cur.getData()); // compares data value to cur's value
		if (result < 0) { // if data value < cur's value
			cur.setLeft(deleteSubtree(cur.getLeft(), data)); // sets current node's left subtree as the subtree with the node removed
		} 
		else if (result > 0) { // if data value > cur's value
			cur.setRight(deleteSubtree(cur.getRight(), data)); // sets current node's right subtree as the subtree with the node removed
		} 
		else { // if data value = cur's value; proceed with deletion process
			if (cur.getLeft() == null) // if the left subtree is empty
				return cur.getRight(); // new root is cur's right child
			if (cur.getRight() == null) // if the right subtree is empty
				return cur.getLeft(); // new root is cur's left child
			else {// if neither child subtrees is empty
				T predecessorValue = getHighestValue(cur.getLeft()); // finds the predecessor of cur (highest value node in left subtree)
				cur.setLeft(removeRightmost(cur.getLeft())); // removes highest value node from cur's left subtree
				cur.setData(predecessorValue); // replaces cur's value with its predecessor's value
			}
		}
		// update height of nodes
		cur.setHeight(Math.max(height(cur.getLeft()), height(cur.getRight())) + 1); 

		// balance the tree
		return balance(cur); // returns new root after insertion and re-balancing is complete
	}
	private T getHighestValue(AVLNode<T> cur) { // helper for delete()
		if(cur.getRight() != null) return getHighestValue(cur.getRight()); // if current node has right subtree, recurse into right subtree
		return cur.getData(); // else returns cur's value
	}
	private AVLNode<T> removeRightmost(AVLNode<T> cur) { // helper for delete()
		if (cur.getRight() == null) { // if current node has no right subtree
			return cur.getLeft(); // return left subtree which will replace the removed node or null if there is no left subtree
		} else { // if current node has a right subtree
			cur.setRight(removeRightmost(cur.getRight())); // recurses into cur's right subtree and updates cur's right subtree
			return cur; // returns current root
		}
	}
	
}