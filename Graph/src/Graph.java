import java.util.*;

enum State
{
	Unvisited, Visiting, Visited;
}

class Edge
{
	int e_value;
	Edge next = null;
	Edge previous = null;
	
	public Edge(int d)
	{
		e_value = d;
	}
	
	public void addEdge(Edge head, int d)
	{
		Edge run = head;
		Edge tmp = new Edge(d);
		while(run.next != null)
		{
			run = run.next;
		}
		run.next = tmp;
		tmp.previous = run;
	}
}

class Vertex
{
	int v_value;
	State state;
	Vertex next = null;
	Vertex previous = null;
	Edge link = null;
	
	public Vertex(int d)
	{
		v_value = d;
		state = State.Unvisited;
	}
	
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
	
	
}

class GraphADT
{
	public Vertex createGraph(int[][] adjMatrix, int nodecount)
	{
		if(nodecount == 0)
			return null;
		
		Vertex head = new Vertex(1);
		for (int i = 1; i < nodecount; i++) 
		{
			head.addVertex(head, i+1);
		}
		
		Vertex run = head;
		for (int i = 0; i < nodecount; i++) 
		{
			Edge edge = new Edge(-1);
			for (int j = 0; j < nodecount; j++) 
			{
				if(adjMatrix[i][j] == 1)
					edge.addEdge(edge,j+1);
			}
			if(edge.next != null)
				run.link = edge.next;
			
			run = run.next;
		}
		
		return head;
	}
	
	public void display(Vertex head)
	{
		while(head != null)
		{
			System.out.print(head.v_value);
			System.out.print(" --> ");
			Edge tmp = head.link;
			while(tmp != null)
			{
				System.out.print(tmp.e_value);
				System.out.print("\t");
				tmp = tmp.next;
			}
			System.out.println();
			head = head.next;
		}
	}
	
	public boolean isPath(Vertex head, int s, int e)
	{
		if(s == e)
			return true;
		
		Queue<Vertex> queue = new LinkedList<Vertex>();
		
		Vertex tmp = head;
		while(tmp != null)
		{
			if(tmp.v_value == s)
			{
				queue.add(tmp);
				break;
			}
			tmp = tmp.next;
		}
		tmp = head;
		
		while(!queue.isEmpty())
		{
			Vertex u = queue.remove();
			Edge edge = u.link; 
			while(edge != null)
			{
				while(tmp != null)
				{
					if(tmp.v_value == edge.e_value)
					{
						if(tmp.state == State.Unvisited)
						{
							if(tmp.v_value == e)
								return true;
							else
							{
								tmp.state = State.Visiting;
								queue.add(tmp);
							}
						}
						break;
					}
					tmp = tmp.next;
				}
				tmp = head;
				edge = edge.next;
			}
			u.state = State.Visited;
			
		}
		return false;
	}
}

public class Graph 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int nodecount = scan.nextInt();
		
		int[][] adjMatrix = new int[nodecount][nodecount];

		//input adjacdency matrix
		for (int i = 0; i < nodecount; i++) 
		{
			System.out.println("Vertex: " + (i+1));
			for (int j = 0; j < nodecount; j++) 
			{
				int input = scan.nextInt();
				adjMatrix[i][j] = input;
			}
		}
		
		//display adjacency matrix
/*		for (int i = 0; i < nodecount; i++) 
		{
			System.out.print("Vertex " + (i+1) + ": ");
			for (int j = 0; j < nodecount; j++) 
			{
				System.out.print(adjMatrix[i][j]);
				System.out.print(", ");
			}
			System.out.println();
		}
*/		
		scan.close();
		
		GraphADT graph = new GraphADT();
		Vertex head = graph.createGraph(adjMatrix, nodecount);
		graph.display(head);
		
		if(graph.isPath(head, 5, 1))
			System.out.println("path exists.");
		else
			System.out.println("path doesn't exist.");
	}
}
