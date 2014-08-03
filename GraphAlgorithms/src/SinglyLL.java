
public class SinglyLL 
{
	LL_Node head;
	
	public SinglyLL() 
	{
		this.head = null;
	}

	public void insert_front(LL_Node n)
	{
		n.setNext(this.head);
		this.head = n;
	}
}
