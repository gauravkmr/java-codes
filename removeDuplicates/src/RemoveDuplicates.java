
public class RemoveDuplicates {
	
	static String removeDup(String str)
	{
		if(str == null || str.length() <= 1)
			return str;
		
		else if(str.charAt(0) == str.charAt(1))
			return removeDup( str.substring(1, str.length()) );
		
		else
			return str.charAt(0) + removeDup( str.substring(1, str.length()) );
	}

	static void removeDup1(char[] str)
	{
		if(str.length == 0 || str.length == 1)
			System.out.println("String is: " + str.toString());
		
		int tail = 1;
		for (int i = 1; i < str.length; i++) 
		{
			int j;
			for (j = 0; j < tail; j++) 
				if(str[j] == str[i])
					break;
			
			if(j == tail)
			{
				str[tail] = str[i];
				tail++;
			}
			
		}
			
		for (int i = 0; i < tail; i++) {
			System.out.print(str[i]);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "aabccba";
		char[] word = str.toCharArray();
		
		removeDup1(word);
				
	}

}
