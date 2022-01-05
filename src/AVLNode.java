/**
 * a node in an AVL tree
 * @author haejinlee
 *
 * @param <T>
 */

public class AVLNode<T> extends BSTNode<T> {
	
	private int height;
	
	/**
	 * Constructor method
	 * @param data
	 * @param left
	 * @param right
	 * @param height
	 */
	public AVLNode(T data, BSTNode<T> left, BSTNode<T> right, int height) {
		super(data, left, right);
		this.height = height;
	}
	/**
	 * @return height of the AVL tree
	 */
	public int getHeight() {
		return this.height;
	}
	

}
