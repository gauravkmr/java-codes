class Node
{
	int data;
	Node min = null;
	Node next = null;
	
	public Node(){}
	
	public Node(int d)
	{
		data = d;
		min = this;
	}
}

class Stack
{
	Node top;
	
	public void push(int d)
	{
		if(top == null)
		{
			top = new Node(d);
			return;
		}
		Node n = new Node(d);
		n.next = top;
		
		if(d < top.min.data)
			n.min = n;
		else
			n.min = top.min;
		top = n;
		
	}
	
	public Node pop()
	{
		if(top == null)
			return null;
		Node n = top;
		top = top.next;
		n.next = null;
		n.min = null;
		return n;
	}
	
	public Node minimum()
	{
		return top.min;
	}
}

public class StackWithMin 
{
	
	public static void main(String[] args) 
	{
		Stack stck = new Stack();
		stck.push(2);
		stck.push(1);
		stck.push(3);
		stck.push(9);
		stck.push(5);
		stck.push(8);
		
		System.out.println(stck.minimum().data);
		System.out.println(stck.pop().data);
		System.out.println(stck.minimum().data);
		System.out.println(stck.pop().data);
	}

}
