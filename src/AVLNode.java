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
	public AVLNode(T data) {
		super(data);
		height = 1;
	}

	public AVLNode<T> getLeft(){
		return (AVLNode<T>)super.getLeft();
	}

	public void setLeft(AVLNode<T> left) {
		super.setLeft(left);
	}

	public AVLNode<T> getRight() {
		return (AVLNode<T>)super.getRight();
	}

	public void setRight(AVLNode<T> right) {
		super.setRight(right);
	}
	
	public AVLNode<T> getParent(){
		return (AVLNode<T>)super.getParent();
	}
	
	/**
	 * @return height of the AVL tree
	 */
	public int getHeight() {
		return this.height;
	}
	
	public void setHeight(int h) {
		this.height = h;
	}

}
