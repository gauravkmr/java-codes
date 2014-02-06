import java.util.ArrayList;


public class SubsetsofSet 
{
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index)
	{
		ArrayList<ArrayList<Integer>> allsubsets;
		
		if(set.size() == index)
		{
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}
		else
		{
			allsubsets = getSubsets(set, index+1);
			int element = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> arrayList : allsubsets) 
			{
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(arrayList);
				newsubset.add(element);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
	
	public static void main(String[] args) 
	{
//		ArrayList<ArrayList<Integer>> set = new ArrayList<ArrayList<Integer>>();
//		ArrayList<ArrayList<Integer>> sets1 = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		
		ArrayList<ArrayList<Integer>> subsets = getSubsets(set, 0);
		
		for (ArrayList<Integer> list : subsets) 
		{
			for (Integer integer : list) 
			{
				System.out.print(integer.intValue());
				System.out.print(" ");
			}
			System.out.println();
		}
		
		
/*		
		sets.add(set1);
		sets.add(set2);
		
		for (ArrayList<Integer> list : sets) 
		{
			list.add(5);
			sets1.add(list);
		}
		
		for (ArrayList<Integer> list : sets1) 
		{
			
			sets.add(list);
		}
		
		for (ArrayList<Integer> list : sets1) 
		{
			for (Integer integer : list) 
			{
				System.out.print(integer.intValue());
				System.out.print(" ");
			}
			System.out.println();
		}
*/		
	}

}
