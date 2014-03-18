import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Queue;


public class ColorfulRoad 
{
		
	public char getnextcolor(char currentcolor)
	{
		if(currentcolor == 'R')
			return 'G';
		else if(currentcolor == 'G')
			return 'B';
		else
			return 'R';
	}
	
	public int getMin(String road)
	{
		ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		
		while(!queue.isEmpty())
		{
			int currentindex = queue.remove();
			char currentcolor = road.charAt(currentindex);
			char nextcolor = getnextcolor(currentcolor);
			
//			System.out.println("currentindex: " + currentindex + ", currcolor:  " + currentcolor + "nextcolor:  " + nextcolor);
			
			ArrayList<Integer> temp = new ArrayList<Integer>();
			
			temp.add(currentindex);
			int index = road.indexOf(nextcolor, currentindex + 1);
//			System.out.println(index);
			while (index >= currentindex) 
			{
			    temp.add(index);
			    queue.add(index);
			    index = road.indexOf(nextcolor, index + 1);
			}
			
			tree.add(temp);
//			System.out.println(queue);
		}
		
		for (int i = 0; i < tree.size(); i++) 
		{
			System.out.println(tree.get(i));
		}
				
		return 0;
	}
	
	public static void main(String[] args) 
	{
		ColorfulRoad colorfulRoad = new ColorfulRoad();
		String road = "RGBRGBRGB";
		
		System.out.println(colorfulRoad.getMin(road));

	}

}
