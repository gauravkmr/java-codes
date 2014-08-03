import java.util.LinkedList;
import java.util.List;

public class Node implements Comparable<Node>
{
	private int key;
	private int dist;
	private Node predecessor;
	private State state;
	private int discovery_time;
	private int finish_time;
	private int prim_key;                              //for Prim algorithm
	private List<Node> adjlist;                        //for Prim algorithm
	
	public Node(int k)
	{
		key = k;
		dist = Integer.MAX_VALUE;
		predecessor = null;
		state = State.unvisited;
		discovery_time = 0;
		finish_time = 0;
		prim_key = Integer.MAX_VALUE;
		adjlist = new LinkedList<Node>();
	}
	
	public int getKey() 
	{
		return key;
	}

	public void setKey(int key) 
	{
		this.key = key;
	}

	public List<Node> getAdjlist() 
	{
		return adjlist;
	}

	public void setAdjlist(List<Node> adjlist) 
	{
		this.adjlist = adjlist;
	}

	public int getDist() 
	{
		return dist;
	}

	public void setDist(int dist) 
	{
		this.dist = dist;
	}

	public Node getPredecessor() 
	{
		return predecessor;
	}

	public void setPredecessor(Node predecessor) 
	{
		this.predecessor = predecessor;
	}

	public State getState() 
	{
		return state;
	}

	public void setState(State state) 
	{
		this.state = state;
	}
	
	public int getDiscoveryTime() 
	{
		return discovery_time;
	}

	public void setDiscoveryTime(int d) 
	{
		this.discovery_time = d;
	}

	public int getFinishTime() 
	{
		return finish_time;
	}

	public void setFinishTime(int f) 
	{
		this.finish_time = f;
	}

	public int getPrim_key() 
	{
		return prim_key;
	}

	public void setPrim_key(int prim_key) 
	{
		this.prim_key = prim_key;
	}
			
	public int compareTo(Node n)
	{
		return this.prim_key < n.prim_key? -1: 1;
	}
}
