import java.util.*;
import java.io.*;

public class BreedCounting {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("bcount.in"));
		PrintWriter w = new PrintWriter("bcount.out");
		
		int N = sc.nextInt();
		int Q = sc.nextInt();
		int[] p1 = new int[N+1];
		int[] p2 = new int[N+1];
		int[] p3 = new int[N+1];
		p1[0] = 0;
		p2[0] = 0;
		p3[0] = 0;
		int p1Total = 0;
		int p2Total = 0;
		int p3Total = 0;
		for (int i=1; i<N+1; i++) {
			int curr = sc.nextInt();
			if (curr == 1) {
				p1Total++;
			} else if (curr == 2) {
				p2Total++;
			} else {
				p3Total++;
			}
			
			p1[i] = p1Total;
			p2[i] = p2Total;
			p3[i] = p3Total;
		}
		
		for (int i=0; i<Q; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			w.println((p1[b]-p1[a-1]) + " " + (p2[b]-p2[a-1]) + " " + (p3[b]-p3[a-1]));
		}
		
		sc.close();
		
		w.close();
	}

}
