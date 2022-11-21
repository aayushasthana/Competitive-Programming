import java.util.*;
import java.io.*;

public class RestStops {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("reststops.in"));
		PrintWriter w = new PrintWriter("reststops.out");
		
		long L = sc.nextInt();
		int N = sc.nextInt();
		long rf = sc.nextInt();
		long rb = sc.nextInt();
		
		long[][] posC = new long[N][2];
		for (int i=0; i<N; i++) {
			posC[i][0] = sc.nextInt();
			posC[i][1] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(posC, new Comparator<long[]>() {
		    public int compare(long[] a, long[] b) {
		        return Long.compare(a[1], b[1]);
		    }
		});

		
		long currPos = 0;
		long ans = 0;
		for (int i=N-1; i>=0; i--) {
			if (posC[i][0] > currPos) {
				ans += posC[i][1] * (posC[i][0] - currPos) * (rf - rb);
				currPos = posC[i][0];
			}
		}
		
		w.println(ans);
		
		w.close();
	}

}
