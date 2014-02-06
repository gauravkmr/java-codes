import java.io.*;

public class ByteStreamTest 
{
	public static void main(String[] args) throws IOException
	{
		ByteArrayOutputStream bout = new ByteArrayOutputStream(12);
		
		
		while(bout.size() != 10)
		{
			bout.write(System.in.read());
		}
		
		byte[] b = bout.toByteArray();
		
		for (int i = 0; i < b.length; i++) 
		{
			System.out.print((char)b[i] + "   ");
		}
		
		System.out.println("capitalize each letter");
		
		int c;
		ByteArrayInputStream bin = new ByteArrayInputStream(b);
		
		for (int i = 0; i < 1; i++) 
		{
			while((c=bin.read()) != -1)
			{
				System.out.println(Character.toUpperCase((char)c));
			}
		}
	}

}
