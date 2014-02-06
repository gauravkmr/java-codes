import java.util.Hashtable;

class Node
{
	int data;
	Node next = null;
	
	public Node(){}
	
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
	
	public Node delete(Node head, int d)
	{
		Node temp = head;
		
		if(temp.data == d)
			return head.next;
		
		while(temp.next != null)
		{
			if(temp.next.data == d)
			{
				temp.next = temp.next.next;
				return head;
			}
			temp = temp.next;
		}
	
		return head;
	}
	
	public boolean search(int d)
	{
		Node n = this;
		while(n != null)
		{
			if(n.data == d)
				return true;
			n = n.next;
		}
		return false;
	}

//using hashtable and previous
	public Node removeDups(Node n)
	{
		Node head = n;
		Node previous = null;
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		
		while(n != null)
		{
			if(table.containsKey(n.data))
				previous.next = n.next;
			else
			{
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}
		
		return head;
	}
	
	public Node removeDups1(Node n)
	{
		Node head = n;
		Node current = n.next;
		Node previous = n;
		Node running = null;
		
		while(current != null)
		{
			running = head;
			while(running != current)
			{
				if(running.data == current.data)  //jump the current node
				{
					previous.next = current.next;
					current = current.next;
					break;
				}
				running = running.next;
			}
			
			if(running == current)
			{
				previous = current;
				current = current.next;
			}
		}
		
		return head;
	}
}

public class removeDupLL 
{
	public static void main(String[] args) 
	{
		Node oldLL = new Node(1);
		oldLL.appendToTail(2);
		oldLL.appendToTail(3);
		oldLL.appendToTail(2);
		oldLL.appendToTail(4);
		oldLL.appendToTail(1);

//making another LL
/*		Node newLL = new Node(oldLL.data);
		oldLL = oldLL.next;
		
		while(oldLL != null)
		{
			if(!newLL.search(oldLL.data))
				newLL.appendToTail(oldLL.data);
			
			oldLL = oldLL.next;
		}

		while(newLL != null)
		{
			System.out.print(newLL.data);
			System.out.print(" ");
			newLL = newLL.next;
		}
*/

//method2...using current, previous nodes and hashtable
/*		Node  newLL = oldLL.removeDups(oldLL);
		
		while(newLL != null)
		{
			System.out.print(newLL.data);
			System.out.print(" ");			
			newLL = newLL.next;
		}
*/		
//method3.....using current, previous and running nodes
		Node  newLL = oldLL.removeDups1(oldLL);
		
		while(newLL != null)
		{
			System.out.print(newLL.data);
			System.out.print(" ");			
			newLL = newLL.next;
		}
	}
}
