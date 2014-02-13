import java.util.*;


public class SpreadingNews 
{
	public static int minTime(int[] supervisors)
	{
		int[] discoveryTime = new int[supervisors.length];
		int[] responsibilty = calculateResponsibility(supervisors);
		int minimum = 0;
		
		System.out.println("supervisor array:");
		for (int i : supervisors) 
		{
			System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.println("responsibilty array:");
		for (int i : responsibilty) 
		{
			System.out.print(i + " ");
		}
		System.out.println();
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < supervisors.length; i++) 
		{
			ArrayList<Integer> list = new  ArrayList<Integer>();
			for (int j = i+1; j < supervisors.length; j++) 
			{
				if(supervisors[j] == i)
					list.add(j);
			}
			map.put(i, list);
		}
		
//		for (int i = 0; i < supervisors.length; i++) 
//		{
//			System.out.println("children of " + i);
//			System.out.println(map.get(i));
//		}
		
		discoveryTime[0] = 0;
		for (int i = 0; i < supervisors.length; i++) 
		{
			
			ArrayList<Integer> siblings = map.get(i);
			int cnt = 1;
			while(siblings.size() != 0)
			{
				int maxIndex = -1;
				int indexVal = -1;
				int max = -1;
				for (int j = 0; j < siblings.size(); j++) 
				{
					if(responsibilty[siblings.get(j)] > max)
					{
						maxIndex = j;
						indexVal = siblings.get(j);
						max = responsibilty[siblings.get(j)];
					}
				}
				siblings.remove(maxIndex);
				discoveryTime[indexVal] = discoveryTime[i] + cnt;
				cnt++;
				if(discoveryTime[indexVal] > minimum)
					minimum = discoveryTime[indexVal];					
			}
			
		}
		
		System.out.println("discovery time:");
		for (int i : discoveryTime) 
		{
			System.out.print(i + " ");
		}
		System.out.println();
		return minimum;
	}
	
	public static int[] calculateResponsibility(int[] supervisors)
	{
		int[] responsibilty = new int[supervisors.length];
		
		for (int i = responsibilty.length - 1; i >= 0; i--) 
		{
			int count = 0;
			for (int j = i+1; j < supervisors.length; j++) 
			{
				if(supervisors[j] == i)
					count += (1 + responsibilty[j]); 
			}
			responsibilty[i] = count;
		}
		return responsibilty;
	}
	
	public static void main(String[] args) 
	{
		int[] supervisors = {-1, 0, 0, 2, 2};//{-1, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 7, 8, 12, 13, 14, 16, 16, 16};
		
		int time = minTime(supervisors);
		System.out.println("minimum time required to spread news: " + time);
	}
	
}
