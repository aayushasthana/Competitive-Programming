import java.io.*;
import java.util.*;

public class DiamondCollector {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("diamond.in"));
		PrintWriter w = new PrintWriter("diamond.out");
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
	
		int[] diamonds = new int[N];
		for (int i=0; i<N; i++) {
			diamonds[i] = sc.nextInt();
		}
		
		Arrays.sort(diamonds);
		
		
		int count = 0;
		
		ArrayList<Integer> pCount = new ArrayList<Integer>();
		
		for (int i=0; i<N ; i++) {
			
			for (int j=i+1; j<N;j++) {
				if(Math.abs(diamonds[i] - diamonds[j]) <= K) {
					count++;
				}
				
			}
			
			pCount.add(count);
			count = 0;
		}
				
		w.println(Collections.max(pCount)+1);
		w.close();
	}

}
