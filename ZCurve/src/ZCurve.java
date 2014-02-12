
public class ZCurve 
{
	public static int zValue(int N, int r, int c)
	{
		if(N == 0)
			return 0;
		int steps = 0;
		int two_power_Nminus1 = (int)Math.pow(2, N-1);
		
		if(r >= two_power_Nminus1 && c >= two_power_Nminus1)    // fourth quadrant
		{
			System.out.println("4th");
			steps += 3 * two_power_Nminus1 * two_power_Nminus1;
			steps += zValue(N-1, r - two_power_Nminus1, c - two_power_Nminus1);
		}
		if(r >= two_power_Nminus1 && c < two_power_Nminus1)     // third quadrant
		{
			System.out.println("3rd");
			steps += 2 * two_power_Nminus1 * two_power_Nminus1;
			steps += zValue(N-1, r-two_power_Nminus1, c);
		}
		if(r < two_power_Nminus1 && c >= two_power_Nminus1)   // second quadrant
		{
			System.out.println("2nd");
			steps += two_power_Nminus1 * two_power_Nminus1;;
			steps += zValue(N-1, r, c-two_power_Nminus1);
		}
		if(r < two_power_Nminus1 && c < two_power_Nminus1)     // first quadrant
		{
			System.out.println("1st");
			steps += zValue(N-1, r, c);
		}
		return steps;
	}
	
	public static void main(String[] args) 
	{
		System.out.println("number of steps required: " + zValue(10, 512, 512));
	}

}
