
public class advertisingAgency {

	public static int numberOfRejections(int[] requests){
		
		boolean[] initialState = new boolean[100];
		int count = 0;
		
		for (int i = 0; i < requests.length; i++) {
			
			if(!initialState[requests[i]]){
				initialState[requests[i]] = true;
				count++;
			}
			
		}
		
		return requests.length - count;
	}
	
	public static void main(String args[]){
		int[] a = {1,4,5,5,7,55,2,33,44,44,5,5,44,33};
		
		advertisingAgency agency = new advertisingAgency();
		
		int i = agency.numberOfRejections(a);
		
		System.out.println(i);
		
		int w = -1>>>1;
		System.out.println(w);
	}
}
