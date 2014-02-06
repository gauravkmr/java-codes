
public class NumberOfFiboCalls 
{
	static int count=0;
		
	void initialise(int[] array)
	{
		array[0] = 0;
		array[1] = 1;
	}
	
//	int fibonacci(int n)
//	{
//		count++;
//		if(n==0)
//			return 0;
//		else if(n==1)
//			return 1;
//		else
//			return fibonacci(n-1) + fibonacci(n-2);
//	}
//	

	int fibonacci(int n, int[] array)
	{
		count++;
		if(n==0)
		{
			return array[0];
		}
		else if(n==1)
		{
			return array[1];
		}
		else
		{
			if(array[n-1] == 0)
				array[n-1] = fibonacci(n-1, array);
			if(array[n-2] == 0)
				array[n-2] = fibonacci(n-2, array);
			
			return array[n-1] + array[n-2];
		}
	}
	
	public static void main(String[] args) 
	{
		NumberOfFiboCalls X = new NumberOfFiboCalls();
		int[] array = new int[12];
		
		X.initialise(array);
		int n = X.fibonacci(12, array);
		
		System.out.println(n);
		
	}

}
