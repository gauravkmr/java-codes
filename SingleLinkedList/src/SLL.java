
public class SLL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SLL obj = new SLL();
		Node head = new Node(1);
		Node a = new Node(2);
		Node b = new Node(3);
		Node c = new Node(4);
		
		head.next = a;
		a.next = b;
		b.next = c;
		
		obj.displayList(head);
	}
	
	public void displayList(Node head) 
	{	
		for (Node current = head; current != null; current = current.next) 
		{
			if(current.next != null)
				System.out.print(current.data + "->");
			else
				System.out.print(current.data);
		}
	}

}
