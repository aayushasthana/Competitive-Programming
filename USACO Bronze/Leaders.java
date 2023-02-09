import java.util.*;

public class Leaders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String cows = sc.next();
		int[] listMax = new int[N+1];
		for (int i=1; i<N+1; i++) listMax[i] = sc.nextInt();
		sc.close();
		
		int firstG = Integer.MAX_VALUE;
		int firstH = Integer.MAX_VALUE;
		int lastG = Integer.MAX_VALUE;
		int lastH = Integer.MAX_VALUE;
		boolean gFound = false;
		boolean hFound = false;
		
		//finding last index of g and h
		for (int i=N; i>0; i--) {
			if (cows.charAt(i-1) == 'G' && !gFound) {
				lastG = i;
				gFound = true;
			}
			
			else if (cows.charAt(i-1) == 'H' && !hFound) {
				lastH = i;
				hFound = true;
			}
		}
		
		
		//finding first leaders
		for (int i=1; i<N+1; i++) {
			if (cows.charAt(i-1) == 'G') {
				if (listMax[i] >= lastG) {
					firstG = i;
				}
				break;
			}
			
			
		}

		for (int i=1; i<N+1; i++) {
			if (cows.charAt(i-1) == 'H') {
				if (listMax[i] >= lastH) {
					firstH = i;
				}
				break;
			}
		}
		
		//find other "sub" leaders
		Set<ArrayList<Integer>> leaderPairs = new HashSet<ArrayList<Integer>>();
		for (int i=1; i<N+1; i++) {
			if (cows.charAt(i-1) == 'G' && i< firstH && listMax[i] >= firstH && firstH != Integer.MAX_VALUE) {
				ArrayList<Integer> pair = new ArrayList<Integer>();
				pair.add(i);
				pair.add(firstH);
				leaderPairs.add(pair);
			}
			
			if (cows.charAt(i-1) == 'H' && i< firstG && listMax[i] >= firstG && firstG != Integer.MAX_VALUE) {
				ArrayList<Integer> pair = new ArrayList<Integer>();
				pair.add(i);
				pair.add(firstG);
				leaderPairs.add(pair);
			}
		}
		
		//add the original pair if it exists
		if (firstG != Integer.MAX_VALUE && firstH != Integer.MAX_VALUE) {
			ArrayList<Integer> pair = new ArrayList<Integer>();
			pair.add(firstH);
			pair.add(firstG);
			Collections.sort(pair); //sorting because g can come after h and vice versa
			leaderPairs.add(pair);
		}
		
		System.out.println(leaderPairs.size());
	}

}
