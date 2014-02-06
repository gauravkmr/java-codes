
public class RotatePivot {

	static int[] doRotation(int[] a, int from, int to)
	{
		for (int i = from; i <= to; i++) 
		{
			int temp = a[to];
			for (int j = (to - 1); j >= i; j--) {
				a[j+1] = a[j];
			}
			a[i] = temp; 
		}
		return a;
	}
	
	static void Rotate(int[] a, int p)
	{
		a = doRotation(a, 0, p);
		a = doRotation(a, 0, a.length - 1);
		a = doRotation(a, 0, (a.length - p - 2));
		
		for (int i = 0; i < a.length; i++) 
		{
			System.out.print(a[i] + " ");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 2, 3, 4, 5, 6};
		int pivot = 2;
		
		Rotate(input,pivot);
		
	}

}
