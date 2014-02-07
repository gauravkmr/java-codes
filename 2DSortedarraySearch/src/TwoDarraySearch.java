
public class TwoDarraySearch 
{
	public static void findElement(int[][] A, int key)
	{
		
		for (int row = 0, column = A[0].length - 1; row < A.length && column >= 0; ) 
		{
			if(key == A[row][column])
			{
				System.out.println("key found at: A[" + row + "][" + column + "]");
				return;
			}

			if(key > A[row][column])
			{
				row++;
				continue;
			}

			if(key <= A[row][column])
			{
				column--;
				continue;
			}
			
		}
		System.out.println("key not found");
		return;
	}
	
	public static void main(String[] args) 
	{
		int[][] sortedarray = {
								{1,2,3,4,5},
								{6,7,8,9,10},
								{11,12,13,14,15},
								{16,17,18,19,20}
								};
		
		findElement(sortedarray, 143);
		
	}

}
