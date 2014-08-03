import java.util.HashSet;
import java.util.TreeSet;
import java.util.Vector;


public class Kruskal 
{
	private TreeSet<Edge> MSTedges;
	private Vector<HashSet<Integer>> vertexGroups;
	
	public Kruskal() 
	{
		super();
		MSTedges = new TreeSet<Edge>();
		vertexGroups = new Vector<HashSet<Integer>>();
	}
	
	public TreeSet<Edge> getEdges()
	{
		return MSTedges;
	}
	
	public HashSet<Integer> getGroup(int v)
	{
		for (HashSet<Integer> set : vertexGroups) 
		{
			if(set.contains(v))
				return set;
		}
		return null;
	}
	
	public void insertEdge(Edge e)
	{
		int v1 = e.getVertex1();
		int v2 = e.getVertex2();
		
		//get the group v1 belongs to
		HashSet<Integer> g1 = getGroup(v1);
		//get the group v2 belongs to
		HashSet<Integer> g2 = getGroup(v2);
		
		
		//when both v1 and v2 doesnot belong to any group
		if(g1 == null && g2 == null)
		{
			HashSet<Integer> temp = new HashSet<Integer>();
			temp.add(v1);
			temp.add(v2);
			vertexGroups.add(temp);
			MSTedges.add(e);
		}
		//when v1 belongs to a group but v2 doesnot
		else if(g1 != null && g2 == null)
		{
			g1.add(v2);
			MSTedges.add(e);
		}
		//when v2 belongs to a group but v1 doesnot
		else if(g1 == null && g2 != null)
		{
			g2.add(v1);
			MSTedges.add(e);
		}
		//both v1 and v2 belongs to different groups
		else if(g1 != g2)
		{
			g1.addAll(g2);
			vertexGroups.remove(g2);
			MSTedges.add(e);
		}
	}
	
}
