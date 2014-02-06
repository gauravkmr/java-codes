import java.io.*;
import java.util.Hashtable;

public class UniqueChars 
{
	public static boolean isUnique(String str)
	{
		boolean[] chars = new boolean[256];
		
		for (int i = 0; i < str.length(); i++) 
		{
			int pos = str.charAt(i);
			
			if(chars[pos])
				return false;
			chars[pos] = true;
		}
		
		return true;
	}
	
	public static boolean isUnique1(String str)
	{
		Hashtable<Integer, Integer> chars = new Hashtable<Integer, Integer>();
		
		for (int i = 0; i < str.length(); i++) 
		{
			int key = str.charAt(i);
			if(chars.containsKey(key))
				return false;
			chars.put(key, new Integer(0));
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException 
	{
		System.out.println("enter string:");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		if(isUnique1(str))
			System.out.println("all characters are unique.");
		else
			System.out.println("all characters are not unique.");

	}

}
