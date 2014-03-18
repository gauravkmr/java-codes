
public class MatrixChain 
{
	public int count;
	
	//normal recursion
/*	public int recursiveMatrixChain(int[] p, int[][] m, int i, int j)
	{
		count++;
		if(i == j)
			return 0;
		
		m[i-1][j-1] = 99999999;
		
		for (int k = i; k < j; k++)
		{
			int q = recursiveMatrixChain(p, m, i, k) +
					recursiveMatrixChain(p, m, k+1, j) +
					p[i-1]*p[k]*p[j];
			
			if(q < m[i-1][j-1])
				m[i-1][j-1] = q;
		}
		
		return m[i-1][j-1];
	}
*/

	//dynamic programming
	public int recursiveMatrixChain(int[] p, int[][] m,int[][] arr, int i, int j)
	{
		count++;
		if(i == j)
			return 0;
		
		m[i-1][j-1] = 99999999;
		
		for (int k = i; k < j; k++)
		{
			if(arr[i-1][k-1] == -1)
			{
				arr[i-1][k-1] = recursiveMatrixChain(p, m, arr, i, k);
			}
			if(arr[k][j-1] == -1)
			{
				arr[k][j-1] = recursiveMatrixChain(p, m, arr, k+1, j);
			}
			
			int q = arr[i-1][k-1] + arr[k][j-1] + p[i-1]*p[k]*p[j];
								
			if(q < m[i-1][j-1])
				m[i-1][j-1] = q;
		}
		
		return m[i-1][j-1];
		
	}
	
	public static void main(String[] args) 
	{
		MatrixChain chain = new MatrixChain();
		int[] p = {30, 35, 15, 5, 10, 20, 25};
		int n = p.length - 1;
		
		int[][] m = new int[n][n];
		int[][] arr = new int[n][n];
		
		for(int i = 0; i < n; i++) 
		{
			for(int j = 0; j < n; j++)
				arr[i][j] = -1;
		}
		
//      System.out.println(chain.recursiveMatrixChain(p, m, 1, 6));        //normal recursion
		System.out.println(chain.recursiveMatrixChain(p, m, arr, 1, 6));   //dyn prog
		System.out.println("count:  " + chain.count);
	}
	

}
