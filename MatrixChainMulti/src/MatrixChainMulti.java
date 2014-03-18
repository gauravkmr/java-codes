
public class MatrixChainMulti 
{
	public void matrixChainOrder(int[] p, int[][] m, int[][] s)
	{
		int n = p.length - 1;
		
		for (int i = 0; i < n; i++) 
		{
			m[i][i] = 0;
		}
		
		for (int l = 2; l <= n; l++)           //length of chain 
		{
			for (int i = 1; i <= n-l+1; i++) 
			{
				int j = i+l-1;
				m[i-1][j-1] = 99999999;
				
				for (int k = i; k < j; k++) 
				{

					int q = m[i-1][k-1] + m[k][j-1] + (p[i-1]*p[k]*p[j]);

					if(q < m[i-1][j-1])
					{
						m[i-1][j-1] = q;
						s[i-1][j-1] = k;
					}
				}
				
			}
		}
	}
	
	public void printOptimalParen(int[][] s,int i,int j)
	{
		if(i == j)
			System.out.print("A" + i);
		else
		{
			System.out.print("(");
			printOptimalParen(s, i, s[i-1][j-1]);
			printOptimalParen(s, s[i-1][j-1] + 1, j);
			System.out.print(")");
		}
	}
		
	public static void main(String[] args) 
	{
		MatrixChainMulti chainMulti = new MatrixChainMulti();
		int[] p = {30, 35, 15, 5, 10, 20, 25};
		
		int n = p.length - 1;
				
		int[][] m = new int[n][n];
		int[][] s = new int[n][n];
		
		chainMulti.matrixChainOrder(p, m, s);
		chainMulti.printOptimalParen(s, 1, 6);

		System.out.println("\nMatrix m:");
		for(int i = 0; i < n; i++) 
		{
			for(int j = 0; j < n; j++)
				System.out.print(m[i][j] + "\t");
			System.out.println();
		}
		
		System.out.println("\nMatrix s:");
		for(int i = 0; i < n; i++) 
		{
			for(int j = 0; j < n; j++)
				System.out.print(s[i][j] + "\t");
			System.out.println();
		}
	
	}

}
