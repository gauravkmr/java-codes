
public class Haar1D 
{
	public static int[] transform(int[] data, int L)
	{
		if(data.length % 2 != 0) 
			return null;
		
		int size = data.length;
		return transform(data, size, L);
		
	}
	
	public static int[] transform(int[] data, int size, int L)
	{
		if(L == 0)
			return data;
		
		int[] left = new int[size/2];
		int[] right = new int[size/2];
		
		int j = 0;
		for (int i = 0; i < size; i += 2) 
		{
			left[j] = data[i] + data[i+1];
			right[j] = data[i] - data[i+1];
			j++;
		}
		size = size/2;
		data = merge(data, left, right, size);
		
		return transform(data, size, L - 1);
	}
	
	public static int[] merge(int[] data, int[] left, int[] right, int size)
	{
		for (int i = 0; i < size; i++) 
		{
			data[i] = left[i];
			data[i + size] = right[i];
		}
		return data;
	}
	
	public static void main(String[] args) 
	{
		int[] data = {94, 47, 46, 28, 39, 89, 75, 4, 28, 62, 69, 89, 34, 55, 81, 24};
		
		data = transform(data, 2);
		
		for (int i = 0; i < data.length; i++) 
		{
			System.out.print(data[i] + " ");
		}
		
	}

}
