
public class RaiseThisBarn 
{

	int calc(String str)
	{
		int length = str.length();
		
		int numberofC = 0;
		
		int left = 0;
		int right = 0;
		
		for (int i = 0; i < str.length(); i++) 
		{
			if(str.charAt(i) == 'c')
				numberofC++;
		}
		
		if(numberofC%2 == 1)
			return 0;
		if(numberofC == 0)
			return length-1;
		
		int i = 0;
		int temp = 0;
		while(temp < numberofC/2)
		{
			if(str.charAt(i) == 'c')
				temp++;
			i++;
		}
		left = i;
		while(str.charAt(i++) != 'c')
		{
			
		}
		right = i;

		return right-left;
		
	}
	public static void main(String[] args) 
	{
		RaiseThisBarn barn = new RaiseThisBarn();
		String string = ".c.c...c..ccc.c..c.c.cc..ccc";
		
		int n = barn.calc(string);
		
		System.out.println(n);
		
	}

}
