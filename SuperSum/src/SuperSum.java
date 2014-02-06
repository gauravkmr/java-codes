
public class SuperSum 
{
	static int sum;
	
	void initialise(int[][] array)
	{
		for (int i = 1; i <= 3; i++) 
			array[0][i] = i;
	}
	
	int calculate(int k, int n, int[][] array)
	{
		System.out.println("k: " + k + " n: " + n);
		
		if(k == 0)
			return array[0][n];
		else
		{
			int prevsum;
			for(int i = 1; i <= n; i++)
			{
				prevsum = sum;
				System.out.println("here with i as " + i);
				if(array[k-1][i] == 0)//value not computed
				{
					sum += calculate(k-1,i,array);
					sum -= prevsum;
				}
				else//value already there
				{
					System.out.println("returning from " + (k-1) +"," + i +  "the value  " + array[k-1][i]);
					 sum += array[k-1][i];
				}
				
				
				System.out.println("sum: " + sum);
				//System.out.println("array[" + (k-1) +"][" + i + "]: " + array[k-1][i]);
			}
			System.out.println();
			//array[k-1][n] = sum-prevsum;
			return sum;
		}
	}
	
	public static void main(String[] args) 
	{
		int k = 2;
		int n = 3;
		
		int[][] array = new int[2][4];
		
		SuperSum X = new SuperSum();
		X.initialise(array);
				
		int s = X.calculate(k, n, array);
		
		System.out.println(s);

	}

}
