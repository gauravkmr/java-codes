
public class Main {
	
	static int[][] setZero(int[][] A, int rows, int cols) {
		
		int[] row_identify = new int[rows];
		int[] col_identify = new int[cols];
		
//initialise row array to zero
		for (int i = 0; i < rows; i++) {
			row_identify[i] = 0;
		}

//initialise col array to zero
		for (int i = 0; i < cols; i++) {
			col_identify[i] = 0;
		}
		
//finding which elements are zero and recording its row and column number
		for (int i = 0; i < rows; i++) {
			
			for (int j = 0; j < cols; j++) {
				
				if(A[i][j] == 0) {
					row_identify[i] = 1;
					col_identify[j] = 1;
				}
				
			}
		}

//reinitialising col
		for (int j = 0; j < cols; j++) {
			
			if (col_identify[j] == 1) {
				
				for (int i = 0; i < rows; i++) {
					A[i][j] = 0;
				}
				
			}
		}

//reinitialising row
		for (int i = 0; i < rows; i++) {
			
			if (row_identify[i] == 1) {
				
				for (int j = 0; j < cols; j++) {
					A[i][j] = 0;
				}
			}
		}
		
		return A;
		
	}
	
//reinitialising row	
	static void display(int[][] A, int rows, int cols) {
		
		for (int i = 0; i < rows; i++) {
		
			for (int j = 0; j < cols; j++) {
				System.out.print( A[i][j] + " " );
			}
			System.out.println("\n");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int[][] matrix = { {1,2,3,3},
				 			{2,0,9,4},
				 			{0,1,2,8},
				 			{3,1,2,3} };
		 
		 System.out.println("Original matrixx:::");
		 display(matrix, 4, 4);
		 
		 matrix = setZero(matrix, 4, 4); 
		 
		 System.out.println("New matrixx:::");
		 display(matrix, 4, 4);
	}

}
