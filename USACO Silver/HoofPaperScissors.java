import java.util.*;
import java.io.*;

public class HoofPaperScissors {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("hps.in"));
		PrintWriter w = new PrintWriter("hps.out");
		
		int N = sc.nextInt();
		int hT = 0;
		int pT = 0;
		int sT = 0;
		int[] h = new int[N+1];
		int[] p = new int[N+1];
		int[] s = new int[N+1];
		char[] plays = new char[N+1];
		for (int i=1; i<N+1; i++) {
			plays[i] = sc.next().charAt(0);
			if (plays[i] == 'H') hT++;
			else if (plays[i] == 'P') pT++;
			else sT++;
			
			h[i] = hT;
			p[i] = pT;
			s[i] = sT;
		}
		
		sc.close();
		
		List<Integer> intersections = new ArrayList<Integer>();
		char curr = plays[1];
		for (int i=1; i<N; i++) {
			if (plays[i+1] != curr) {
				intersections.add(i+1);
				curr = plays[i+1];
			}
		}
		
		int count = 0;
		for (int i=0; i<intersections.size(); i++) {
			int val1 = 0;
			if (plays[intersections.get(i)-1] == 'H') val1 = h[intersections.get(i)-1];
			if (plays[intersections.get(i)-1] == 'P') val1 = p[intersections.get(i)-1];
			if (plays[intersections.get(i)-1] == 'S') val1 = s[intersections.get(i)-1];
			int val2 = 0;
			if (plays[intersections.get(i)] == 'H') val2 = hT - h[intersections.get(i)] + 1;
			if (plays[intersections.get(i)] == 'P') val2 = pT - p[intersections.get(i)] + 1;
			if (plays[intersections.get(i)] == 'S') val2 = sT - s[intersections.get(i)] + 1;
			count = Math.max(count, val1 + val2);
		}
		
		count = Math.max(count, Math.max(hT, Math.max(pT, sT)));
		w.println(count);
		
		w.close();
	}

}
