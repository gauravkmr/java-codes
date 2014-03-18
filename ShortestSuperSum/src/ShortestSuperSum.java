
public class ShortestSuperSum 
{
	public int count;
		
	public int calculate(int k, int n) 
	{
		int[][] e = new int[k][n];
		
		for (int i = 0; i < k; i++) 
		{
			for (int j = 0; j < n; j++) 
			{
				e[i][j] = -1;
			}
		}
		
		return find(k, n, e);
		
	}
	
	public int find(int k, int n, int[][] e)
	{
		count++;
		if(k == 0)
		{
			e[0][n-1] = n;
			return e[0][n-1];
		}
		
		int res = 0;
		for (int i = 1; i <= n; i++) 
		{
			if(e[k-1][i-1] == -1)
			{
				e[k-1][i-1] = find(k-1, i, e);
				res += e[k-1][i-1];
			}
			else
				res += e[k-1][i-1]; 
		}
		
		return res;
	}

	public static void main(String[] args) 
	{
		int k = 4;
		int n = 10;
		
		ShortestSuperSum sum = new ShortestSuperSum();
		
		int s = sum.calculate(k, n);

		System.out.println("result: " + s);
		System.out.println("count: " + sum.count);
		
	}

}
