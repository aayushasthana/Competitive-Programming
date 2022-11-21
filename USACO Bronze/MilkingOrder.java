import java.io.*;
import java.util.*;

public class MilkingOrder {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("milkorder.in"));
		PrintWriter w = new PrintWriter("milkorder.out");
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		Integer[] cows = new Integer[N+1];
		int[] hierachy = new int[M];
		boolean[] hierachyPlaced = new boolean[M];
		
		cows[0] = -1;
		for (int i=1; i<N+1; i++) {
			cows[i] = 0;
		}
		
		for (int i=0; i<M; i++) {
			hierachy[i] = sc.nextInt();
			if (hierachy[i] == 1) {
				hierachyPlaced[i] = true;
			}
		}
		
		for (int i=0; i<K; i++) {
			int cow = sc.nextInt();
			int pos = sc.nextInt();
			
			if (cow == 1) {
				w.println(pos);
				w.close();
				System.exit(0);
			}
			
			cows[pos] = cow;
			
			for (int j=0; j<M; j++) {
				if (cow == hierachy[j]) {
					hierachyPlaced[j] = true;
				}
			}
		}

		ArrayList<Integer> possible1 = new ArrayList<Integer>();
		for (int i=1; i<N+1; i++) {
			if (cows[i] == 0) {
				possible1.add(i);
			}
		}
		
		ArrayList<Integer[]> possibleCows = new ArrayList<Integer[]>();
		for (int i=0; i<possible1.size(); i++) {
			Integer[] curr = new Integer[N+1];
			for (int j=0; j<N+1; j++) {
				curr[j] = cows[j];
			}
			
			curr[possible1.get(i)] = 1;
			
			int hierachyIndex = 0;
			
			for (int j=0; j<N+1 && hierachyIndex < M; j++) {
				if (hierachyPlaced[hierachyIndex]) {
					hierachyIndex++;
				}
				
				else if (curr[j] == 0) {
					curr[j] = hierachy[hierachyIndex];
					hierachyIndex++;
				}
			}
			
			possibleCows.add(curr);
			
		}
		
		int min1Position = Integer.MAX_VALUE;
		
		for (int i=0; i<possibleCows.size(); i++) {
			int position1 = -1;
			int hierachyValue = hierachy[0];
			int hierachyIndex = 0;
			Integer[] curr = possibleCows.get(i);
			
			for (int j=0; j<curr.length; j++) {
				if (curr[j] == hierachyValue) {
					hierachyIndex++;
					if (hierachyIndex == M) {
						System.out.println("BREAK");
						break;
					}
					hierachyValue = hierachy[hierachyIndex];
					
				}
			}
			
			for (int j=0; j<curr.length; j++) {
				if (curr[j] == 1) {				
					position1 = j;
				}
			}
			
			if (hierachyIndex == M) {
				min1Position = Math.min(position1, min1Position);
			}
		}
		
		System.out.println(min1Position);
		w.println(min1Position);
		w.close();
	}

}
