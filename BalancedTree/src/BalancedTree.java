class Node
{
	int val;
	Node left = null;
	Node right = null;
	
	public Node(int d)
	{
		val = d;
	}
}

public class BalancedTree 
{
	public static void insert(Node r, int d)
	{
		if(d > r.val)
		{
			if(r.right == null)
				r.right = new Node(d);
			else
				insert(r.right, d);
		}
		else
		{
			if(r.left == null)
				r.left = new Node(d);
			else
				insert(r.left, d);
		}
	}
	
	public static void preorder(Node n)
	{
		if(n != null)
		{
			System.out.println(n.val);
			preorder(n.left);
			preorder(n.right);
		}
	}
	
	public static int maxDepth(Node root)
	{
		if(root == null)
			return 0;
		else
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	
	public static int minDepth(Node root)
	{
		if(root == null)
			return 0;
		else
			return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}
	
	public static boolean isBalanced(Node root)
	{
		return maxDepth(root)-minDepth(root) < 2; 
	}
	
	public static void main(String[] args) 
	{
		Node root = new Node(8);
		insert(root, 5);
		insert(root, 10);
		insert(root, 4);
		insert(root, 6);
		insert(root, 9);
//		insert(root, 4);
//		insert(root, 3);
//		preorder(root);
		
		if(isBalanced(root))
			System.out.println("balanaced");
		else
			System.out.println("not balanaced");
		
	}

}
