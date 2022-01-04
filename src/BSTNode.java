/**
 * An element in a BST
 * 
 * @author haejinlee
 *
 * @param <T> 
 */
public class BSTNode<T>{
	private T data;
	private BSTNode<T> left;
	private BSTNode<T> right;
	private BSTNode<T> parent;


	public BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
		this.data = data;
		setLeft(left);
		setRight(right);
		this.parent = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BSTNode<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNode<T> left) {
		this.left = left;
		if(this.left!= null) this.left.parent = this;
	}

	public BSTNode<T> getRight() {
		return right;
	}

	public void setRight(BSTNode<T> right) {
		this.right = right;
		if(this.right!= null) this.right.parent = this;
	}
	
	public BSTNode<T> getParent(){
		return parent;
	}
	
	public void setParent(BSTNode<T> parent){
		this.parent = parent;
	}
	
}