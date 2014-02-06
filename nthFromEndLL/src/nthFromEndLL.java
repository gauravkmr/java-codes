class Node
{
	int data;
	Node next = null;
	
	public Node(int d)
	{
		data = d;
	}
	
	public void appendToTail(int d)
	{
		Node temp = new Node(d);
		Node head = this;
		
		while(head.next != null)
		{
			head = head.next;
		}
		head.next = temp;
	}
	
	public Node nthNodeFromEnd(Node head, int n)
	{
		Node start = head;
		Node end = head;
		
		for (int i = 1; i < n; i++) 
		{
			if(end == null)
				return null;
			end = end.next;
		}
		while(end.next != null)
		{
			start = start.next;
			end = end.next;
		}
		return start;
	}
}

public class nthFromEndLL 
{
	public static void main(String[] args) 
	{
		Node SLL = new Node(1);
		SLL.appendToTail(2);
		SLL.appendToTail(3);
		SLL.appendToTail(4);
		SLL.appendToTail(5);
		SLL.appendToTail(6);
		SLL.appendToTail(7);
		SLL.appendToTail(8);
		
		Node nth = SLL.nthNodeFromEnd(SLL, 6);
		
		if(nth != null)
			System.out.println("nth node from end is: " + nth.data);
		else
			System.out.println("index is too large.");

	}

}
