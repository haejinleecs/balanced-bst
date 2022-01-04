/**
 * Unbalanced BST for testing purposes
 * 
 * @author haejinlee
 *
 * @param <T>
 */
public class UnbalancedBST<T extends Comparable<T>> extends BinarySearchTree<T>{

	@Override
	public BSTNode<T> create(T value) {
		return new BSTNode<T>(value, null, null);
	}

	@Override
	public BSTNode<T> insert(BSTNode<T> node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(BSTNode<T> node) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}