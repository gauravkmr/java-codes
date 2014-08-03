import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph 
{
	public Map<Integer, List<Integer>> adj;
	public List<Node> V;
	List<Edge> allEdges;
	
	public Graph(int vertex_count)
	{
		adj = new HashMap<Integer, List<Integer>>();
		
		for (int i = 1; i <= vertex_count; i++) 
		{
			adj.put(i, new LinkedList<Integer>());
		}
		
		V = new LinkedList<Node>();
		
		for (int i = 1; i <= vertex_count; i++) 
		{
			V.add(new Node(i));
		}
		
		allEdges = new LinkedList<Edge>();
	}
	
	public void setEdgeUndirected(int src, int dest, int weight)
	{
		List<Integer> t_src = adj.remove(src);
		
		if(dest <= V.size())
			t_src.add(dest);
		
		adj.put(src, t_src);
		
		List<Integer> t_dest = adj.remove(dest);
		
		if(src <= V.size())
			t_dest.add(src);
		
		adj.put(dest, t_dest);
		
		allEdges.add(new Edge(src, dest, weight));
		allEdges.add(new Edge(dest, src, weight));
	}
	
	public void setEdgeDirected(int src, int dest, int weight)
	{
		List<Integer> t_src = adj.remove(src);
		
		if(dest <= V.size())
			t_src.add(dest);
		
		adj.put(src, t_src);
		allEdges.add(new Edge(src, dest, weight));
		
	}
	
	public List<Integer> getEdge(int src)
	{
		if(src > V.size())
		{
			System.out.println("vertex entered is not present.");
			return null;
		}
		
		return adj.get(src);
	}
	
	public void printPath(int src, int dest)
	{
		if(src == dest)
			System.out.print(src);
		else if(V.get(dest-1).getPredecessor() == null)
			System.out.println("no path exists from " + src + " to " + dest);
		else
		{
			printPath(src, V.get(dest-1).getPredecessor().getKey());
			System.out.print(" --> " + dest);
		}
	}
	
	public void displayGraph()
	{
		for (int i = 1; i <= V.size(); i++) 
		{
			System.out.print(i + " --> ");
			
//			for (int j = 0; j < adj.get(i).size(); j++) 
//			{
//				if(j == adj.get(i).size() - 1)
//					System.out.println(adj.get(i).get(j));
//				else
//					System.out.print(adj.get(i).get(j) + " --> ");
//			}
			int j = 0;
			for (Integer integer : getEdge(i)) 
			{
				j++;
				if(j == getEdge(i).size())
					System.out.print(integer);
				else
					System.out.print(integer + " --> ");
			}
			System.out.println();
		}
	}

	public List<Node> getNodes()
	{
		return V;
	}
}
