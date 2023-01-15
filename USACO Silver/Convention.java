import java.util.*;
import java.io.*;

public class Convention {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("convention.in"));
		PrintWriter w = new PrintWriter("convention.out");
		
		int N = sc.nextInt();
		long buses = sc.nextLong();
		long cowsPerBus = sc.nextLong();
		long[] times = new long[N];
		for (int i=0; i<N; i++) times[i] = sc.nextLong();
		Arrays.sort(times);
		
		sc.close();
		
		long a = 1;
		long b = 500000000;
		while (a!=b) {
			long mid = (a+b)/2;
			if (works(mid, buses, cowsPerBus, times)) {
				b = mid;
			} else {
				a = mid+1;
			}
		}
		
		w.println(a);
		
		w.close();
	}
	
	public static boolean works(long time, long buses, long cowsPerBus, long[] t) {
		int currMin = 0;
		long busCount = 0;
		long currCows = 0;
		
		for (int i=0; i<t.length; i++) {
			currCows++;
			if (currCows > cowsPerBus || t[i] - t[currMin] > time) {
				busCount++;
				currCows = 1;
				currMin = i;
			}
		}
		busCount++;
		
		return busCount <= buses;
	}

}
