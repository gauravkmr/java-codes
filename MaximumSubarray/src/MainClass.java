import java.util.Scanner;


public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter size of array:  ");
				
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		scan.nextLine();
		
		int[] stock = new int[size];
		
		System.out.println("enter stock input:\n");
		Scanner numScan = new Scanner(scan.nextLine());
				
		for (int i = 0; i < size; i++) 
		{
			if(numScan.hasNextInt())
				stock[i] = numScan.nextInt();
			else
			{
				System.out.println("you didn't give enough inputs.");
				break;
			}
		}
/*		
		for (int i = 0; i < size; i++) 
		{
			System.out.print(stock[i] + "  ");
		}
*/		
		Record result = new Record();
		result = FindMaximumSubarray(stock, 0, stock.length - 1);
		
		System.out.println("maximum sum:  "  + result.sum);
		
		for (int i = result.low; i <= result.high; i++) 
		{
			System.out.print(stock[i] + "  ");
		}

	}
	
	public static Record FindMaximum_CrossSubarray(int[] A, int low, int mid, int high)
	{
		int left_sum = -12345;
		int sum = 0;
		int max_left = mid;
		
		for (int i = mid; i >= low; i--) 
		{
			sum = sum + A[i];
			if (sum > left_sum)
			{
				left_sum = sum;
				max_left = i;
			}
		}
		
		int right_sum = -12345;
		sum = 0;
		int max_right = mid+1;
		
		for (int j = mid+1; j <= high; j++) 
		{
			sum = sum + A[j];
			if (sum > right_sum)
			{
				right_sum = sum;
				max_right = j;
			}
		}
		
		return (new Record(max_left, max_right, left_sum + right_sum)); 
	}
	
	public static Record FindMaximumSubarray(int[] A, int low, int high)
	{
		if(high == low)
		{
			Record base = new Record(low, high, A[low]);
			return base;
		}
		else
		{
			int mid = (high + low)/2;
			
			Record left = FindMaximumSubarray(A, low, mid);
			Record right = FindMaximumSubarray(A, mid+1, high);
			Record cross = FindMaximum_CrossSubarray(A, low, mid, high);
			
			if (left.sum >= right.sum  && left.sum >= cross.sum) 
				return left;
			else if (right.sum >= left.sum  && right.sum >= cross.sum)
				return right;
			else
				return cross;
		}
	}

}
