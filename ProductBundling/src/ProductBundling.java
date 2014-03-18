import java.util.TreeSet;


public class ProductBundling 
{
	public static int howManyBundles(String[] data)
	{
		String[] transpose = new String[data[0].length()];
		
		for (int i = 0; i < transpose.length; i++) 
		{
			transpose[i] = "";
		}
		
		for (int i = 0; i < transpose.length; i++) 
		{
			for (int j = 0; j < data.length; j++) 
			{
				transpose[i] += data[j].charAt(i);
			}
		}
		TreeSet<String> tree = new TreeSet<String>();
		for (int i = 0; i < transpose.length; i++) 
		{
			tree.add(transpose[i]);
		}
		return tree.size();
	}
	
	public static void main(String[] args) 
	{
		String[] data = {"1100000000",
				 "1100000000",
				 "0011000000",
				 "0011000000",
				 "0000110000",
				 "0000110000",
				 "0000001100",
				 "0000001100",
				 "0000000011",
				 "0000000011"};
		
		System.out.println("number of bundles: " + howManyBundles(data));
	}

}
