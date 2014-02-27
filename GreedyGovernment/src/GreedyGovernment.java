import java.util.*;

public class GreedyGovernment 
{
	public static double maxAverageCost(String[] tolls, int tollHike)
	{
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int[][] weight = new int[tolls.length][tolls.length];
		for (int i = 0; i < weight.length; i++) 
		{
			for (int j = 0; j < weight.length; j++) 
			{
				if(tolls[i].charAt(j) != 'X')
					weight[i][j] = tolls[i].charAt(j) - 48;
			}
		}
		
		int x = 0;
		for(String s : tolls)
		{
			ArrayList<Integer> list = new ArrayList<Integer>();
			char[] edges = s.toCharArray();
			list.add(x);
			for(int i = 0; i < edges.length; i++)
				if(edges[i] != 'X')
					list.add(i);
			graph.add(list);
			x++;
		}
		
		ArrayList<ArrayList<Integer>> finalpaths = new ArrayList<ArrayList<Integer>>();
		getPaths(graph, finalpaths);
		
		double avg = 0;
		HashMap<String, Integer> edges = new HashMap<String, Integer>();
		System.out.println("all possible paths along with their costs:");
		for (ArrayList<Integer> arrayList : finalpaths) 
		{
			for (Integer integer : arrayList) 
			{
				System.out.print(integer + " ");
			}
			int cost = 0;
			for (int i = 1; i < arrayList.size(); i++) 
			{
				cost += weight[arrayList.get(i-1)][arrayList.get(i)];

				String tmp =  String.valueOf(arrayList.get(i-1)) + "," + String.valueOf(arrayList.get(i));
				if(!edges.containsKey(tmp))
					edges.put(tmp, 0);
			}
			System.out.print("  ==>  cost: " + cost);
			System.out.println();
			avg += cost;
		}
		double initialTotalCost = avg;
		System.out.println("\ninitial average: " + avg/finalpaths.size());
		
		double maxAvg = 0;
		Set<String> keyset = edges.keySet(); 
		
//		System.out.println("weight:");
//		for (int i = 0; i < weight.length; i++) 
//		{
//			for (int j = 0; j < weight.length; j++) 
//			{
//				System.out.print(weight[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		for (String string : keyset) 
		{
			double cost = initialTotalCost;
			int p = Integer.parseInt(string.substring(0, string.indexOf(',')));
			int q = Integer.parseInt(string.substring(string.indexOf(',') + 1));
			weight[p][q] += tollHike;
			
			for (ArrayList<Integer> arrayList : finalpaths) 
			{
				for (int i = 1; i < arrayList.size(); i++) 
				{
					if(arrayList.get(i-1) == p && arrayList.get(i) == q)
						cost += tollHike;
				}
			}
			weight[p][q] -= tollHike;

			if(cost > maxAvg)
				maxAvg = cost;
		}

		return (maxAvg*1.0)/finalpaths.size();
	}
	
	public static void getPaths(ArrayList<ArrayList<Integer>> graph, ArrayList<ArrayList<Integer>> finalpaths)
	{
		int start = 0;
		int end = graph.size() - 1;
		int[] path = new int[graph.size()];
		paths(graph, finalpaths,  start, end, path, 0);		
	}
	
	public static void paths(ArrayList<ArrayList<Integer>> graph, ArrayList<ArrayList<Integer>> finalpaths, int start, int end, int[] path, int currIndex)
	{
		for (int i = 0; i < currIndex; i++) 
		{
			if(path[i] == start)
				return;
		}
		path[currIndex++] = graph.get(start).get(0);
		
		if(graph.get(start).get(0) == end)
		{
//			displayArray(path, currIndex);
			ArrayList<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < currIndex; i++) 
				tmp.add(path[i]);
			finalpaths.add(tmp);
		}
		else
		{
			ArrayList<Integer> q = graph.get(start);

			for (int i = 1; i < q.size(); i++) 
			{
				paths(graph, finalpaths, q.get(i), end, path, currIndex);
			}
		}
		
		
	}
	
	public static void displayArray(int []a,int length)
	{
		for(int i = 0;i < length;i++)
			System.out.print(a[i] + " ");
		System.out.print("\n");
	}
	
	public static void main(String[] args) 
	{
		String[] tolls = {"X324", "5X22", "12X5", "991X"};//{"X324", "XXX2", "12X5", "991X"};
		
		double cost = maxAverageCost(tolls, 57);
		System.out.println("\nmaximum avg. cost of government: " + cost);
	}

}
