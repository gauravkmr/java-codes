
public class ThePalindrome 
{
	public boolean isPalindrome(String s)
	{
		int right = s.length()-1;
		
		for (int left = 0; left < s.length()/2; left++) 
		{
			if(s.charAt(left) != s.charAt(right))
				return false;
			right--;
		}
		
		return true;
	}
	
	
	public int find(String s)
	{
		for (int i = 0; i < s.length(); i++) 
		{
			boolean flag = isPalindrome(s.substring(i));
			
			if(flag == true)
			{
				return s.length() + i;
			}
						
		}
		
		return 2*(s.length()) - 1;
	}
	
	public static void main(String args[]) 
	{
		String s = "qwerty";
		System.out.println("the length is " + s.length()/2);
		ThePalindrome palindrome = new ThePalindrome();
		
		System.out.println(palindrome.find(s));

	}

}
