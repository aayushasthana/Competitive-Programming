import java.util.*;
import java.io.*;

public class AutoComplete {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("auto.in"));
		PrintWriter pw = new PrintWriter("auto.out");
		
		//inputs
		int W = sc.nextInt();
		int N = sc.nextInt();
		Pair<String, Integer>[] words = new Pair[W+1];
		words[0] = new Pair("-1", -1);
		for (int i=1; i<W+1; i++) {
			words[i] = new Pair(sc.next(), i);
		}
		
		//sort words alphabetically
		Arrays.sort(words, new Comparator<Pair>() {
		   @Override
		   public int compare(Pair p1, Pair p2) {
		       return ((String) p1.first).compareTo((String) p2.first);
		   }
		});
		
		for (int i=0; i<N; i++) {
			int K = sc.nextInt();
			String curr = sc.next();
			
			int minRange = 1;
			int maxRange = W;
			
			for (int j=0; j<curr.length(); j++) {	
				int minA = minRange;
				int minB = maxRange;
				
				//find lowerbound
				while (minA < minB) {
					int mid = (minA+minB)/2;
					if (words[mid].first.length() > j && words[mid].first.charAt(j) >= curr.charAt(j)) {
						minB = mid;	
					} else {
						minA = mid+1;
					}
				}
				
				int maxA = minRange;
				int maxB = maxRange;
				
				//find upperbound
				while (maxA < maxB) {
					int mid = (maxA+maxB+1)/2;
					if (words[mid].first.length() > j && words[mid].first.charAt(j) <= curr.charAt(j)) {
						maxA = mid;
					} else {
						maxB = mid-1;
					}
				}
				
				minRange = minA;
				maxRange = maxA;
			}			
			
			//check for one word case first
			if (minRange == maxRange && K==1) { 
				if (words[minRange].first.contains(curr)) pw.println(words[minRange].second);
				else pw.println(-1);
			} else if (minRange + K - 1 <= maxRange) {
				pw.println(words[minRange + K - 1].second);
			} else {
				pw.println(-1);
			}
		}
		
		pw.close();
	}
	
	static class Pair<K, V> {
		K first;
		V second;

		public Pair(K first_value, V second_value) {
			first = first_value;
			second = second_value;
		}
	}
}
