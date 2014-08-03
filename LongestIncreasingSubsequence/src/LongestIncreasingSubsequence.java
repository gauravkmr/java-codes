
public class LongestIncreasingSubsequence 
{
	public static int LongestIncreasingSubsequenceLength(int[] A, int  n)
	{
		int[] tailtable = new int[n];
		int len;
		
		tailtable[0] = A[0];
		len = 1;
		
		for (int i = 1; i < n; i++) 
		{
			if(A[i] < tailtable[0])
				tailtable[0] = A[i];
			if(A[i] > tailtable[len-1])
				tailtable[len++] = A[i];
			else
				tailtable[CeilIndex(tailtable, -1, len-1, A[i])] = A[i];
		}
		
		return len;
	}
	
	public static int CeilIndex(int[] A, int l, int r, int key)
	{
		int m;
		while(r-l > 1)
		{
			m = l + (r-l)/2;
			if(A[m] >= key)
				r = m;
			else
				l = m;
		}
		return r;
	}
	
	public static int PrintLongestIncreasingSubsequence(int[] A, int  n)
	{
		int[] tailIndices = new int[n];
		int[] prevIndices = new int[n];
		
		tailIndices[0] = 0;
		prevIndices[0] = -1;
		int len = 1;
		
		for (int i = 1; i < n; i++) 
		{
			if(A[i] < A[tailIndices[0]])
				tailIndices[0] = i;
			if(A[i] > A[tailIndices[len-1]])
			{
				prevIndices[i] = tailIndices[len-1];
				tailIndices[len++] = i;
			}
			else
			{
				int p = getCeilIndex(A, tailIndices, -1, len-1, A[i]);
				prevIndices[i] = tailIndices[p-1];
				tailIndices[p] = i;
			}
		}
		
		for (int i = tailIndices[len-1]; i >= 0; i = prevIndices[i])
			System.out.print(A[i] + " ");
		System.out.println();
		
		return len;
	}
	
	public static int getCeilIndex(int[] A, int[] T, int l, int r, int key)
	{
		int m;
		while(r-l > 1)
		{
			m = l + (r-l)/2;
			if(A[T[m]] >= key)
				r = m;
			else
				l = m;
		}
		return r;
	}
	
	public static void main(String[] args) 
	{
		int[] A = { 1, 2, 9, 4, 7, 3, 11, 8, 14, 6};
	    int n = A.length;
	 
//	    System.out.println("Length of Longest Increasing Subsequence is " + LongestIncreasingSubsequenceLength(A, n));
	    System.out.println("Length of Longest Increasing Subsequence is " + PrintLongestIncreasingSubsequence(A, n));
	}

}
