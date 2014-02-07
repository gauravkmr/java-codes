
public class CompressString 
{
	public String compress(String str)
	{
		String newStr = new String();
		
		int count = 1;
		for (int i = 1; i < str.length(); i++) 
		{
			if(str.charAt(i) == str.charAt(i-1))
			{
				count++;
				continue;
			}
			newStr += str.charAt(i-1);
			newStr += count;
			count = 1;
		}
		return newStr;
	}
	
	public static void main(String[] args) 
	{
		CompressString cstr = new CompressString();
		String str = "aaabbcccdddee";
		
		System.out.println(cstr.compress(str));
	}

}
