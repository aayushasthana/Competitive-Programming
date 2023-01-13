import java.util.*;
import java.io.*;

public class WDTCCTR2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("maxcross.in"));
		PrintWriter w = new PrintWriter("maxcross.out");
		
		int N = sc.nextInt();
		int K = sc.nextInt(); //in order for there to be a contiguous block of K working signals somewhere along the road.
		int B = sc.nextInt(); //The next B lines each describe the ID number of a broken signal.
		
		boolean[] broken = new boolean[N];
		for (int i=0; i<B; i++) broken[sc.nextInt()-1] = true;
		
		int curr = 0;
		for (int i=0; i<K; i++) {
			if (broken[i]) curr++;
		}
		
		int min = curr;
		int a = 0;
		for (int i=K; i<N; i++) {
			if (broken[i]) curr++;
			if (broken[a]) curr--;
			a++;
			min = Math.min(curr, min);
		}
		
		w.println(min);
		
		w.close();
		sc.close();
	}

}
