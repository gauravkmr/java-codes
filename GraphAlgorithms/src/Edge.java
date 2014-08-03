
public class Edge implements Comparable<Edge>
{
	private int vertex1;
	private int vertex2;
	private int weight;
	
	public Edge(int vertex1, int vertex2, int weight) 
	{
		super();
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}

	public int getVertex1() 
	{
		return vertex1;
	}

	public int getVertex2() 
	{
		return vertex2;
	}

	public int getWeight() 
	{
		return weight;
	}
	
	public int compareTo(Edge e)
	{
		return this.weight < e.weight? -1: 1;
	}
}
