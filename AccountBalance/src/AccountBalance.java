
public class AccountBalance 
{
	public static int processTransactions(int startingBalance, String[] transactions)
	{
		for (String string : transactions) 
		{
			String type = string.substring(0, 1);
			int amount = Integer.parseInt(string.substring(2));
			
			if(type.compareTo("C") == 0)
				startingBalance += amount;
			else if (type.compareTo("D") == 0) 
				startingBalance -= amount;
			else
			{
				System.out.println("invalid transaction");
				break;
			}
		}
		return startingBalance;
	}
	
	public static void main(String[] args) 
	{
		int startingBalance = 53874;
		String[] transactions = {"D 1234", "C 987", "D 2345", "C 654", "D 6789", "D 34567"};
		
		System.out.println("final balance: " + processTransactions(startingBalance, transactions));
	}

}
