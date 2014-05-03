
public class RotatedArraySearch 
{
	public static int search(int[] array, int l, int u, int k)
	{
		while(l <= u)
		{
			int m = (l+u)/2;
			
			if(k == array[m])
				return m;
			else if(array[l] <= array[m])
			{
				if(k > array[m])
					l = m + 1;
				else if(k >= array[l])
					u = m - 1;
				else
					l = m + 1;
			}
			else if(k < array[m])
				u = m - 1;
			else if(k <= array[u])
				l = m + 1;
			else
				u = m - 1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) 
	{
		int[] array = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		
		System.out.println(search(array, 0, array.length - 1, 20));
	}

}
