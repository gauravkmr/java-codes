
public class LL_Node 
{
	private Node node;
	private LL_Node next;
	
	public LL_Node(Node n)
	{
		this.node = n;
		this.next = null;
	}
	
	public Node getNode() 
	{
		return node;
	}
	
	public void setNode(Node node) 
	{
		this.node = node;
	}
	
	public LL_Node getNext() 
	{
		return next;
	}
	
	public void setNext(LL_Node next) 
	{
		this.next = next;
	}
	
}
