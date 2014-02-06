
public class RemoveTask {

	static void remove(int[] a)
	{
		int i = 0, j = 1;
		
		while (j <= (a.length - 1)) 
		{
			if (a[i] != a[j]) 
			{
				System.out.print(a[i]);
				i = j;
			}
			j++;
		}
		System.out.print(a[j-1]);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] array = {1,2,2,3,3};
		
		remove(array);
	}

}
