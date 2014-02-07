import java.util.ArrayList;


public class LargestSubsequenceSum 
{
	public static int maxSubArraySum(int[] A)
	{
		int maxSum = A[0];
		int currSum = A[0];
		ArrayList<Integer> subseq = new ArrayList<Integer>();
		subseq.add(A[0]);
		int i;
		for (i = 1; i < A.length; i++) 
		{
			currSum += A[i];
			
			if(currSum > A[i] )
				subseq.add(A[i]);
			
			if(A[i] >= currSum)
			{
				currSum = A[i];
				subseq.clear();
				subseq.add(A[i]);
			}
		
//			System.out.println("curr:"+currSum);
			if(i == A.length - 1 && A[i] < 0)
				subseq.remove(subseq.size()-1);
			
			if(currSum > maxSum)
			{
				maxSum = currSum;
			}
//			System.out.println("max:"+maxSum);
		}
		
		System.out.println(subseq);
		return maxSum;
	}
	
	public static void main(String[] args) 
	{
		int a[] = {-1,1,2,-3,3,-1,2,6};
        int max_sum = maxSubArraySum(a);
        System.out.println("Maximum contiguous sum is \n" + max_sum);
	}

}
