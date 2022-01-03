/**
 * Standard Binary Search Tree
 */

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T> {
	
	protected BSTNode<T> root;
	private int size;
	
	@Override
	public boolean isEmpty() {
		return (root == null);
	}

	@Override
	public int size() {
		return recurSize(root);
	}
	protected int recurSize(BSTNode<T> root) {
		if(root == null) return 0; // returns size 0 if the current node is null and thus 0 for empty trees
		else return 1 + recurSize(root.getLeft()) + recurSize(root.getRight()); // otherwise counts 1 for current node and adds size of the left and right subtrees
	}

	@Override
	public boolean contains(T element) {
		
		return false;
	}

	@Override
	public boolean remove(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getMinimum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getMaximum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<T> preorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> inorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> postorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(BSTInterface<T> other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sameValues(BSTInterface<T> other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBalanced() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void balance() {
		// TODO Auto-generated method stub
		
	}
	
}
	