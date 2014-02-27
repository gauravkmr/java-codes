
public class TreePlanting 
{
	public static long countArrangements(int total, int fancy)
	{
		long[][] array = new long[total][fancy];
		
		return findArrangement(total, fancy, array);
	}
	
	public static long findArrangement(int total, int fancy, long[][] array)
	{
		if(total < fancy)
			return 0;
		if(fancy > (total+1)/2)
			return 0;
		if(fancy == 1)
			return total;
		else
		{
			if(array[total-3][fancy-2] == 0)
				array[total-3][fancy-2] = findArrangement(total - 2, fancy - 1, array);
			if(array[total-2][fancy-1] == 0)
				array[total-2][fancy-1] = findArrangement(total - 1, fancy, array);
			
			return array[total-3][fancy-2] + array[total-2][fancy-1];
		}
	}
	
	public static void main(String[] args) 
	{
		System.out.println("total number of arrangements: " + countArrangements(10, 4));
	}

}
