/**
 * Binary Search Tree abstract class
 * 
 * @author haejinlee
 *
 * @param <T>
 */

// use for traversal methods
import java.util.Iterator;
import java.util.LinkedList; 
import java.util.Queue;

public abstract class BinarySearchTree<T extends Comparable<T>> {
	
	BSTNode<T> root;
	
	/**
	 * inserts data into this BST
	 * @param node
	 * @return true if data is inserted; false if data is a duplicate
	 * @throws NullPointerException if data is null
	 */
	public abstract boolean insert(T data);
	
	/**
	 * @param node
	 * @return true if deletion is successful, that is if the tree contains this node and it's removed successfully
	 * @throws NullPointerException if data is null
	 */
	public abstract boolean delete(T data);
	
	/**
	 * @param node
	 * @return true if it is found and false if it isn't found
	 * @throws NullPointerException if data is null
	 */
	public boolean search(T data){
		if(data == null) throw new NullPointerException();
		return searchHelper(root, data);
	}
	private boolean searchHelper(BSTNode<T> cur, T data) {
		if(cur == null) return false; // returns null if there is no node with same data value
		int result = data.compareTo(cur.getData()); // compare data value to cur's value
		if(result > 0) // if data value > cur's value
			return searchHelper(cur.getRight(), data); // recurses into right subtree
		if(result < 0) // if data value < cur's value
			return searchHelper(cur.getLeft(), data); // recurses into left subtree
		return true; // data value = cur's value, return true
	}
	
	/**
	 * @return in-order traversal of tree
	 */
	public Iterator<T> inorder(){
		Queue<T> queue = new LinkedList<T>(); // create a queue using linked list
		inorderHelper(queue, root); // call helper method
		return queue.iterator(); // return in-order iterator
	}
	private void inorderHelper(Queue<T> queue, BSTNode<T> cur) { // in-order helper method
		if(cur != null) {
			inorderHelper(queue, cur.getLeft());
			queue.add(cur.getData());
			inorderHelper(queue, cur.getRight());
		}
	}
	
	/**
	 * @return pre-order traversal of tree
	 */
	public Iterator<T> preorder(){
		Queue<T> queue = new LinkedList<T>(); // create a queue using linked list
		preorderHelper(queue, root); // call helper method
		return queue.iterator(); // return pre-order iterator
	}
	private void preorderHelper(Queue<T> queue, BSTNode<T> cur) { // pre-order helper method
		if(cur != null) { 
			queue.add(cur.getData());
			preorderHelper(queue, cur.getLeft());
			preorderHelper(queue, cur.getRight());
		}
	}
	
	/**
	 * @return post-order traversal of tree
	 */
	public Iterator<T> postorder(){
		Queue<T> queue = new LinkedList<T>(); // create a queue using linked list
		postorderHelper(queue, root); // call helper method
		return queue.iterator(); // return post-order iterator
	}
	private void postorderHelper(Queue<T> queue, BSTNode<T> cur) { // post-order helper method
		if(cur != null) { 
			postorderHelper(queue, cur.getLeft());
			postorderHelper(queue, cur.getRight());
			queue.add(cur.getData());
		}
	}
	
	/**
	 * @param parent
	 * @return left child of parent, or null if there is no left child
	 * @throws NullPointerException if parent is null
	 */
	public BSTNode<T> leftChild(BSTNode<T> parent){
//		if(parent == null) throw new NullPointerException();
		return parent.getLeft();
	}
	
	/**
	 * @param parent
	 * @return right child of parent, or null if there is no right child
	 * @throws NullPointerException if parent is null
	 */
	public BSTNode<T> rightChild(BSTNode<T> parent){
//		if(parent == null) throw new NullPointerException();
		return parent.getRight();
	}
	
	/**
	 * @param child
	 * @return child's parent node
	 * @throws NullPointerException if child is null
	 */
	public BSTNode<T> predecessor(BSTNode<T> child){
		if(child == null) throw new NullPointerException();
		return child.getParent();
	}
	/**
	 * prints tree
	 * @param iterator
	 */
	public void printTree(Iterator<T> iterator) {
		while(iterator.hasNext()) System.out.print(iterator.next());
		System.out.println();
	}
	
	
}