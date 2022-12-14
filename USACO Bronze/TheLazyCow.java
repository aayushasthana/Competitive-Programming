import java.util.*;
import java.io.*;

public class TheLazyCow {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("lazy.in"));
		PrintWriter w = new PrintWriter("lazy.out");
		
		long[] grass = new long[1000001];
		int N = sc.nextInt();
		int K = sc.nextInt();
		for (int i=0; i<N; i++) {
			long g = sc.nextLong();
			int p = sc.nextInt();
			grass[p+1] = g;
		}
		
		long[] grassTillNow = new long[1000001];
		long tot = 0;
		for (int i=0; i<grass.length; i++) {
			tot += grass[i];
			grassTillNow[i] = tot;
		}
		
		long maxGrass = 0;
		for (int i=1; i<grassTillNow.length; i++) {
			int radmin = Math.max(i-K, 1);
			int radmax = Math.min(i+K, grass.length-1);
			long curr = grassTillNow[radmax] - grassTillNow[radmin-1];
			maxGrass = Math.max(curr, maxGrass);
		}
		
		w.println(maxGrass);
		w.close();
	}

}
