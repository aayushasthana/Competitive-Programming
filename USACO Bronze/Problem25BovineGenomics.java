import java.util.*;
import java.io.*;

public class Problem25BovineGenomics {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("cownomics.in"));
		PrintWriter w = new PrintWriter("cownomics.out");
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		char[][] spotty = new char[M][N];
		
		for (int i=0; i<N; i++) {
			String temp = sc.next();
			for (int j=0; j<M; j++) {
				spotty[j][i] = temp.charAt(j);
			}
		}
		
		char[][] plain = new char[M][N];
		
		for (int i=0; i<N; i++) {
			String temp = sc.next();
			for (int j=0; j<M; j++) {
				plain[j][i] = temp.charAt(j);
			}
		}
		
		
		sc.close();
		
		int count = 0;
		
		for (int i=0; i<M; i++) {
			boolean found = false;
			
			for (int j=0; j<N; j++) {
				for (int k=0; k<N; k++) {
					if (spotty[i][j] == plain[i][k]) {
						found = true;
					}
				}
			}
			
			if (found == false) {
				count++;
			}
		}
		
		w.print(count);
		
		w.close();
	}

}
