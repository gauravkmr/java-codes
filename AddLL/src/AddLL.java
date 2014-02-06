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
	
	public Node add(Node num2)
	{
		Node num1 = this;
		if(num2 == null)
			return num1;
		
		int val = (num1.data + num2.data)%10;
		int carry = (num1.data + num2.data)/10;
		Node sum = new Node(val);
		num1 = num1.next;
		num2 = num2.next;
		
		while(num1 != null && num2 != null)
		{
			val = (num1.data + num2.data + carry)%10;
			carry = (num1.data + num2.data + carry)/10;
			sum.appendToTail(val);
			num1 = num1.next;
			num2 = num2.next;
		}
		while(num1 != null)
		{
			val = (num1.data + carry)%10;
			carry = (num1.data + carry)/10;
			sum.appendToTail(val);
			num1 = num1.next;
		}
		while(num2 != null)
		{
			val = (num2.data + carry)%10;
			carry = (num2.data + carry)%10;
			sum.appendToTail(val);
			num2 = num2.next;
		}
		return sum;
	}
}

public class AddLL 
{
	public static void main(String[] args) 
	{
		Node num1 = new Node(3);
		num1.appendToTail(1);
		num1.appendToTail(5);
		num1.appendToTail(8);

		Node num2 = new Node(5);
		num2.appendToTail(9);
		num2.appendToTail(2);
		
		Node sum = num1.add(num2);
		
		while(sum != null)
		{
			System.out.print(sum.data);
			System.out.print(" ");
			sum = sum.next;
		}
	}

}
