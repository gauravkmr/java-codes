import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;


public class TournamentRanker 
{
	public static String[] rankTeams(String[] names, String[] lostTo)
	{
		Hashtable<String, String> table = new Hashtable<String, String>();
		for (int i = 0; i < names.length; i++) 
			table.put(names[i], lostTo[i]);
		
		String[] TeamsByRank = new String[names.length];
		ArrayList<String> rank = new ArrayList<String>();
		
		findRanks(names, table, rank);	
		
		return rank.toArray(TeamsByRank);
	}
	
	public static void findRanks(String[] names, Hashtable<String, String> table, ArrayList<String> rank)
	{
		if(names.length == 1)
			return;
		
//		int currIndex = 0;
		int[] winners = new int[names.length/2];
		int[] losers = new int[names.length/2];
		int cnt = 0;
		
		for (int i = 0; i < names.length; i += 2) 
		{
			if(table.get(names[i]) == names[i+1])
			{
				winners[cnt] = i+1;
				losers[cnt] = i;
				cnt++;
			}
			if(table.get(names[i+1]) == names[i])
			{
				winners[cnt] = i;
				losers[cnt] = i+1;
				cnt++;
			}
		}
//		for (int i = 0; i < losers.length; i++) 
//		{
//			System.out.println(winners[i] + "," + losers[i]);
//		}
		
		if(winners.length == 1)
		{
//			rank[currIndex] = names[winners[0]];
//			rank[currIndex+ 1] = names[losers[0]];
//			currIndex += 2;
			rank.add(names[winners[0]]);
			rank.add(names[losers[0]]);
//			System.out.println(winners[0] + "," + losers[0]);
		}
		else
		{
			String[] winnersNames = new String[winners.length];
			for (int i = 0; i < winners.length; i++) 
				winnersNames[i] = names[winners[i]];
			
			findRanks(winnersNames, table, rank);
			
//			for (int i = 0; i < losers.length; i++) 
//			{
//				System.out.println(winners[i] + "," + losers[i]);
//			}
			
			HashMap<Integer, String> losersList = new HashMap<Integer, String>();
			for (int i = 0; i < losers.length; i++) 
				losersList.put(rank.indexOf(winnersNames[i]), names[losers[i]]);
			
			for (int i = 0; i < losers.length; i++)
				rank.add(losersList.get(i));
		}
		
	}
	
	public static void main(String[] args) 
	{
		String[] names = {"JAVA", "VISUAL BASIC"};//{"RODDICK", "SCHUETTLER", "FERREIRA", "AGASSI"};//{"DUKE", "SETON HALL", "ILLINOIS", "CINCINNATI", "NORTH CAROLINA", "TEXAS", "XAVIER", "MISSISSIPPI STATE"};
		
		String[] lostTo = {"VISUAL BASIC", ""};//{"SCHUETTLER", "AGASSI", "AGASSI", ""};//{"", "DUKE", "DUKE", "ILLINOIS", "TEXAS", "XAVIER", "DUKE", "XAVIER"};
		
		String[] rankList = rankTeams(names, lostTo);
		for (String string : rankList) 
		{
			System.out.println(string);
		}
	}

}
