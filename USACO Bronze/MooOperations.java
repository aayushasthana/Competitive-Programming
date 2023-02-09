import java.util.*;

public class MooOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int Q = sc.nextInt();
		
		for (int q=0; q<Q; q++) {
			String cows = sc.next();
			int N = cows.length();
			
			boolean mooPresent = false;
			boolean momPresent = false;
			boolean oooPresent = false;
			boolean oomPresent = false;
			
			for (int i=0; i<N-2; i++) {
				if (cows.substring(i, i+3).equals("MOO")) mooPresent = true;
				if (cows.substring(i, i+3).equals("MOM")) momPresent = true;
				if (cows.substring(i, i+3).equals("OOO")) oooPresent = true;
				if (cows.substring(i, i+3).equals("OOM")) oomPresent = true;
			}
			
			if (mooPresent) System.out.println(N-3);
			else if (momPresent || oooPresent) System.out.println(N-3+1);
			else if (oomPresent) System.out.println(N-3+2);
			else System.out.println(-1);
		}
		
		sc.close();
	}

}
