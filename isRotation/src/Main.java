import java.lang.String;

public class Main {

	public static boolean isRotation(String str1, String str2)
	{
		if(str1.length() != str2.length())
			return false;
		
		str1 = str1.concat(str1);
		if(str1.contains(str2))
			return true;
		else
			return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "dragon";
		String str2 = "gondra";
				
		if(isRotation(str1,str2))
			System.out.println("yes, it is a substring");
		else
			System.out.println("not a substring");
		
		
	}

}
