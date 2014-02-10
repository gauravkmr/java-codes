import java.util.ArrayList;

public class HealthFood 
{
	public static int[] selectMeals(int[] protein, int[] carbs, int[] fat, String[] dietPlans)
	{
		int[] meals = new int[dietPlans.length];
		int[] calorie = new int[protein.length];
		
		for (int i = 0; i < calorie.length; i++) 
		{
			calorie[i] = (protein[i] + carbs[i])*5 + fat[i]*9;
		}
		
		int count = 0;
		for (String s : dietPlans) 
		{
			char[] preference = s.toCharArray();
			ArrayList<Integer> index = new ArrayList<Integer>();
			for (char c : preference) 
			{
				if(c == 'C')
				{
					if(index.size() == 0)
					{
						int max = carbs[0];
						index.add(0);
						for (int i = 1; i < carbs.length; i++) 
						{
							if(carbs[i] == max)
								index.add(i);
							if(carbs[i] > max)
							{
								max = carbs[i];
								index.clear();
								index.add(i);
							}
							
						}
						if(index.size() == 1)
							break;
					}
					else
					{
						int max = 0;
						ArrayList<Integer> temp = new ArrayList<Integer>();
						for (Integer integer : index) 
						{
							if(carbs[integer] == max)
								temp.add(integer);
							if(carbs[integer] > max)
							{
								max = carbs[integer];
								temp.clear();
								temp.add(integer);
							}
							
						}
						index = temp;
						if(index.size() == 1)
							break;
					}
				}
				if(c == 'c')
				{
					System.out.println(index.size());
					if(index.size() == 0)
					{
						int min = carbs[0];
						index.add(0);
						for (int i = 1; i < carbs.length; i++) 
						{
							if(carbs[i] == min)
								index.add(i);
							if(carbs[i] < min)
							{
								min = carbs[i];
								index.clear();
								index.add(i);
							}
							
						}
						if(index.size() == 1)
							break;
					}
					else
					{
						System.out.println("sedvs");
						int min = 999999;
						ArrayList<Integer> temp = new ArrayList<Integer>();
						for (Integer integer : index) 
						{
							if(carbs[integer] == min)
								temp.add(integer);
							if(carbs[integer] < min)
							{
								min = carbs[integer];
								temp.clear();
								temp.add(integer);
							}
							
						}
						index = temp;
						if(index.size() == 1)
							break;
					}
				}
				if(c == 'P')
				{
					
					if(index.size() == 0)
					{
						int max = protein[0];
						index.add(0);
						for (int i = 1; i < protein.length; i++) 
						{
							if(protein[i] == max)
								index.add(i);
							if(protein[i] > max)
							{
								max = protein[i];
								index.clear();
								index.add(i);
							}
							
						}
						if(index.size() == 1)
							break;
					}
					else
					{
						int max = 0;
						ArrayList<Integer> temp = new ArrayList<Integer>();
						for (Integer integer : index) 
						{
							if(protein[integer] == max)
								temp.add(integer);
							if(protein[integer] > max)
							{
								max = protein[integer];
								temp.clear();
								temp.add(integer);
							}
							
						}
						index = temp;
						if(index.size() == 1)
							break;
					}
				}
				if(c == 'p')
				{
					
					if(index.size() == 0)
					{
						int min = protein[0];
						index.add(0);
						for (int i = 1; i < protein.length; i++) 
						{
							if(protein[i] == min)
								index.add(i);
							if(protein[i] < min)
							{
								min = protein[i];
								index.clear();
								index.add(i);
							}
							
						}
						if(index.size() == 1)
							break;
					}
					else
					{
						int min = 999999;
						ArrayList<Integer> temp = new ArrayList<Integer>();
						for (Integer integer : index) 
						{
							if(protein[integer] == min)
								temp.add(integer);
							if(protein[integer] < min)
							{
								min = protein[integer];
								temp.clear();
								temp.add(integer);
							}
							
						}
						index = temp;
						if(index.size() == 1)
							break;
					}
				}
				if(c == 'F')
				{
					if(index.size() == 0)
					{
						int max = fat[0];
						index.add(0);
						for (int i = 1; i < fat.length; i++) 
						{
							if(fat[i] == max)
								index.add(i);
							if(fat[i] > max)
							{
								max = fat[i];
								index.clear();
								index.add(i);
							}
							
						}
						if(index.size() == 1)
							break;
					}
					else
					{
						int max = 0;
						ArrayList<Integer> temp = new ArrayList<Integer>();
						for (Integer integer : index) 
						{
							if(fat[integer] == max)
								temp.add(integer);
							if(fat[integer] > max)
							{
								max = fat[integer];
								temp.clear();
								temp.add(integer);
							}
							
						}
						index = temp;
						if(index.size() == 1)
							break;
					}
				}
				if(c == 'f')
				{
					
					if(index.size() == 0)
					{
						int min = fat[0];
						index.add(0);
						for (int i = 1; i < fat.length; i++) 
						{
							if(fat[i] == min)
								index.add(i);
							if(fat[i] < min)
							{
								min = fat[i];
								index.clear();
								index.add(i);
							}
							
						}
						if(index.size() == 1)
							break;
					}
					else
					{
						int min = 999999;
						ArrayList<Integer> temp = new ArrayList<Integer>();
						for (Integer integer : index) 
						{
							if(fat[integer] == min)
								temp.add(integer);
							if(fat[integer] < min)
							{
								min = fat[integer];
								temp.clear();
								temp.add(integer);
							}
							
						}
						index = temp;
						if(index.size() == 1)
							break;
					}
				}
				if(c == 'T')
				{
					if(index.size() == 0)
					{
						
						int max = calorie[0];
						index.add(0);
						for (int i = 1; i < calorie.length; i++) 
						{
							if(calorie[i] == max)
								index.add(i);
							if(calorie[i] > max)
							{
								max = calorie[i];
								index.clear();
								index.add(i);
							}
							
						}
						if(index.size() == 1)
							break;
					}
					else
					{
						int max = 0;
						ArrayList<Integer> temp = new ArrayList<Integer>();
						for (Integer integer : index) 
						{
							if(calorie[integer] == max)
								temp.add(integer);
							if(calorie[integer] > max)
							{
								max = calorie[integer];
								temp.clear();
								temp.add(integer);
							}
							
						}
						index = temp;
						if(index.size() == 1)
							break;
					}
				}
				if(c == 't')
				{
					if(index.size() == 0)
					{
						int min = calorie[0];
						index.add(0);
						for (int i = 1; i < calorie.length; i++) 
						{
							if(calorie[i] == min)
								index.add(i);
							if(calorie[i] < min)
							{
								min = calorie[i];
								index.clear();
								index.add(i);
							}
							
						}
						if(index.size() == 1)
							break;
						
					}
					else
					{
						int min = 999999;
						ArrayList<Integer> temp = new ArrayList<Integer>();
						for (Integer integer : index) 
						{
							if(calorie[integer] == min)
								temp.add(integer);
							if(calorie[integer] < min)
							{
								min = calorie[integer];
								temp.clear();
								temp.add(integer);
							}
							
						}
						index = temp;
						if(index.size() == 1)
							break;
					}
				}
				
			}
			if(index.size() == 1)
				meals[count] = index.get(0);
			else
				meals[count] = 0;
			count++;
		}
		return meals;
	}
	
	public static void main(String[] args) 
	{
		int[] proteins = {18, 86, 76,  0, 34, 30, 95, 12, 21};
		int[] carbs = {26, 56,  3, 45, 88,  0, 10, 27, 53};
		int[] fats = {93, 96, 13, 95, 98, 18, 59, 49, 86};
		
		String[] dietPlans = {"f", "Pt", "PT", "fT", "Cp", "C", "t", "", "cCp", "ttp", "PCFt", "P", "pCt", "cP", "Pc"};
		
		int[] meals = selectMeals(proteins, carbs, fats, dietPlans);
		int count = 1;
		for (int i : meals) 
		{
			System.out.println("Best suited diet for individual " + count + " is: " + i);
			count++;
		}
	}

}
