import java.util.Arrays;


public class LittleElephantAndBooks 
{
	public static int getNumber(int[] pages, int number)
	{
		if(pages.length == 0 || number <= 0)
			return 0;
		
		Arrays.sort(pages);
		
		int sum = 0;
		for (int i = 0; i <= (number - 2); i++) 
		{
			sum += pages[i];
		}
		
		sum += pages[number];
		return sum;
	}
	
	public static void main(String[] args) 
	{
		int pages[] = {74, 7, 4, 47, 44};
		
		System.out.println(getNumber(pages, 3));
	}

}
