
public class PairSumEqualsGivenNumber 
{
	public static void printPairs(int[] A, int sum)
	{
		boolean possible = false;
		
		for (int left = 0, right = A.length-1; left < right; ) 
		{
			int tmp = A[left] + A[right];
			if(sum == tmp)
			{
				System.out.println("possible, using " + A[left] + ", " + A[right]);
				possible = true;
				break;
			}
			else if(sum > tmp)
				left++;
			else
				right--;
		}
		
		if(possible == false)
			System.out.println("not possible");
	}
	
	public static void main(String[] args) 
	{
		int[] A = {1,2,3,4,5,6,7,8,9,11};
		
		printPairs(A, 17);
	}

}
