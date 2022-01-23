/**
 * Rules That Every Red-Black Tree Follows: 
 * 
 * 	1) Every node has a colour either red or black.
 * 	2) The root of the tree is always black.
 * 	3) There are no two adjacent red nodes (A red node cannot have a red parent or red child).
 * 	4) Every path from a node (including root) to any of its descendants NULL nodes has the same number of black nodes.
 * 	5) All leaf nodes are black nodes.
 * 
 * @author haejinlee
 * 
 * @param <T>
 */
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
