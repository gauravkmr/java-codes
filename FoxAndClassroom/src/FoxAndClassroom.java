
public class FoxAndClassroom 
{
	public String ableTo(int n, int m)
	{
		int [][] seat = new int[n][m];
		
		int counter = n*m;
		
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < m; j++) 
			{
				int r = i;
				int c = j;
				
				seat[r][c] = -1;
				int k = 1;
				while(k < counter)
				{
					r = (r+1)%n;
					c = (c+1)%m;
					
					if(seat[r][c] == 0)
					{
						seat[r][c] = -1;
						k++;
					}
					else
					{
						return "Impossible";
					}
				}
				
				for (int k2 = 0; k2 < n; k2++) 
				{
					for (int l = 0; l < m; l++) 
					{
						seat[k2][l] = 0;
					}
				}
				 
			}
		}
		
		return "Possible";
		
	}
	
	public static void main(String[] args) 
	{
		FoxAndClassroom classroom = new FoxAndClassroom();
		System.out.println(classroom.ableTo(10, 10));

	}

}
