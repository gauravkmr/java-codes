import java.util.Scanner;


public class MatrixMulDemo 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int i, j;
		
		System.out.println("enter size of array1:  ");
		Scanner scan = new Scanner(System.in);
		int row1 = scan.nextInt();
		scan.nextLine();
		
		scan = new Scanner(System.in);
		int col1 = scan.nextInt();
		scan.nextLine();
		
		System.out.println("enter size of array2:  ");
		scan = new Scanner(System.in);
		int row2 = scan.nextInt();
		scan.nextLine();
		
		scan = new Scanner(System.in);
		int col2 = scan.nextInt();
		scan.nextLine();
		
		int A[][] = new int[row1][col1];
		
		System.out.println("enter array1 elements:  ");
		Scanner numScan = new Scanner(scan.nextLine());
		
		for (i = 0; i < row1; i++) 
		{
			for (j = 0; j < col1; j++) 
			{
				if(numScan.hasNextInt())
					A[i][j] = numScan.nextInt();
				else
				{
					System.out.println("you didn't give enough inputs.");
					break;
				}				
			}
		}
		
		int B[][] = new int[row2][col2];
		
		System.out.println("enter array2 elements:  ");
		numScan = new Scanner(scan.nextLine());
		
		for (i = 0; i < row2; i++) 
		{
			for (j = 0; j < col2; j++) 
			{
				if(numScan.hasNextInt())
					B[i][j] = numScan.nextInt();
				else
				{
					System.out.println("you didn't give enough inputs.");
					break;
				}				
			}
		}
		
		int result[][] = matrix_multiply(A, B, row1, col1, row2, col2);
		
		for (i = 0; i < row1; i++) 
		{
			for (j = 0; j < col2; j++) 
			{
				System.out.print( result[i][j] + "  ");
			}
			
			System.out.println("\n");
		}
	
	}
	
	public static int[][] matrix_multiply(int[][] A, int[][] B, int row1, int col1, int row2, int col2)
	{
		int[][] D = new int[row1][col2];
		
		if(row2 == col1)
		{
			for (int i = 0; i < row1; i++) 
			{
				for (int j = 0; j < col2; j++) 
				{
					D[i][j] = 0;
					for (int k = 0; k < col1; k++) 
					{
						D[i][j] = D[i][j] + A[i][k]*B[k][j];
					}
				}
				
			}
		}
		return D;
	}
}
