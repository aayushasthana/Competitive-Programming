import java.util.*;
import java.io.*;

public class CowJog {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("cowjog.in"));
		PrintWriter w = new PrintWriter(new File("cowjog.out"));
		int N = sc.nextInt();
		int T = sc.nextInt();
		
		//0 = position, 1 = speed
		long[][] posSpeed = new long[N][2];
		long[] endPos = new long[N];
		
		for (int i=0; i<N; i++) {
			posSpeed[i][0] = sc.nextLong();
			posSpeed[i][1] = sc.nextLong();
			endPos[i] = T * posSpeed[i][1] + posSpeed[i][0];
		}
		
		Arrays.sort(posSpeed, new Comparator<long[]>() {
		    public int compare(long[] a, long[] b) {
		        return Long.compare(a[0], b[0]);
		    }
		});
		
		int groups = 0;
		long currEnd = Long.MAX_VALUE;
		
		for (int i=N-1; i>=0; i--) {
			if (endPos[i] < currEnd) {
				groups++;
				currEnd = endPos[i];
			}
		}
		
		w.println(groups);
		w.close();
		
		sc.close();
	}

}
