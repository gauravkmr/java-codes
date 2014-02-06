
class Node
{
	int data;
	Node left = null;
	Node right = null;
	
	public Node(int d)
	{
		data = d;
	}
}

public class createTree 
{
	public Node createBalancedTree(int[] A, int start, int end)
	{
		
		if(end < start)
			return null;
		int mid = (start+end)/2;
//		System.out.println(mid);
		Node root = new Node(A[mid]);
//		System.out.println(root.data);
		root.left = createBalancedTree(A, start, mid-1);
		root.right = createBalancedTree(A, mid+1, end);
		
		return root;
	}
	
	public void display(Node root)
	{
		if(root != null)
		{
			System.out.println(root.data);
			display(root.left);
			display(root.right);
		}
	}
	
	public static void main(String[] args) 
	{
		createTree tree = new createTree();
		int[] A = {1,2,3,4,5,6,7,8};
		
		Node root = tree.createBalancedTree(A, 0 , A.length-1);
		
		tree.display(root);
		
	}

}
