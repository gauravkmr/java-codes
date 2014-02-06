
public class ReplaceSpace 
{
	public static String replace_sp(String s)
	{
		return s.replaceAll(" ", "%20");
	}
	
	public static String replace_sp1(String s)
	{
		int index = s.indexOf(" ");
		while(index >= 0 && index < s.length())
		{
			s = s.substring(0, index) + "%20" + s.substring(index+1);
			index = s.indexOf(" ");
			
		}
		return s;
	}

	public static void main(String[] args) 
	{
		String str = "ab  c d";
		
		str = replace_sp1(str);
		System.out.println(str);

	}

}
