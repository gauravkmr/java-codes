import java.util.ArrayList;

enum State
{
	Unvisited, Visited, Visiting;
}

class Node
{
	int value;
	State state;
	
	public Node(int d)
	{
		value = d;
	}
}

public class RoutebwNodes 
{
	public ArrayList<ArrayList<Node>> createGraph(int[][] adjMatrix)
	{
		ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		
		for (int i = 0; i < adjMatrix.length; i++) 
		{
			ArrayList<Node> tmp = new ArrayList<Node>();
			for (int j = 0; j < adjMatrix[0].length; j++) 
			{
				if(adjMatrix[i][j] == 1)
					tmp.add(new Node(j+1));
			}
			graph.add(tmp);
		}
		return graph;
	}
	
	
	public static void main(String[] args) 
	{
		RoutebwNodes route = new RoutebwNodes();
		
		int[][] adjMatrix = {{0,1,0,1,0},
							{0,0,1,0,1},
							{0,0,0,0,1},
							{0,0,1,0,0},
							{0,0,0,0,0}};
		
		ArrayList<ArrayList<Node>> graph = route.createGraph(adjMatrix);
				
		for (ArrayList<Node> arrayList : graph) 
		{
			for (Node node : arrayList) 
			{
				System.out.print(node.value);
			}
			System.out.println();
		}
		
		
	}

}
