import java.util.HashMap;


public class DukeOnChessBoard 
{
	public static String dukePath(int n, String initPosition)
	{
		if(n < 1 || initPosition == null)
			return "";
		int x = initPosition.charAt(0) - 96;
		int y = Integer.parseInt(initPosition.substring(1));
		
		if(x > n || x < 1 || y > n || y < 1)
			return "";
		
		boolean board[][] = new boolean[n][n];
		
		HashMap<Integer, Character> charMap = new HashMap<Integer, Character>();
		for (int i = 1; i <= n; i++) 
		{
			charMap.put(i, (char)(i + 96));
		}
		
		
		
		board[x-1][y-1] = true;

		return findPath(board, x, y, initPosition, charMap);
	}
	
	public static String findPath(boolean board[][], int x, int y, String path, HashMap<Integer, Character> charMap)
	{
		while(true)
		{
			if((x+1) <= board.length && board[x][y-1] == false)
			{
				board[x][y-1] = true;
				String temp = "-" + charMap.get(x+1) + y;
				path = path + temp;
				x = x + 1;
			}
			else if((y+1) <= board.length && board[x-1][y] == false)
			{
				board[x-1][y] = true;
				String temp = "-" + charMap.get(x) + (y+1);
				path = path + temp;
				y = y + 1;
			}
			else if((y-1) >= 1 && board[x-1][y-2] == false)
			{	
				board[x-1][y-2] = true;
				String temp = "-" + charMap.get(x) + (y-1);
				path = path + temp;
				y = y - 1;
			}
			else if((x-1) >= 1 && board[x-2][y-1] == false)
			{
				board[x-2][y-1] = true;
				String temp = "-" + charMap.get(x-1) + y;
				path = path + temp;
				x = x - 1;
			}
			else
				break;
		}
		
		return path;
	}
	
	public static void main(String[] args) 
	{
		String path = dukePath(8, "a8");
		if(path.length() > 40)
			path = path.substring(0, 20) + "..." + path.substring(path.length() - 20);
		if(path.length() == 0)
			path = "invalid input";
		System.out.println(path);
	}

}
