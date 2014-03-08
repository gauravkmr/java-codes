
public class ColorfulTilesEasy 
{
	public static int theMin(String room)
	{
		if(room.length() <= 1)
			return 0;
		
		StringBuilder builder = new StringBuilder(room);
		boolean R = false;
		boolean G = false;
		boolean B = false;
		boolean Y = false;
		int count = 0;
		
		int len = builder.length();
		builder.append('X');
		
		for (int i = 1; i < len; ) 
		{
			if(builder.charAt(i) == builder.charAt(i-1))
			{
				count++;
				
				char prev = builder.charAt(i-1);
				char next = builder.charAt(i+1);
				
				if(prev == 'R' || next == 'R')
					R = true;
				if(prev == 'G' || next == 'G')
					G = true;
				if(prev == 'B' || next == 'B')
					B = true;
				if(prev == 'Y' || next == 'Y')
					Y = true;
				
				if(R == false)
					builder.replace(i, i+1, "R");
				else if(G == false)
					builder.replace(i, i+1, "R");
				else if(B == false)
					builder.replace(i, i+1, "R");
				else if(Y == false)
					builder.replace(i, i+1, "R");

				i = i + 2;
				R = false;
				G = false;
				B = false;
				Y = false;
			}
			else
				i++;
		}
		return count;
	}
	
	public static void main(String[] args) 
	{
		String room = "RGGBBBRYYB";//"RRRRRR";//"GGGGGGG";//"BBBYYYYYY";
		
		System.out.println(theMin(room));
	}

}
