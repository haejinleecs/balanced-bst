
public class RedBlackNode<T> extends BSTNode<T> {
	private boolean black; // true if black, false if red
	
	public RedBlackNode(T data) {
		super(data);
		setBlack(true);
	}

	public boolean isBlack() {
		return black;
	}

	public void setBlack(boolean black) {
		this.black = black;
	}

}
