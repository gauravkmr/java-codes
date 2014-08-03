import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class TextProcessingPatternSearching 
{
	public void textLineLengthAdjustment() throws IOException
	{
		BufferedInputStream brIn = new BufferedInputStream(new FileInputStream("D:\\Github\\java-codes\\TextProcessingPatternSearching\\src\\input.txt"));
		BufferedWriter brOut = new BufferedWriter(new FileWriter("D:\\Github\\java-codes\\TextProcessingPatternSearching\\src\\output.txt"));
		
		int limit = 40;
		StringBuilder word = new StringBuilder("");
		int lineCount = 0;
		
		int c;
		while((c = brIn.read()) != -1)
		{	
			word.append((char)c);
			if((char)c == ' ' || (char)c == '\n' || (char)c == '\t')
			{
				if((char)c == '\n')
				{
					word.replace(word.length() - 2, word.length(), " ");
				}
				if((char)c == '\t')
				{
					word.replace(word.length() - 1, word.length(), " ");
				}
				
				lineCount += word.length();
				if(lineCount > limit)
				{
					System.out.println();
					brOut.write("\n");
					lineCount = word.length();
				}
				System.out.print(word);
				brOut.write(word.toString());
				word = new StringBuilder("");
			}
			
		}
		System.out.print(word);
		brOut.write(word.toString());
		
		brIn.close();
		brOut.close();
	}
	
	public static void main(String[] args) throws IOException 
	{
		TextProcessingPatternSearching task = new TextProcessingPatternSearching();
		
		task.textLineLengthAdjustment();
		
	}

}
