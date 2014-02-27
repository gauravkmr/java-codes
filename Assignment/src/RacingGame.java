import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
	static int[][] dist = new int[5][5];
	
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
	
//	public void findMinDistance(int[][] adjMatrix, int[][] weightMatrix, int startVertex, int[] flags, int[] targets)
//	{
//		int[][] minDist = new int[adjMatrix.length][adjMatrix.length];
//		
//		int min = findMin(adjMatrix, weightMatrix, 0, 1) + findMin(adjMatrix, weightMatrix, 1, 2);
//		
//	}
	
	public static void paths(int[][] adjMatrix, ArrayList<ArrayList<Integer>> finalpaths, int start, int end, int[] path, int currIndex)
	{
		for (int i = 0; i < currIndex; i++) 
		{
			if(path[i] == start)
				return;
		}
		path[currIndex++] = start;
		
		if(start == end)
		{
//			displayArray(path, currIndex);
			ArrayList<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < currIndex; i++) 
				tmp.add(path[i]);
			finalpaths.add(tmp);
		}
		else
		{
//			ArrayList<Integer> q = graph.get(start);
			for (int i = 0; i < adjMatrix.length; i++) 
			{
				if(adjMatrix[start][i] == 1)
					paths(adjMatrix, finalpaths, i, end, path, currIndex);
			}
		}
	}
	
	public static void displayArray(int []a,int length)
	{
		for(int i = 0;i < length;i++)
			System.out.print(a[i] + " ");
		System.out.print("\n");
	}
	
	public int findDistance(int s, int f, int t, int[][] adjMatrix, int[][]weightMatrix, int[] flags)
	{
		ArrayList<String> list = new ArrayList<String>();
//		list.add(s + "," + f);
//		int first = find(s, f, adjMatrix, weightMatrix, list);
		list.add(s + "," + f);
		int first = find(s, f, adjMatrix, weightMatrix, list, flags, 0);//Math.min(find(s, f, adjMatrix, weightMatrix, list), dist[0][4]);
//		System.out.println("cost: " + first);
//		list.clear();
//		list.add(f + "," + t);
//		int second = Math.min(find(f, t, adjMatrix, weightMatrix, list), dist[0][4]);
//		System.out.println("cost: " + second);
//		System.out.println("aaaa: " + dist[2][4]);
		return first;
	}
	
	public static int find(int s, int e, int[][] adjMatrix, int[][]weightMatrix, ArrayList<String> list, int[] flags, int set)
	{
		int min = 9999;
		System.out.println("\ncall: " + s + "," + e);
		System.out.println("\nsetttt: " + set);
		System.out.println(list);
		if(s == e)
		{
			if(set == 1)
				return 0;
//			else
//				return Integer.MAX_VALUE;
		}
		int tmp;
		int ret;
		if(!list.contains(s + "," + e))
			list.add(s + "," + e);
		for (int i = 0; i < weightMatrix.length; i++) 
		{
			
			if(adjMatrix[s][i] == 1)
			{
				System.out.println("################### " + s + "," + i);
				if(!list.contains(i + "," + e))
				{
					System.out.println("-------------------------" + i + "," + e);
					
//					if(set == 0)
//					{
//						
//						for (int j = 0; j < flags.length; j++) 
//						{
//							if(flags[j] == i)
//								set = 1;
//						}
//					}
					System.out.print("wt: " + weightMatrix[s][i] + ", ");
//					if(dist[i][e] == Integer.MAX_VALUE)
					if(set == 1)
						tmp = find(i, e, adjMatrix, weightMatrix, list, flags, set);
					else
					{
						int yes=0;
						for (int j = 0; j < flags.length; j++) 
						{
							if(flags[j] == i)
								yes = 1;
						}
						tmp = find(i, e, adjMatrix, weightMatrix, list, flags, yes);
					}
						list.remove(i + "," + e);
//					else
//						tmp = dist[i][e];
					System.out.println("set:" + set + "---" + i + "," + e + "find: " + tmp);
					System.out.print("wt: " + weightMatrix[s][i] + ", ");
					ret = weightMatrix[s][i] + tmp;//Math.min(tmp, dist[i][e]);
					System.out.println("return::::" + ret);
					if(ret < min && ret >= 0)
						min = ret;
					
					
				}
				else
				{
					if(i == e){
//					dist[i][e] = minDist(i, e, adjMatrix, weightMatrix);
					tmp = find(i, e, adjMatrix, weightMatrix, list, flags, set);
					ret = weightMatrix[s][i] + tmp;
//					System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ " + tmp);
					if(ret < min)
						min = ret;
					}
					if(weightMatrix[i][e] != 0 && set != 1)
					{
						ret = weightMatrix[s][i] + weightMatrix[i][e];
//						System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ " + tmp);
						if(ret < min)
							min = ret;
					}
//					System.out.println("ggggggggggggggggggggggggggggggg: " + i + "," + e);
					continue;
				}
			}
		}
		return min;
	}
	
	public static int minDist(int s, int d, int[][] adjMatrix, int[][] weightMatrix)
	{
		ArrayList<ArrayList<Integer>> finalpaths = new ArrayList<ArrayList<Integer>>();
		int[] path = new int[adjMatrix.length];
		paths(adjMatrix, finalpaths, s, d, path, 0);
		int min = Integer.MAX_VALUE;
		
		for(ArrayList<Integer> list: finalpaths)
		{	int tmp = 0;
			for (int i = 1; i < list.size(); i++) 
			{
				tmp += weightMatrix[list.get(i-1)][list.get(i)];
			}
			if(tmp<min)
				min = tmp;
		}
		
		return min;
	}
	
	public static void main(String[] args) 
	{
//		long start = System.currentTimeMillis();
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
				if(value < weightMatrix[x][y])
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
		
		int[] flags = new int[flagPoints];
		for (int i = 0; i < flagPoints; i++) 
		{
			int f = in.nextInt();
			flags[i] = f;
			game.setFlagPoint(head, f);
		}
		
		int targetPoints = in.nextInt();
		int[] targets = new int[targetPoints];
		for (int i = 0; i < targetPoints; i++) 
		{
			int t = in.nextInt();
			targets[i] = t;
			game.setTargetPoint(head, t);
		}
		
		game.display(head);
		in.close();
		
//		System.out.println("weew: " + weightMatrix[2][1]);
//		for (int i = 0; i < targets.length; i++) 
//		{
//			int min = Integer.MAX_VALUE;
//			for (int j = 0; j < flags.length; j++) 
//			{
//				game.findDistance(0, 1, 2, adjMatrix, weightMatrix);
//				if(d < min)
//					min = d;
//			}
//			System.out.println(min);
//		}
		
//		int[] path = new int[adjMatrix.length];
//		ArrayList<ArrayList<Integer>> finalpaths = new ArrayList<ArrayList<Integer>>();
//		game.paths(adjMatrix, finalpaths, 2, 1, path, 0);
		
		for (int i = 0; i < adjMatrix.length; i++) 
		{
			for (int j = 0; j < adjMatrix.length; j++) 
			{
				dist[i][j] = Integer.MAX_VALUE;	
			}
		}
		
//		for (int i = 0; i < targets.length; i++) 
//		{
//			int min = 9999;
//			for (int j = 0; j < flags.length; j++) 
//			{
				int tmp = game.findDistance(0, 0, 2, adjMatrix, weightMatrix, flags);
//				if(tmp < min)
//					min = tmp;
//			}
			System.out.println("anssssssssss: " + tmp);
//		}
//		long end = System.currentTimeMillis();
//		long elapsedTime = end - start;


//		System.out.println(elapsedTime*1.0/1000000);		
//				System.out.println("sfvsd " + minDist(0, 0, adjMatrix, weightMatrix));
	}

}
