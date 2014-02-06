import java.util.Scanner;

public class apples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		double fnum, snum, ans;
		
		System.out.println("Enter first number:");
		fnum = scan.nextDouble();
		System.out.println("Enter second number:");
		snum = scan.nextDouble();
		
		ans = fnum + snum;
		System.out.println("Sum is: " + ans);
		
		ans = fnum * snum;
		System.out.println("Product is: " + ans);
		
		System.out.println(average(1,2,3,4,5,6,7,8,9,10) );
*/
		
		roses r = new roses(5, 34, 55);
		
//		System.out.println(r.toMilitary());
//		r.setTime(13, 44, 58);
		System.out.println(r.toMilitary());
		System.out.println(r.toRegular());
	
	}
	
	public static int average(int...numbers){
		int total = 0;
		
		for(int x : numbers){
			total += x;
		}
		
		return total/numbers.length;
	}

}
