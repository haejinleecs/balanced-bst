/**
 * BSTInterface
 * 
 * @author haejinlee
 *
 * @param <T>
 */
import java.util.Iterator;

public abstract class BinarySearchTree<T extends Comparable<T>> {
	
	BSTNode<T> root;
	
	/**
	 * inserts data into this BST
	 * @param node
	 * @return true if data is inserted; false if data is a duplicate
	 */
	public abstract boolean insert(T data);
	
	/**
	 * @param node
	 * @return true if deletion is successful, that is if the tree contains this node and it's removed successfully
	 */
	public abstract boolean delete(BSTNode<T> node);
	
	/**
	 * @param node
	 * @return true if node is contained in this tree
	 */
	public boolean search(T data){
		return searchHelper(root, data);
	}
	protected boolean searchHelper(BSTNode<T> cur, T data) {
		int result = data.compareTo(cur.getData()); // compare data value to cur's value
		if(result > 0) // data value > cur's value
			return searchHelper(cur.getRight(), data);
		if(result < 0) // data value < cur's value
			return searchHelper(cur.getLeft(), data);
		return true; // data value = cur's value
	}
	
	/**
	 * @return in-order traversal of tree
	 */
	public Iterator<T> inorder(){
		//TODO
		return null;
	}
	
	/**
	 * @return pre-order traversal of tree
	 */
	public Iterator<T> preorder(){
		//TODO
		return null;
	}
	
	/**
	 * @return post-order traversal of tree
	 */
	public Iterator<T> postorder(){
		//TODO
		return null;
	}
	
	/**
	 * @param parent
	 * @return left child of parent, or null if there is no left child
	 */
	public BSTNode<T> leftChild(BSTNode<T> parent){
		return parent.getLeft();
	}
	
	/**
	 * @param parent
	 * @return right child of parent, or null if there is no right child
	 */
	public BSTNode<T> rightChild(BSTNode<T> parent){
		return parent.getRight();
	}
	
	/**
	 * @param child
	 * @return child's parent node
	 */
	public BSTNode<T> predecessor(BSTNode<T> child){
		return child.getParent();
	}
	
	
}