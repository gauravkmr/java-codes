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
	
	public boolean deleteNode(Node n)
	{
		if(n == null || n.next == null)  //n has to be in the middle of Linked List
			return false;
		
		Node next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}
}

public class DeleteNode 
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
		
		Node tmp = SLL;
		while(tmp != null)
		{
			System.out.print(tmp.data);
			System.out.print(" ");
			tmp = tmp.next;
		}
		
		System.out.println();
		
		if(SLL.deleteNode(SLL.next))
		{
			tmp = SLL;
			while(tmp != null)
			{
				System.out.print(tmp.data);
				System.out.print(" ");
				tmp = tmp.next;
			}
		}
	}

}
