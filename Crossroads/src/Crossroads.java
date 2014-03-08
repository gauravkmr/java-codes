import java.util.ArrayList;

public class Crossroads 
{
	public static int[] getOut(int[] angles)
	{
		int i = angles.length - 1;
		int j = i - 1;
		boolean[] index = new boolean[i+1];

		boolean flag = false;
		while(j >= 0)
		{
			if(index[j] == false && index[i] == false)
			{
				if(angles[j] >= angles[i])
				{
					i = j;
					j--;
				}
				else
				{
					flag = true;
					int x = 180 - angles[i];
					if(angles[j] < x)
					{
						index[j] = true;
						j--;
					}
					else
					{
						index[i] = true;
						i = j;
						j--;
					}
				}
			}
			else if(index[j] == false && index[i] == true)
			{
				i = j;
				j--;
			}
			else if(index[j] == true && index[i] == false)
			{
				j--;
			}
			else
			{
				i = j - 1;
				j = i - 1;
			}
			if(j < 0)
			{
				if(flag == false)
					break;
				i = angles.length - 1;
				j = i - 1;
				flag = false;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int k = 0; k < index.length; k++) 
		{
			if(index[k] == false)
				list.add(k);
		}
		int[] ret = new int[list.size()];
		for (int k = 0; k < ret.length; k++) 
		{
			ret[k] = list.get(k);
		}
		return ret;
	}
	
	public static void main(String[] args) 
	{
		int[] angles = {140, 118, 54, 166, 151, 44, 90, 5, 14, 6,
				 64, 129, 74, 33, 134, 25, 11, 95, 65, 145,
				 29, 162, 24, 147, 45, 103, 63, 97, 120, 156,
				 167, 170, 19, 28, 100, 144, 161, 13, 157, 148};
		
		int[] carIndex = getOut(angles);
		for (int i : carIndex) 
		{
			System.out.print(i + " ");
		}
	}

}
