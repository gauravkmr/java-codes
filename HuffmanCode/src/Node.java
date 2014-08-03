public class Node 
{
	char c;
	int freq;
	Node left;
	Node right;
	
	public Node(char c, int f)
	{
		this.c = c;
		this.freq = f;
		this.left = null;
		this.right = null;
	}
}
