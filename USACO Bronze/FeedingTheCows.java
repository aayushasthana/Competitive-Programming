import java.util.*;
import java.io.*;

public class FeedingTheCows {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter w = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for (int a=0; a<T; a++) {
			//inputs
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			char[] retval = new char[N];
			
			//place g's
			long gCount = 0;
			for (int i=0; i<N; i++) {
				if (input.charAt(i) == 'G') {
					int gIndex = Math.min(N-1, i+K);
					retval[gIndex] = 'G';
					gCount++;
					i = Math.min(N-1, gIndex + K);
				}
			}
			
			//place h's
			long hCount = 0;
			for (int i=0; i<N; i++) {
				if (input.charAt(i) == 'H') {
					int hIndex = Math.min(N-1, i+K);
					if (hIndex == N-1 && retval[N-1] == 'G') {
						hIndex--;
						retval[hIndex] = 'H';
						hCount++;
						break;
					} else {
						retval[hIndex] = 'H';
						hCount++;
						i = Math.min(N-1, hIndex + K);
					}
				}
			}
			
			w.println(gCount + hCount);
			for (int i=0; i<N; i++) {
				if (i==N-1) {
					if (retval[i] == '\u0000') w.println('.');
					else w.println(retval[i]);
				}
				
				else {
					if (retval[i] ==  '\u0000') w.print('.');
					else w.print(retval[i]);
				}
			}
		}
		
		w.close();
	}
}
