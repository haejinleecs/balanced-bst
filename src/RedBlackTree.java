
public class RedBlackTree <T extends Comparable<T>> extends BinarySearchTree<T>{
	
	public RedBlackTree() {
		this.setRoot((RedBlackNode<T>)super.root);
	}

	public RedBlackNode<T> getRoot() {
		return (RedBlackNode<T>)root;
	}
	
	public void setRoot(RedBlackNode<T> root){
		this.root = root;
	}
	
	@Override
	public boolean insert(T data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(T data) {
		// TODO Auto-generated method stub
		return false;
	}

}
