
public class LongestSubsequence 
{
	public void LCSlength(char[] X,char[] Y,char[][] b,int[][] c)
	{
		int m = X.length;
		int n = Y.length;
		
		for (int i = 1; i <= m; i++) 
		{
			c[i][0] = 0;
		}

		for (int j = 1; j <= n; j++) 
		{
			c[0][j] = 0;
		}
		
		for (int i = 1; i <= m; i++) 
		{
			for (int j = 1; j <= n; j++) 
			{
				if(X[i-1] == Y[j-1])
				{
					c[i][j] = c[i-1][j-1] + 1;
					b[i-1][j-1] = 'x';
				}
				else if(c[i-1][j] >= c[i][j-1])
				{
					c[i][j] = c[i-1][j];
					b[i-1][j-1] = 't';
				}	
				else
				{
					c[i][j] = c[i][j-1];
					b[i-1][j-1] = 'l';
				}
			}
		}
		
	}
	
	public void PrintLCS(char[][] b,char[] X,int i,int j)
	{
		if(i == 0 || j == 0)
			return;
		
		if(b[i-1][j-1] == 'x')
		{
			PrintLCS(b, X, i-1, j-1);
			System.out.print(X[i-1] + "  ");
		}
		else if(b[i-1][j-1] == 't')
		{
			PrintLCS(b, X, i-1, j);
		}
		else
		{
			PrintLCS(b, X, i, j-1);
		}
		
	}
	
	public static void main(String[] args) 
	{
		LongestSubsequence subsequence = new LongestSubsequence();
		char[] X = {'A', 'B', 'C', 'B', 'D', 'A', 'D'};
		char[] Y = {'B', 'D', 'C', 'A', 'B', 'A'};
		
		int m = X.length;
		int n = Y.length;
		
		char[][] b = new char[m][n];
		int[][] c = new int[m+1][n+1];
		
		subsequence.LCSlength(X, Y, b, c);		
		
		for (int i = 0; i <= m; i++) 
		{
			for (int j = 0; j <= n; j++) 
			{
				System.out.print(c[i][j] + "\t");
			}
			System.out.println();
		}
		
		subsequence.PrintLCS(b, X, m, n);
		
	}

}
