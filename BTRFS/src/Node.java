
public class Node 
{
	private int ID;
	private int dirty;
	private int left_key, middle_key, right_key;
	private Node left;
	private Node right;
	private Node middle;
	
	Node(int id) 
	{
		this.ID = id;
	}
	
	Node(int id, int left, int middle, int right) 
	{
		this.ID = id;
		this.left_key = left;
		this.middle_key = middle;
		this.right_key = right;
	}
	

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getDirty() {
		return dirty;
	}
	public void setDirty(int dirty) {
		this.dirty = dirty;
	}
	public int getLeft_key() {
		return left_key;
	}
	public void setLeft_key(int left_key) {
		this.left_key = left_key;
	}
	public int getMiddle_key() {
		return middle_key;
	}
	public void setMiddle_key(int middle_key) {
		this.middle_key = middle_key;
	}
	public int getRight_key() {
		return right_key;
	}
	public void setRight_key(int right_key) {
		this.right_key = right_key;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getMiddle() {
		return middle;
	}
	public void setMiddle(Node middle) {
		this.middle = middle;
	}
}
