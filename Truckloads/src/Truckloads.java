import java.util.Scanner;

public class Truckloads 
{
	public static int numTrucks(int numCrates, int loadSize)
	{
		if(numCrates <= loadSize)
			return 1;
		
		int mid = numCrates/2;
		return numTrucks(mid, loadSize) + numTrucks(numCrates-mid, loadSize);
	}
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("enter the number of crates:");
		int numCrates = in.nextInt();
		System.out.println("enter the load size:");
		int loadSize = in.nextInt();
		
		System.out.println("number of trucks required: " + numTrucks(numCrates, loadSize));
		in.close();
	}

}
