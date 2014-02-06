
public class RotateImage 
{
	public static int[][] rotate(int[][] image, int degree)
	{
		int[][] newimage = new int[degree][degree];
		
		for (int i = 0; i < image.length; i++) 
		{
			for (int j = 0; j < image[i].length; j++) 
			{
				newimage[degree - 1 - j][i] = image[i][j];
			}
		}
		
		return newimage;
	}
	
	public static void main(String[] args) 
	{
		int degree = 4;
		int[][] image = new int[degree][degree];
		
		System.out.println("original image:");
		for (int i = 0; i < image.length; i++) 
		{
			for (int j = 0; j < image[i].length; j++) 
			{
				image[i][j] = (i)*image[i].length + j + 1;
				System.out.print(image[i][j]+"\t");
			}
			System.out.println();
		}
		
		image = rotate(image, degree);
		
		System.out.println("rotated image:");
		for (int i = 0; i < image.length; i++) 
		{
			for (int j = 0; j < image[i].length; j++) 
			{
				System.out.print(image[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
