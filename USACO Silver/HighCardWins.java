import java.util.*;
import java.io.*;

public class HighCardWins {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("highcard.in"));
		PrintWriter w = new PrintWriter("highcard.out");
		
		int N = sc.nextInt();
		int[] ec = new int[N+1];
		HashSet<Integer> ec2 = new HashSet<Integer>();
		int[] bc = new int[N+1];
		ec[N] = Integer.MAX_VALUE;
		bc[N] = Integer.MAX_VALUE;
		
		for (int i=0; i<N; i++) {
			ec[i] = sc.nextInt();
			ec2.add(ec[i]);
		}
		
		Arrays.sort(ec);
		
		int bcIndex = 0;
		for (int i=1; i<2*N+1; i++) {
			if (ec2.contains(i)) {
				continue;
			} else {
				bc[bcIndex] = i;
				bcIndex++;
			}
		}
		
		System.out.println(bc[0] + " " + bc[1] + " " + bc[2]);
		
		int ans = 0;
		bcIndex = N-1;
		for (int i=N-1; i>=0; i--) {
			if (ec[i] < bc[bcIndex]) {
				ans++;
				bcIndex--;
			}
		}
		
		sc.close();
		
		w.println(ans);

		w.close();
	}

}
