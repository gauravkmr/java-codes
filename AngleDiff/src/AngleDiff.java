import java.util.*;


public class AngleDiff 
{
	public static int getMinuteAngle(int min)
	{
		return 360*min/60;
	}
	
	public static int getHourAngle(int hour, int min)
	{
		int angle1 = 360*(hour%12)/12;
		int angle2 = (360/12)*min/60;
		
		return angle1+angle2;
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("enter hours");
		int hr = in.nextInt();
		System.out.println("enter minutes");
		int min = in.nextInt();
		
		in.close();
		
		int diff = getHourAngle(hr, min) - getMinuteAngle(min);
		System.out.println("difference between hour and minute hand is: " + diff);
	}

}
