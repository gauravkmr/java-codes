import java.util.Random;

public class diceFrequency {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random dice = new Random();
		int freq[] = new int[7];
		
		for (int roll = 1; roll <= 1000; roll++) {
//			++freq[ 1 + dice.nextInt(6) ];
			int temp = dice.nextInt(6);
			++freq[1 + temp];
		}
		
		System.out.println("face\tfrequency");
		
		for (int face = 1; face < freq.length; face++) {
			System.out.println(face + "\t" + freq[face]);
		}
	}

}
