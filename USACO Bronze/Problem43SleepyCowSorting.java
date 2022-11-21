import java.util.*;
import java.io.*;

public class Problem43SleepyCowSorting {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("sleepy.in"));
		PrintWriter w = new PrintWriter("sleepy.out");
		
		int N = sc.nextInt();
		int[] cows = new int[N+1];
		cows[0] = -1;
		
		for (int i=1; i<N+1; i++) {
			cows[i] = sc.nextInt();
		}
		
		sc.close();
		
		for (int i=1; i<N+1; i++) {
			System.out.print(cows[i]+" ");
		}
		
		System.out.println();
		System.out.println(N);
		
		int sortedAlready = 0;
		int prev = 101;
		for (int i=N; i>0; i--) {
			if (cows[i] < prev) {
				sortedAlready++;
				prev = cows[i];
			}
			
			else {
				break;
			}
		}
		
		w.println(N-sortedAlready);
		
		w.close();
	}

}
