import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class GraphAlgorithms 
{
	static int time = 0;
	
	public void BFS(Graph G, int s)
	{
		G.V.get(s-1).setState(State.discovered);
		G.V.get(s-1).setDist(0);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		
		while(!queue.isEmpty())
		{
			int u = queue.remove();
			
			for (Integer v : G.getEdge(u)) 
			{
				Node node = G.V.get(v-1);
				if(node.getState() == State.unvisited)
				{
					node.setState(State.discovered);
					node.setDist(G.V.get(u-1).getDist() + 1);
					node.setPredecessor(G.V.get(u-1));
					queue.add(v);
				}
			}
			
			G.V.get(u-1).setState(State.visited);
		}
		
	}

	public void DFS(Graph G)
	{
		for (Node u : G.V) 
		{
			if(u.getState() == State.unvisited)
				DFS_Visit(G, u);
		}
	}
	
	public void DFS_Visit(Graph G, Node u)
	{
		time++;
		u.setDiscoveryTime(time);
		u.setState(State.discovered);
		
		for (Integer v : G.getEdge(u.getKey())) 
		{
			Node node = G.V.get(v-1);
			if(node.getState() == State.unvisited)
			{
				node.setPredecessor(u);
				DFS_Visit(G, node);
			}
		}
		
		u.setState(State.visited);
		time++;
		u.setFinishTime(time);
	}

	public void Topo_DFS(Graph G, SinglyLL tlist)
	{
		for (Node u : G.V) 
		{
			if(u.getState() == State.unvisited)
				Topo_DFS_Visit(G, u, tlist);
		}
	}
	
	public void Topo_DFS_Visit(Graph G, Node u, SinglyLL tlist)
	{
		time++;
		u.setDiscoveryTime(time);
		u.setState(State.discovered);
		
		for (Integer v : G.getEdge(u.getKey())) 
		{
			Node node = G.V.get(v-1);
			if(node.getState() == State.unvisited)
			{
				node.setPredecessor(u);
				Topo_DFS_Visit(G, node, tlist);
			}
		}
		
		u.setState(State.visited);
		time++;
		u.setFinishTime(time);
		tlist.insert_front(new LL_Node(u));
	}

	public SinglyLL Topological_Sort(Graph G)
	{
		SinglyLL tlist = new SinglyLL();
		Topo_DFS(G, tlist);
		return tlist;
	}
	
	public void displayTopoList(SinglyLL topo_list)
	{
		while(topo_list.head.getNext() != null)
		{
			System.out.print(topo_list.head.getNode().getKey() + " --> ");
			topo_list.head = topo_list.head.getNext();
		}
		System.out.println(topo_list.head.getNode().getKey());
	}
	
	public void stronglyConnectedComponents(Graph G)
	{
		SinglyLL ll = Topological_Sort(G);
		Graph G_new = graphTranspose(G);

		DFS_SCC(G_new, ll);
	}
	
	public Graph graphTranspose(Graph G)
	{
//		int size = G.V.size();
//		Graph G_new = new Graph(size);
//		
//		for (int i = 1; i <= size; i++) 
//		{
//			List<Integer> list = G.adj.get(i);
//			for (Integer j : list) 
//			{
//				G_new.setEdgeDirected(j, i);
//			}
//		}
		
		int size = G.V.size();
		Graph G_new = new Graph(size);
		
		for (Edge edge : G.allEdges) 
		{
			G_new.setEdgeDirected(edge.getVertex2(), edge.getVertex1(), edge.getWeight());
		}
		
		return G_new;
	}
	
	public void DFS_SCC(Graph G, SinglyLL ll)
	{
		time = 0;
		
		while(ll.head != null)
		{
			int key = ll.head.getNode().getKey();
			if(G.V.get(key-1).getState() == State.unvisited)
			{
				DFS_Visit_SCC(G, G.V.get(key-1));
				System.out.println();
			}
			ll.head = ll.head.getNext();
		}
	}
	
	public void DFS_Visit_SCC(Graph G, Node u)
	{
		time++;
		u.setDiscoveryTime(time);
		u.setState(State.discovered);
		
		for (Integer v : G.getEdge(u.getKey())) 
		{
			Node node = G.V.get(v-1);
			if(node.getState() == State.unvisited)
			{
				node.setPredecessor(u);
				DFS_Visit_SCC(G, node);
			}
		}
		
		u.setState(State.visited);
		time++;
		u.setFinishTime(time);
		System.out.print(u.getKey() + " ");
	}
	
	public void KruskalMain(TreeSet<Edge> allEdges)
	{
		Kruskal kruskal = new Kruskal();
		
		for (Edge edge : allEdges) 
		{
//			System.out.println(edge.getVertex1() + ", " + edge.getVertex2() + ", " + edge.getWeight());
			kruskal.insertEdge(edge);
		}
		
		//edges in the tree formed after kruskal
		for (Edge edge : kruskal.getEdges()) 
		{
			System.out.println(edge.getVertex1() + ", " + edge.getVertex2() + ", " + edge.getWeight());
		}
	}
	
	public void PrimMain(Graph G, HashMap<String, Integer> w, int start)
	{
		List<Node> v_list = G.getNodes();
		
		System.out.println("aaaaaaaaaaaa" + v_list.size());
		int vtx = 1;
		for (Node node : v_list) 
		{
			List<Integer> e_list = G.adj.get(vtx++);
			System.out.println("bbbbb" + e_list.size());
			for (Integer integer : e_list) 
			{
				node.getAdjlist().add(v_list.get(integer-1));
			}
		}
		
		Node r = v_list.get(start-1);
		r.setPrim_key(0);
		
		MinPrioQueue Q = new MinPrioQueue();
		Q.buildMinHeap(G.V);
		System.out.println("size" + Q.getHeapsize());
		System.out.println(w);
			
		while(Q.getHeapsize() > 0)
		{
			System.out.println("qqqqqqqqqqqqqq");
			Node u = Q.heapExtractMin();
			System.out.println("yay" + Q.getHeapsize() + ", key: " + u.getKey() + ", " + u.getAdjlist().size());
			for (Node v : u.getAdjlist()) 
			{
				System.out.println("zzzzzzz" + v.getKey());
				if(Q.getMinheap().contains(v) && w.get(u.getKey() + "," + v.getKey()) < v.getPrim_key())
				{
					System.out.println("vvvvv");
					v.setPrim_key(w.get(u.getKey() + "," + v.getKey()));
					v.setPredecessor(u);
				}
				Q.heapify();
				for (Node node : Q.getMinheap()) 
				{
					System.out.println(node.getKey() + ", " + node.getPrim_key());
				}
			}
			
			System.out.println("ccccccc" + u.getKey());
		}
		for (Node node : v_list) 
		{
			if(node.getPredecessor() != null)
				System.out.println(node.getKey() + ", " + node.getPredecessor().getKey());
		}	
		
	}
	
	public boolean BellmanFord(Graph G, HashMap<String, Integer> w, int start)
	{
		G.V.get(start-1).setDist(0);
		
		for (int i = 1; i <= G.V.size() - 1; i++) 
		{
			for (Edge edge : G.allEdges) 
			{
				relax(G.V.get(edge.getVertex1()-1), G.V.get(edge.getVertex2()-1), w);
			}
		}
		
		for (Edge edge : G.allEdges) 
		{
			Node u = G.V.get(edge.getVertex1() - 1);
			Node v = G.V.get(edge.getVertex2() - 1);
			
			if(v.getDist() >  u.getDist() + w.get(u.getKey() + "," + v.getKey()))
				return false;
		}
		
		for (Node n : G.V) 
		{
			if(n.getPredecessor() == null)
				System.out.println(n.getKey() + " -- base");
			else
				System.out.println(n.getKey() + " -- " + n.getPredecessor().getKey());
		}
		
		return true;
	}
	
	public void relax(Node u, Node v, HashMap<String, Integer> w)
	{
		if(u.getDist() != Integer.MAX_VALUE)
		{
			if(v.getDist() > ( u.getDist() + w.get(u.getKey() + "," + v.getKey()) ) )
			{
				v.setDist(u.getDist() + w.get(u.getKey() + "," + v.getKey()));
				v.setPredecessor(u);
			}
		}
	}
		
	public static void main(String[] args) 
	{		
		Scanner scan =  new Scanner(System.in);
		
		System.out.println("enter the number of vertices: ");
		int vertex_count = scan.nextInt();
		
		System.out.println("enter the number of edges: ");
		int edge_count = scan.nextInt();
		
		Graph graph = new Graph(vertex_count);
		
//for kruskal algorithm
		TreeSet<Edge> allEdges = new TreeSet<>();

//for prim algorithm
//		TreeSet<Node> allNodes = new TreeSet<>();
//		allNodes.addAll(graph.getNodes());
		HashMap<String, Integer> w = new HashMap<String, Integer>();
		
		System.out.println("enter the edges: <src> <dest>");
		for (int i = 1; i <= edge_count; i++) 
		{
			int src = scan.nextInt();
			int dest = scan.nextInt();
			int weight = scan.nextInt();
			
			w.put(src + "," + dest, weight);
//			w.put(dest + "," + src, weight);
			graph.setEdgeDirected(src, dest, weight);
			allEdges.add(new Edge(src, dest, weight));
		}
		
		scan.close();
		graph.displayGraph();
		
		GraphAlgorithms algorithms = new GraphAlgorithms();
//BFS
//		algorithms.BFS(graph, 2);
//		graph.printPath(2, 4);

//DFS
//		algorithms.DFS(graph);

//TOPOLOGICAL SORT
//		SinglyLL topo_list = algorithms.Topological_Sort(graph);
//		algorithms.displayTopoList(topo_list);
				
//STRONGLY CONNECTED COMPONENSTS
//		algorithms.stronglyConnectedComponents(graph);

//KRUSKAL ALGORITHM - MINIMUM SPANNING TREE
//		algorithms.KruskalMain(allEdges);

//PRIM ALGORITHM - MINIMUM SPANNING TREE
//		algorithms.PrimMain(graph, w, 1);		
	
//BELLMAN FORD ALGORITHM - SINGLE SOURCE SHORTEST PATH
		algorithms.BellmanFord(graph, w, 1);
		
//		for (int i = 0; i < vertex_count; i++) 
//		{
//			System.out.println(graph.V.get(i).getState() + ", " + graph.V.get(i).getDiscoveryTime() + ", " + graph.V.get(i).getFinishTime());
//		}

	}

}
