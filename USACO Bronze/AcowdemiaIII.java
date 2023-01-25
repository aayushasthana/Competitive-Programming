import java.util.*;
import java.io.*;

public class AcowdemiaIII {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter w = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] grid = new char[N+2][M+2];
		
		for (int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			String curr = st.nextToken();
			for (int j=1; j<M+1; j++) {
				grid[i][j] = curr.charAt(j-1);
			}
		}
		
		int grass34 = 0; //grasses with 3 or 4 cows next to them
		Set<ArrayList<ArrayList<Integer>>> grass2 = new HashSet<ArrayList<ArrayList<Integer>>>(); //pairs of cows, when a grass has 2 cows next to it
		
		//right, left, up, down
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		for (int i=1; i<N+1; i++) {
			for (int j=1; j<M+1; j++) {
				if (grid[i][j] == 'G') {
					ArrayList<ArrayList<Integer>> currCows = new ArrayList<ArrayList<Integer>>();
					
					for (int k=0; k<4; k++) {
						if (grid[i+dy[k]][j+dx[k]] == 'C') {
							ArrayList<Integer> curr = new ArrayList<Integer>();
							curr.add(i+dy[k]);
							curr.add(j+dx[k]);
							currCows.add(curr);
						}
					}
					
					if (currCows.size() > 2) grass34++;
					else if (currCows.size() == 2) {
						ArrayList<ArrayList<Integer>> currCowsReversed = new ArrayList<ArrayList<Integer>>();
						currCowsReversed.add(currCows.get(1));
						currCowsReversed.add(currCows.get(0));
						if (grass2.contains(currCows) || grass2.contains(currCowsReversed)) {
							continue;
						} else {
							grass2.add(currCows);
						}
					}
				}
			}
		}
		
		w.println(grass34 + grass2.size());
		w.close();
	}
}

