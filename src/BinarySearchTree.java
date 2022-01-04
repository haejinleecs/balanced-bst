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
	 * @param value
	 * @return new tree with given root value
	 */
	public BSTNode<T> create(T value){
		return new BSTNode<T>(value, null, null);
	}
	
	/**
	 * @param node
	 * @return root of the new tree with inserted node
	 */
	public abstract BSTNode<T> insert(BSTNode<T> node);
	
	/**
	 * @param node
	 * @return true if deletion is successful, that is if the tree contains this node and it's removed successfully
	 */
	public abstract boolean delete(BSTNode<T> node);
	
	/**
	 * @param node
	 * @return true if node is contained in this tree
	 */
	public boolean search(BSTNode<T> node){
		//TODO
		return false;
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
		//TODO
		return null;
	}
	
	/**
	 * @param parent
	 * @return right child of parent, or null if there is no right child
	 */
	public BSTNode<T> rightChild(BSTNode<T> parent){
		//TODO
		return null;
	}
	
	/**
	 * @param child
	 * @return child's parent node
	 */
	public BSTNode<T> predecessor(BSTNode<T> child){
		return child.getParent();
	}
	
	
}