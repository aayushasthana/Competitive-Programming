import java.util.*;
import java.io.*;

public class PairedUp {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("pairup.in"));
		PrintWriter w = new PrintWriter("pairup.out");
		
		int N = sc.nextInt();
		long[][] times = new long[N][2];
		for (int i=0; i<N; i++) {
			times[i][0] = sc.nextLong();
			times[i][1] = sc.nextLong();
		}
		
		
		
		Arrays.sort(times, new Comparator<long[]>() {
		    public int compare(long[] a, long[] b) {
		        return Long.compare(a[1], b[1]);
		    }
		});
		
		
		int leftP = 0;
		int rightP = N-1;
		long maxTime = 0;
		while (leftP <= rightP) {
			if (times[leftP][0] == times[rightP][0]) {
				long currTime = times[leftP][1] + times[rightP][1];
				maxTime = Math.max(maxTime, currTime);
				long temp = times[leftP][0];
				times[leftP][0] -= temp;
				times[rightP][0] -= temp;
				leftP++;
				rightP--;
			} else if (times[leftP][0] < times[rightP][0]) {
				long currTime = times[leftP][1] + times[rightP][1];
				maxTime = Math.max(maxTime, currTime);
				times[rightP][0] -= times[leftP][0];
				leftP++;
			} else {
				long currTime = times[leftP][1] + times[rightP][1];
				maxTime = Math.max(maxTime, currTime);
				times[leftP][0] -= times[rightP][0];
				rightP--;
			}
		}
		
		w.println(maxTime);
		
		sc.close();
		w.close();
	}

}
