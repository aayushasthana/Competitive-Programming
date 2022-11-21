import java.util.*;
import java.io.*;

public class SocialDistancingI {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("socdist2.in"));
		PrintWriter w = new PrintWriter("socdist2.out");
		
		int N = sc.nextInt();
		int[] positions = new int[N];
		HashMap<Integer, Integer> isSick = new HashMap<Integer, Integer>();
		
		for (int i=0; i<N; i++) {
			positions[i] = sc.nextInt();
			isSick.put(positions[i], sc.nextInt());
		}
		
		sc.close();
		
		Arrays.sort(positions);
		
		/*
		 Sort positions array
		 R=0;
		 Finding R:
		 	iterate through positions:
		 		if (1 to 0 or 0 to 1):
		 			add possible value of r;
		 
		 */
		
		int R = N;
		ArrayList<Integer> possibleR = new ArrayList<Integer>();
		possibleR.add(N);
		
		for (int i=0; i<N-1; i++) {
			
			if ((isSick.get(positions[i+1]) == 0) && (isSick.get(positions[i]) == 1)) {
				possibleR.add(positions[i+1]-positions[i]);

			} 
			
			else if ((isSick.get(positions[i+1]) == 1) && (isSick.get(positions[i]) == 0)) {
				possibleR.add(positions[i+1]-positions[i]);

			}
		}
		
		R = Collections.min(possibleR);
		System.out.println(R);
		
		/*
		 int Sections = 0;
		 deal with lasts
		 iterate through positions array-1:
		 	if (isSick.get(positions[i])) == 0):
		 		sections++;
		 	else if ( (positions[i+1]-positions[i]) > R) :
		 		sections++;
		 */
		
		int sections = 0;
		for (int i=0; i<N; i++) {
			if (i == N-1) {
				if (isSick.get(positions[i]) == 0) {
					continue;
				} else {
					sections++;
				}
			}
			
			else if (isSick.get(positions[i]) == 0) {
				continue;
			}
			
			else if ((positions[i+1]-positions[i]) >= R) {
				sections++;
			}
		}
		
		w.println(sections);
		
		w.close();
	}

}
