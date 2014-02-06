import java.io.*;

public class ReverseString 
{
	public static void reverse(char[] str)
	{
		char temp;
		int length = str.length;
		
		for (int i = 0; i < length/2; i++) 
		{
			temp = str[i];
			str[i] = str[length-1-i];
			str[length-1-i] = temp;
		}
		
	}
	
	public static void main(String[] args) throws IOException 
	{
		
		char[] str = {'a','b','c','d','e'};
		System.out.println("before: " + str);
		
	}

}
