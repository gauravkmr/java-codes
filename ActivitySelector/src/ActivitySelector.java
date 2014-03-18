import java.util.ArrayList;

public class ActivitySelector 
{
	
	public ArrayList<Integer> greedy_activity_selector(int[] s, int[] f)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		
		int k = 1;
		
		for (int m = 2; m <= s.length; m++) 
		{
			if(s[m-1] >= f[k-1] )
			{
				list.add(m);
				k = m;
			}
		}
		
		return list;
		
	}
	
	public void recursive_activity_selector(int[] s, int[] f, int k, int n, ArrayList<Integer> list)
	{
		
		int m = k+1;
		
		while(m <= n && s[m-1] < f[k-1])
		{
			m++;
		}
		
		if(m <= n)
		{
			list.add(m);
			recursive_activity_selector(s, f, m, n, list);
			
		}
		
		return;
	}
	
	public static void main(String[] args) 
	{
		ActivitySelector selector = new ActivitySelector();
		
		int[] start = {1,3,0,5,3,5,6,8,8,2,12};
		int[] finish = {4,5,6,7,9,9,10,11,12,14};
		
		ArrayList<Integer> orderGre = selector.greedy_activity_selector(start, finish);
		
		ArrayList<Integer> orderRec = new ArrayList<Integer>(); 
		orderRec.add(1);
		selector.recursive_activity_selector(start, finish, 1, start.length, orderRec);
		
		
		System.out.println("activity order greedy: " + orderGre);
		System.out.println("activity order recursive: " + orderRec);

	}

}
