
public class MagicalStringDiv2 
{
	public static int minimalMoves(String S)
	{
		int count = 0;
		int len = S.length();
				
		for (int i = 0; i < (len+1)/2; i++) 
		{
			if(S.charAt(i) == '>' && S.charAt(i + (len+1)/2) == '<')
				continue;
			if(S.charAt(i) == '>' && S.charAt(i + (len+1)/2) == '>')
				count++;
			if(S.charAt(i) == '<' && S.charAt(i + (len+1)/2) == '<')
				count++;
			if(S.charAt(i) == '<' && S.charAt(i + (len+1)/2) == '>')
				count += 2;
		}
		 return count;
	}
	
	public static void main(String[] args) 
	{
		String s = "<><<<>>>>><<>>>>><>><<<>><><><><<><<<<<><<>>><><><";
		System.out.println(minimalMoves(s));
	}

}
