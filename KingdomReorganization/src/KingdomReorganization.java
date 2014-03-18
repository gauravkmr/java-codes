import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class KingdomReorganization
{
	public static int getCost(String[] kingdom, String[] build, String[] destroy)
	{
		HashMap<Character, List<String>> build_entry = new HashMap<Character, List<String>>();
		HashMap<Character, List<String>> destroy_entry = new HashMap<Character, List<String>>();
		ArrayList<ArrayList<Integer>> component = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> componentnew = new ArrayList<ArrayList<Integer>>();
		
		boolean[] check = new boolean[kingdom.length];
		String cost = "";
		
		int k = 0;
		boolean flag = false;
		while(!flag)
		{
			ArrayList<Integer> connected = new ArrayList<Integer>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(k);
			
			while(!temp.isEmpty())
			{
				int t = temp.remove(0);
				if(check[t] == false)
				{
					connected.add(t);
					check[t] = true;
					for (int i = 0; i < kingdom.length; i++) 
					{
						if(kingdom[t].charAt(i) == '1' && !temp.contains(i))
							temp.add(i);
					}
				}
			}
			component.add(connected);
			boolean decision = false;
			for (int i = 0; i < check.length; i++) 
			{
				if(check[i] == false)
				{
					k = i;
					decision = true;
					break;
				}
			}
			if(decision == false)
				flag = true;
		}
				
		for (int i = 0; i < build.length; i++) 
		{
			for (int j = i+1; j < build.length; j++) 
			{
				if(!build_entry.containsKey(build[i].charAt(j)))
				{
					List<String> list = new ArrayList<String>();
					list.add(i + "," + j);
					build_entry.put(build[i].charAt(j), list);
					continue;
				}
				List<String> values = build_entry.get(build[i].charAt(j));
				values.add(i + "," + j);
				build_entry.put(build[i].charAt(j), values);
			}
		}
		
		for (int i = 0; i < destroy.length; i++) 
		{
			for (int j = i+1; j < destroy.length; j++) 
			{
				if(!destroy_entry.containsKey(destroy[i].charAt(j)))
				{
					List<String> l = new ArrayList<String>();
					l.add(i+","+j);
					destroy_entry.put(destroy[i].charAt(j), l);
				}
				else
				{
					List<String> l = destroy_entry.get(destroy[i].charAt(j));
					l.add(i+","+j);
					destroy_entry.put(destroy[i].charAt(j), l);
				}
			}
		}
		
		for (int i = 0; i < kingdom.length; i++) 
		{
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(i);
			componentnew.add(l);
		}
		
		int p_index = -1;
		int q_index = -1;
		
		for (int i = 'z'; i >= 'A'; i--) 
		{
			if(i >= 91 && i <= 96)
				continue;
			
			if(destroy_entry.containsKey((char)i))
			{
				List<String> values = new ArrayList<String>();
	
				for (String string : destroy_entry.get((char)i)) 
				{
					int x = Integer.parseInt(string.substring(0, string.indexOf(",")));
					int y = Integer.parseInt(string.substring(string.indexOf(",")+1));
						
					for (int j = 0; j < componentnew.size(); j++) 
					{
						if(componentnew.get(j).contains(x))
							p_index = j;
						if(componentnew.get(j).contains(y))
							q_index = j;
					}
						
					if(kingdom[x].charAt(y) == '1' && p_index == q_index)
					{
						values.add(string);
						cost += destroy[x].charAt(y);
					}
					
					if(kingdom[x].charAt(y) == '1' && p_index != q_index)
					{
						int low = p_index < q_index? p_index: q_index;
						int high = p_index > q_index? p_index: q_index;
						ArrayList<Integer> temp1 = componentnew.remove(low);
						ArrayList<Integer> temp2 = componentnew.remove(high-1);
						temp1.addAll(temp2);
						componentnew.add(temp1);
						values.add(string);
					}
					
				}

				List<String> list = destroy_entry.get((char)i);
				for (String string : values) 
				{
					list.remove(string);
				}
				if(list.size() != 0)
					destroy_entry.put((char)i, list);
			}
		}

		int x_index = -1;
		int y_index = -1;
				
		for (int i = 'A'; i <= 'z'; i++) 
		{
			if(i >= 91 && i <= 96)
				continue;
			
			if(build_entry.containsKey((char)i))
			{
				for (String string : build_entry.get((char)i)) 
				{
					int x = Integer.parseInt(string.substring(0, string.indexOf(",")));
					int y = Integer.parseInt(string.substring(string.indexOf(",")+1));
					
					for (int j = 0; j < component.size(); j++) 
					{
						if(component.get(j).contains(x))
							x_index = j;
						if(component.get(j).contains(y))
							y_index = j;
					}
					
					if(x_index != y_index)
					{
						int low = x_index < y_index? x_index: y_index;
						int high = x_index > y_index? x_index: y_index;
						ArrayList<Integer> temp1 = component.remove(low);
						ArrayList<Integer> temp2 = component.remove(high-1);
						temp1.addAll(temp2);
						component.add(temp1);
						cost += build[x].charAt(y);
					}
				}
			}
		}
		
		int price = 0;
		for (int i = 0; i < cost.length(); i++) 
		{
			int c = cost.charAt(i);
			if(c < 91)
				price += (c - 65);
			if(c > 96)
				price += (c - 97 + 26);
		}
		return price;
	}
	
	public static void main(String[] args) 
	{
		String[] kingdom = //{"00100000000000", "00011101010000", "10000000001000", "01001000000000", "01010100000000", "01001001000000", "00000000000000", "01000100010000", "00000000000111", "01000001000000", "00100000000000", "00000000100011", "00000000100101", "00000000100110"};
		{"0000000000","0000000011","0001010000","0010010000","0000001000","0011000000","0000100000","0000000011","0100000101","0100000110"};
		String[] build =   //{"APGlansxjsZuGS", "PAjuBtTHdHDsGP", "GjARMyTGNOLYmF", "luRAYcCriVmAmL", "aBMYAXCYcCmmrF", "ntycXAMIkxCGyn", "sTTCCMAtFhuMyc", "xHGrYItAYbloIq", "jdNickFYAcvqPa", "sHOVCxhbcASucU", "ZDLmmCulvSArFu", "usYAmGMoqurAzo", "GGmmryyIPcFzAY", "SPFLFncqaUuoYA"};
		{"AhPEqkSFMM","hAfKPtsDad","PfAyGQkaqN","EKyAeLpRpm","qPGeASfNwo","ktQLSAnCAK","SskpfnAdJS","FDaRNCdAZz","MaqpwAJZAn","MdNmoKSznA"};
		String[] destroy = //{"AMyYCjXtDlipgy", "MAvHFVmBNZLTtk", "yvAMRSMaAaUEhL", "YHMALXDgafkxJU", "CFRLAoYnWaXvas", "jVSXoAajPfTAOh", "XmMDYaAtcmuhnl", "tBagnjtAIFHwWo", "DNAaWPcIAAvJXc", "lZafafmFAAXuJU", "iLUkXTuHvXAzxZ", "pTExvAhwJuzAtj", "gthJaOnWXJxtAh", "ykLUshlocUZjhA"};
		{"AgTqWWxEYH","gAXPgjzIRA","TXAleTmWvT","qPlAQkwxRO","WgeQAqgbJJ","WjTkqAiTzl","xzmwgiAuHb","EIWxbTuAwk","YRvRJzHwAn","HATOJlbknA"};
		
		System.out.println(getCost(kingdom, build, destroy));
	}

}
