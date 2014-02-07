import java.util.Scanner;


public class NoOfTrailingZeroes 
{
	public static int trailingZeroes(int num)
	{
		int two_pow = 0;
		int five_pow = 0;
		
		int div = 2;
		while(num/div > 0)
		{
			two_pow += num/div;
			div *= 2;
		}
		div = 5;
		while(num/div > 0)
		{
			five_pow += num/div;
			div *= 5;
		}
		
		return two_pow < five_pow? two_pow: five_pow;
	}
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("enter a number:");
		int num = in.nextInt();
		System.out.println("number of trailing zeroes in " + num + " is: " + trailingZeroes(num));
		in.close();
	}

}
