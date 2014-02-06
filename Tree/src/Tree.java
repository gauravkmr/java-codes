import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node
{
	int data;
	Node left = null;
	Node right = null;
	
	public Node(int d)
	{
		data = d;
	}
	
	public void addNode(Node root, int d)
	{
		Node tmp = new Node(d);
		if(root == null)
			root = tmp;
		else
		{
			Node current = root;
			Node parent;
			while(current != null)
			{
				parent = current;
				if(d > current.data)
				{
					current = current.right;
					if(current == null)
					{
						parent.right = tmp;
						break;
					}
				}
				else
				{
					current = current.left;
					if(current == null)
					{
						parent.left = tmp;
						break;
					}
				}
			}
		}
	}
	
	public void display(Node head)
	{
		if(head != null)
		{
			System.out.println(head.data);
			display(head.left);
			display(head.right);
		}
	}
}

public class Tree 
{
	public static ArrayList<LinkedList<Node>> createLL(Node head)
	{
		if(head == null)
			return null;
		ArrayList<LinkedList<Node>> ll = new ArrayList<LinkedList<Node>>();
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(head);
		queue.add(new Node(-1));
		
		while(!queue.isEmpty() && queue.peek().data != -1)
		{
			LinkedList<Node> list = new LinkedList<Node>();
			Node u = queue.remove();
			
			
			while(u != null && u.data != -1 && !queue.isEmpty())
			{
//				System.out.println(u.data);
				if(u.left != null)
				{
					queue.add(u.left);
//					System.out.println(u.left.data);
				}
				if(u.right != null)
				{
					queue.add(u.right);
//					System.out.println(u.right.data);
				}
				list.add(u);
				u = queue.remove();
			}
			ll.add(list);
			queue.add(new Node(-1));
		}
		
		return ll;
	}
	
	public static void main(String[] args) 
	{
		Node head = new Node(4);
		head.addNode(head, 2);
		head.addNode(head, 6);
		head.addNode(head, 1);
		head.addNode(head, 3);
		head.addNode(head, 5);
		head.addNode(head, 7);
		head.addNode(head, 8);
		head.addNode(head, 0);
		head.addNode(head, 9);
		head.addNode(head, 10);
		
		head.display(head);
		
		ArrayList<LinkedList<Node>> lists = createLL(head);
		int i= 1;
		for (LinkedList<Node> linkedList : lists) 
		{
			System.out.println("level " + i + ":");
			for (Node node : linkedList) 
			{
				System.out.print(node.data);
				System.out.print(" ");
			}
			System.out.println();
			i++;
		}
		
//		LinkedList<Node> l = lists.get(0);
		
		
//		System.out.println(l.get(0).data);
			
		
	}

}
