
public class PackingBallsDiv2 
{
	public static int minPacks(int R, int G, int B)
	{
		int count = R/3 + G/3 + B/3;
		R = R%3;
		G = G%3;
		B = B%3;
		int sum = R+G+B;
		if(R == G && R == B)
			count += sum/3;
		else
		{
			if(sum > 0 && sum < 3)
				count++;
			if(sum >= 3 && sum < 6)
				count += 2;
			if(sum >= 6)
				count += 3;
		}
		
		return count;
	}
	
	public static void main(String[] args) 
	{
		System.out.println(minPacks(1,3,3));
	}

}
