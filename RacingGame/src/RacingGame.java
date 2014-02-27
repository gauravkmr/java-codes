import java.util.Scanner;

class Vertex
{
	int name;
	Vertex next = null;
	Vertex previous = null;
	Edge link = null;
	boolean isFlag;
	boolean isTarget;
		
	public Vertex(int d)
	{
		name = d;
		isFlag = false;
		isTarget = false;
	}
}

class Edge
{
	int name;
	int weight;
	Edge next = null;
	Edge previous = null;
	
	public Edge(int n, int w)
	{
		name = n;
		weight = w;
	}
}

public class RacingGame 
{
//	public Vertex createVertices(int v)
//	{
//		if(v == 0)
//			return null;
//		
//		Vertex head = new Vertex(0);
//		for (int i = 1; i < v; i++) 
//			addVertex(head, i);
//		return head;
//	}
	
//	public void addEdges(Vertex head, int x, int y, int weight)
//	{
//		Vertex run = head;
//		while(run.name != x)
//		{
//			run = run.next;
//		}
//		
//		run.link = addEdge(run.link, y, weight);
//		
//	}
	
//	public Edge addEdge(Edge edge, int y, int value)
//	{
//		Edge tmp = new Edge(y, value);
//		if(edge == null)
//			edge = tmp;
//		else
//		{
//			Edge run = edge;
//			while(run.next != null)
//			{
//				run = run.next;
//			}
//			run.next = tmp;
//			tmp.previous = run;
//		}
//		return edge;
//	}
	
	public void addVertex(Vertex head, int d)
	{
		Vertex run = head;
		Vertex tmp = new Vertex(d);
		while(run.next != null)
		{
			run = run.next;
		}
		run.next = tmp;
		tmp.previous = run;
	}
	
	public void addEdge(Edge head, int d, int w)
	{
		Edge run = head;
		Edge tmp = new Edge(d, w);
		while(run.next != null)
		{
			run = run.next;
		}
		run.next = tmp;
		tmp.previous = run;
	}
	
	public Vertex createGraph(int[][] adjMatrix, int[][] weightMatrix, int nodecount)
	{
		if(nodecount == 0)
			return null;
		
		Vertex head = new Vertex(0);
		for (int i = 1; i < nodecount; i++) 
		{
			addVertex(head, i);
		}
		
		Vertex run = head;
		for (int i = 0; i < nodecount; i++) 
		{
			Edge edge = new Edge(-1, -1);
			for (int j = 0; j < nodecount; j++) 
			{
				if(adjMatrix[i][j] == 1)
					addEdge(edge,j, weightMatrix[i][j]);
			}
			if(edge.next != null)
				run.link = edge.next;
			
			run = run.next;
		}
		
		return head;
	}
	
	public void setFlagPoint(Vertex head, int f)
	{
		Vertex run = head;
		while(run.name != f)
		{
			run = run.next;
		}
		run.isFlag = true;
	}
	
	public void setTargetPoint(Vertex head, int t)
	{
		Vertex run = head;
		while(run.name != t)
		{
			run = run.next;
		}
		run.isTarget = true;
	}
	
	public void display(Vertex head)
	{
		System.out.println("graph:");
		while(head != null)
		{
			System.out.print(head.name);
			System.out.print(" --> ");
			Edge tmp = head.link;
			while(tmp != null)
			{
				System.out.print(tmp.name);
				System.out.print(" ");
				tmp = tmp.next;
			}
			System.out.println();
			head = head.next;
		}
	}
	
	public static void main(String[] args) 
	{
		RacingGame game = new RacingGame();
		
		System.out.println("Fill in the input(in suggested format):");
		Scanner in = new Scanner(System.in);
		
		int vertices = in.nextInt();
		int edges = in.nextInt();
		int flagPoints = in.nextInt();
		int startVertex = in.nextInt();
		
//		Vertex head = game.createVertices(vertices);
				
		int[][] adjMatrix = new int[vertices][vertices];
		int[][] weightMatrix = new int[vertices][vertices];
					
		for(int i = 0; i < edges; i++)
		{
			int x = in.nextInt();
			int y = in.nextInt();
			int value = in.nextInt();
			
			if(adjMatrix[x][y] == 1)
			{
				if(value > weightMatrix[x][y])
					weightMatrix[x][y] = value; 
			}
			else
			{
				adjMatrix[x][y] = 1;
				weightMatrix[x][y] = value;
			}
			
//			game.addEdges(head, x, y, value);
		}
		
		Vertex head = game.createGraph(adjMatrix, weightMatrix, vertices);
		
		for (int i = 0; i < flagPoints; i++) 
		{
			int f = in.nextInt();
			game.setFlagPoint(head, f);
		}
		
		int targetPoints = in.nextInt();
		for (int i = 0; i < targetPoints; i++) 
		{
			int t = in.nextInt();
			game.setTargetPoint(head, t);
		}
		
		game.display(head);
		in.close();
		
		
		
		
	}

}
