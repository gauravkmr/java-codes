
public class LongestNonRepeatingSequence 
{
	public static void findLongestSeq(String str)
	{
		int start = -1;
		int length = 0;
		
		for (int i = 1; i < str.length();) 
		{
			if(str.charAt(i) == str.charAt(i-1))
				i++;
			else
			{
				int strt = i-1;
				int len = 1;
				
				while(i < str.length() && str.charAt(i) != str.charAt(i-1))
				{
					len++;
					i++;
				}
				i++;
				
				if(len > length)
				{
					start = strt;
					length = len;
				}
			}
		}
		
		System.out.println(str.substring(start, (start+length)));
	}
	
	public static void main(String[] args) 
	{
		String str = "abcccdefdghiiiiajk";
		
		findLongestSeq(str);
	}

}
