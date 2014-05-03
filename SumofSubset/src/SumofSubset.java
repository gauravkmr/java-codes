
public class SumofSubset 
{
	public static void findSubsets(int[] A, int i, int[] s, int curr, int sum)
	{
		if(i == A.length)
			return;
		if(sum == 0)
			displayArray(s, curr);
		
		s[curr] = A[i];
		curr++;
		sum += A[i];
		findSubsets(A, i+1, s, curr, sum);
		curr--;
		sum -= A[i];
		findSubsets(A, i+1, s, curr, sum);
	}
	
	public static void displayArray(int[] s, int curr)
	{
		for (int i = 0; i <= curr; i++) 
		{
			System.out.print(s[i] + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		int[] A = {2, 1, -1, 0, 2, -1, -1};
		int[] s = new int[A.length];
		
		findSubsets(A, 0, s, 0, -1);
	}

}
