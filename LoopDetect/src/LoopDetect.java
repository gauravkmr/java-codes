class Node
{
	int data;
	Node next = null;
	String color;
	
	public Node(int d)
	{
		data = d;
		color = "white";
	}
	
	public Node findLoop(Node head)
	{
		Node n1 = head;
		Node n2 = head;
		
		while(n2.next != null)
		{
			n1 = n1.next;
			n2 = n2.next.next;
			if(n1 == n2)
				break;
		}
		
		if(n2.next == null)
			return null;
		
		n1 = head;
		
		while(n1 != n2)
		{
			n1 = n1.next;
			n2 = n2.next;
		}
		return n2;
	}
	
	public Node findLoop1(Node head)
	{
		while(head.next != null)
		{
			if(head.color == "white")
				head.color = "black";
			else
				return head;
			head = head.next;
		}
		return null;
	}
}

public class LoopDetect 
{
	public static void main(String[] args) 
	{
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(3);
		
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = four;
		
		System.out.println("node at the beginning of loop: " + one.findLoop1(one).data);
		
	}

}
