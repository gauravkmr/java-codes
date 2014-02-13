
public class SkiResortsEasy 
{
	public static int minCost(int[] altitude)
	{
		int cost = 0;
		int prev = altitude[0];
		for (int i = 1; i < altitude.length; i++) 
		{
			if(altitude[i] > prev)
			{
				cost += (altitude[i] - prev);
			}
			else
				prev = altitude[i];
		}
		return cost;
	}
	
	public static void main(String[] args) 
	{
		int[] altitude = {749, 560, 921, 166, 757, 818, 228, 584, 366, 88};
		System.out.println("minimum cost required for the change: " + minCost(altitude));
	}

}
