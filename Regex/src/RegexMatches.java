import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexMatches 
{
	private static String REGEX = "dog";
	private static String REPLACE = "cat";
	private static String LINE = "every dog says meow" + "this dog says meow";
	
	public static void main(String[] args) 
	{
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(LINE);
		
		System.out.println(m.replaceAll(REPLACE));

	}

}
