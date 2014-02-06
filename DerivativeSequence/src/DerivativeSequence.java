
public class DerivativeSequence 
{
	public static int[] derSeq(int[] A, int n)
	{
		if(n <= 0)
			return A;
		int[] B = new int[A.length - 1];
		
		for (int i = 0; i < B.length; i++) 
		{
			B[i] = A[i+1]-A[i];
		}
		return derSeq(B, n-1);
	}
	
	public static void main(String[] args) 
	{
		int[] A = {5,6,3,9,-1};
		
		int[] B = derSeq(A, 2);
		
		for (int i : B) 
		{
			System.out.println(i);
		}
	}

}
