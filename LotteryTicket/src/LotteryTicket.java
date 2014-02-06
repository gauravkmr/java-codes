
public class LotteryTicket 
{
	public static String buy(int price, int b1, int b2, int b3, int b4)
	{
		if(price == b1 || price == b2 || price == b3 || price == b4)
			return "possible";
		if(buy(price-b1, b1, b2, b3, b4) == "possible")
			return "possible";
		if(buy(price-b2, b1, b2, b3, b4) == "possible")
			return "possible";
		if(buy(price-b3, b1, b2, b3, b4) == "possible")
			return "possible";
		if(buy(price-b4, b1, b2, b3, b4) == "possible")
			return "possible";
		return "impossible";
	}
	
	public static void main(String[] args) 
	{
		System.out.println(buy(10, 1, 2, 3, 4));
	}

}
