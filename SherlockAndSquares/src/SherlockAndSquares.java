import java.util.*;

public class SherlockAndSquares 
{
	public static void findCount(int input[][])
	{
		for (int i = 0; i < input.length; i++) 
		{
			int base = (int)Math.ceil(Math.sqrt(input[i][0]));
			int limit = input[i][1];
			int count = 0;
						
			while(base*base <= limit)
			{
				base += 1;
				count++;
			}
			System.out.println(count);
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		if(T > 0)
		{
			int input[][] = new int[T][2];
			
			for (int i = 0; i < T; i++) 
			{
				input[i][0] = scan.nextInt();
				input[i][1] = scan.nextInt();
			}
			scan.close();
			
			findCount(input);
		}
	}

}
