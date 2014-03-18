
public class PalindromeDecoding 
{

	public String decode(String code, int[] position, int[] length)
	{
		StringBuilder sb = new StringBuilder(code);
		
		for (int i = 0; i < position.length; i++) 
		{
			String str = sb.substring(position[i], position[i] + length[i]);
			
			StringBuilder builder = new StringBuilder(str);
			
		    builder.reverse();
			
			sb.insert(position[i] + length[i], builder);
			
		}
				
		return sb.toString();
	}
	
	public static void main(String[] args) 
	{
		PalindromeDecoding decoding = new PalindromeDecoding();
		
//		String code = "Misip";
//		int[] position = {2,3,1,7};
//		int[] length = {1,1,2,2};
		
		String code = "TC206";
		int[] position = {1, 2, 5};
		int[] length = {1, 1, 1};
		
		
		String s = decoding.decode(code, position, length);
		
		System.out.println(s);
	}

}
