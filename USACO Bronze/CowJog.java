import java.io.*;
import java.util.*;

public class CowJog {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new File("cowjog.in"));
		PrintWriter w = new PrintWriter(new File("cowjog.out"));
		int N = sc.nextInt();
		
		//0 = position, 1 = speed
		long[][] posSpeed = new long[N][2];
		
		for (int i=0; i<N; i++) {
			posSpeed[i][0] = sc.nextLong();
			posSpeed[i][1] = sc.nextLong();
		}
		
		Arrays.sort(posSpeed, new Comparator<long[]>() {
		    public int compare(long[] a, long[] b) {
		        return Long.compare(a[0], b[0]);
		    }
		});
		
		long currSpeed = Integer.MAX_VALUE;
		int groups = 0;
		for (int i=N-1; i>=0; i--) {
			if (posSpeed[i][1] <= currSpeed) {
				groups++;
				currSpeed = posSpeed[i][1];
			}
		}
		
		w.println(groups);
		w.close();
	}

}
