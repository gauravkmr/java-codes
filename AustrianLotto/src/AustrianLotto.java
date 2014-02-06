import java.lang.String;

public class AustrianLotto {
	
	int[] evaluate(String drawing, String[] picks){
		
		int[] res = new int[7];
		
		drawing = " " + drawing + " ";
		
		
		for (int i = 0; i < picks.length; i++) {
			int count = 0;
			String[] str = picks[i].split(" ");
			
			for (int j = 0; j < str.length; j++) {
				if(drawing.indexOf(" " + str[j] + " ") >= 0)
					count++;
			}
			res[count]++;
		}
		
		return res;
	}
	
	public static void main(String args[]){
		
		String drawing = "3 11 18 23 37 45";
		String[] picks = {"4 7 14 30 33 35", "1 11 12 25 37 38", "11 18 19 20 21 22"};
		
		AustrianLotto al = new AustrianLotto();
		int[] res = al.evaluate(drawing, picks);
		
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	
	}

}
