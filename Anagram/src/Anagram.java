
public class Anagram {

	public static boolean isAnagram(String a, String b)
	{
		boolean[] ascii_a = new boolean[256];
		boolean[] ascii_b = new boolean[256];
		
		char[] charA = a.toCharArray();
		char[] charB = b.toCharArray();
		
		for(char i : charA)
			ascii_a[i] = true;
		for(char i : charB)
			ascii_b[i] = true;
		
		for (int i = 0; i < 256; i++) 
		{
			if (ascii_b[i] != ascii_a[i])
				return false;
		}
		return true;
	}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "motherinlaw";
		String str2	= "womanhitler";
		
		if(isAnagram(str1,str2))
			System.out.println("yes, it is an anagraam");
		else
			System.out.println("not an anagram");
		
	}

}
