import java.util.HashMap;


public class GroceryBagger 
{
	public static int minimumBags(int strength, String[] itemType)
	{
		int count = 0;
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		
		for (String string : itemType) 
		{
			if(!list.containsKey(string))
			{
				list.put(string, 1);
				count++;
			}
			else
			{
				if(list.get(string) < strength)
					list.put(string, list.get(string) + 1);
				else
				{
					list.put(string, 1);
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) 
	{
		String[] itemTypes = {"CANNED",   "CANNED",  "PRODUCE", "DAIRY",    "MEAT",    "BREAD", "HOUSEHOLD","PRODUCE", "FROZEN", "PRODUCE", "DAIRY"};
							//{"CANNED",   "CANNED",  "PRODUCE", "DAIRY",    "MEAT",    "BREAD","HOUSEHOLD","PRODUCE", "FROZEN","PRODUCE", "DAIRY"};
							//{"DAIRY", "DAIRY", "PRODUCE", "PRODUCE", "PRODUCE", "MEAT"};
		int strength = 2;//5;//3;
		
		System.out.println(minimumBags(strength, itemTypes));
	}

}
