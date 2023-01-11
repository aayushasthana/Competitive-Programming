import java.io.*;
import java.util.*;

public class SubsequencesSummingToSevens {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("div7.in"));
		PrintWriter w = new PrintWriter("div7.out");
		
		int N = sc.nextInt();
		long total = 0;
		long[] nums = new long[N];
		long[] p = new long[N];
		for (int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
			total += nums[i];
			p[i] = total%7;
		}
		
		sc.close();
		
		int maxRange = 0;
		for (int i=0; i<7; i++) {
			int min = Integer.MIN_VALUE;
			int max = Integer.MIN_VALUE;
			for (int j=0; j<N; j++) {
				if (p[j] == i) {
					min = j;
					break;
				}
			}
			
			for (int j=N-1; j>=0; j--) {
				if (p[j] == i) {
					max = j;
					break;
				}
			}
			
			maxRange = Math.max(maxRange, max-min);
		}
		
		w.println(maxRange);
		
		w.close();
	}

}
