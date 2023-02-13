import java.util.*;
import java.io.*;

public class BovineGenomics {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
		PrintWriter w = new PrintWriter("cownomics.out");
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] spotty = new char[N][M];
		char[][] plain = new char[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			spotty[i] = st.nextToken().toCharArray();
		}
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			plain[i] = st.nextToken().toCharArray();
		}
		
		int count = 0;
		for (int i=0; i<M; i++) {
			for (int j=i+1; j<M; j++) {
				for (int k=j+1; k<M; k++) {
					HashSet<ArrayList<Character>> spottySet = new HashSet<ArrayList<Character>>();
					HashSet<ArrayList<Character>> plainSet = new HashSet<ArrayList<Character>>();
					for (int a=0; a<N; a++) {
						ArrayList<Character> currSpotty = new ArrayList<Character>();
						ArrayList<Character> currPlain = new ArrayList<Character>();
						currSpotty.add(spotty[a][i]);
						currSpotty.add(spotty[a][j]);
						currSpotty.add(spotty[a][k]);
						currPlain.add(plain[a][i]);
						currPlain.add(plain[a][j]);
						currPlain.add(plain[a][k]);
						
						spottySet.add(currSpotty);
						plainSet.add(currPlain);
					}
					
					boolean possible = true;
					Iterator<ArrayList<Character>> spottyIt = spottySet.iterator();
					Iterator<ArrayList<Character>> plainIt = plainSet.iterator();
					
					while (spottyIt.hasNext() && plainIt.hasNext()) {
						if (plainSet.contains(spottyIt.next())) possible = false;
						if (spottySet.contains(plainIt.next())) possible = false;
					}
					
					if (possible) count++;
				}
			}
		}
		
		w.println(count);
		w.close();
	}

}
