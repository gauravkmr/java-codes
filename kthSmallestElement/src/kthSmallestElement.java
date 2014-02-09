
public class kthSmallestElement 
{
	public static int kthSmallest(int[] array, int left, int right, int k)
	{
		if(left == right)
			return array[left];
		
		int r = partition(array, left, right);
		
		int rank = r - left + 1;
		
		if(k == rank)
			return array[r];
		else if(k < rank)
			return kthSmallest(array, left, r-1, k);
		else
			return kthSmallest(array, r+1, right, k-rank);
	}
	
	public static int partition(int[] array, int left, int right)
	{
		int pivot = array[left];
		int i = left;
		
		for (int j = i+1; j <= right; j++) 
		{
			if(array[j] < pivot)
			{
				i++;
				//swap i and j
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
		//swap i and left
		int temp = array[left];
		array[left] = array[i];
		array[i] = temp;
//		System.out.println(i);
		
		return i;
	}
	
	public static void main(String[] args) 
	{
		int[] array = {6,5,4,3,2,1,-1,0};
		
		int result = kthSmallest(array, 0, array.length - 1, 7);
		
		System.out.println(result);
	}

}
