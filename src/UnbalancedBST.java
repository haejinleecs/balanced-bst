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
		root = insertHelper(root, new BSTNode<T> (data)); // calls helper method
		return true;
	}
	private BSTNode<T> insertHelper(BSTNode<T> cur, BSTNode<T> add){ // helper method for insert
		if(cur == null) return add; // found the right spot so returns node to add (to set the links)
		int result = add.getData().compareTo(cur.getData()); // compare node to add's value to cur's value
		if(result > 0) // if add's value is greater than cur's value
			cur.setRight(insertHelper(cur.getRight(), add)); // set cur's right as updated right subtree
		if(result < 0) // if the data value is less than cur's value
			cur.setLeft(insertHelper(cur.getLeft(), add)); // set cur's left as updated left subtree
		return cur; // returns new root after insertion is complete
	}

	@Override
	public boolean delete(T data) {
		if(data == null) throw new NullPointerException();
		if(!search(data)) return false; // returns false if the node to delete isn't in the tree
		root = deleteSubtree(root, data);
		return true; // returns true after successful deletion
	}
	private BSTNode<T> deleteSubtree(BSTNode<T> cur, T data) { // helper for delete()
		// node must not be null
		int result = data.compareTo(cur.getData()); // compares data value to cur's value
		if (result < 0) { // if data value < cur's value
			cur.setLeft(deleteSubtree(cur.getLeft(), data)); // sets current node's left subtree as the subtree with the node removed
			return cur; // returns subtree's root
		} 
		else if (result > 0) { // if data value > cur's value
			cur.setRight(deleteSubtree(cur.getRight(), data)); // sets current node's right subtree as the subtree with the node removed
			return cur; // returns subtree's root
		} 
		else { // if data value = cur's value; proceed with deletion process
			if (cur.getLeft() == null) { // if the left subtree is empty
				return cur.getRight(); // returns cur's right child
			} 
			else if (cur.getRight() == null) { // if the right subtree is empty
				return cur.getLeft(); // returns cur's left child
			} 
			else { // if neither child subtrees is empty
				T predecessorValue = getHighestValue(cur.getLeft()); // finds the predecessor of cur (highest value node in left subtree)
				cur.setLeft(removeRightmost(cur.getLeft())); // removes highest value node from cur's left subtree
				cur.setData(predecessorValue); // replaces cur's value with its predecessor's value
				return cur; // returns root of tree with deletion done
			}
		}
	}
	private T getHighestValue(BSTNode<T> cur) { // helper for delete()
		if(cur.getRight() != null) return getHighestValue(cur.getRight()); // if current node has right subtree, recurse into right subtree
		return cur.getData(); // else returns cur's value
	}
	private BSTNode<T> removeRightmost(BSTNode<T> cur) { // helper for delete()
		if (cur.getRight() == null) { // if current node has no right subtree
			return cur.getLeft(); // return left subtree which will replace the removed node or null if there is no left subtree
		} else { // if current node has a right subtree
			cur.setRight(removeRightmost(cur.getRight())); // recurses into cur's right subtree and updates cur's right subtree
			return cur; // returns current root
		}
	}

}
	