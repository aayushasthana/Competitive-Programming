import java.util.*;
import java.io.*;

public class Moocryption {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("moocrypt.in"));
		PrintWriter w = new PrintWriter("moocrypt.out");
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] board = new int[N+4][M+4];
		
		for (int i=0; i<N; i++) {
			String curr = sc.next();
			for (int j=0; j<M; j++) {
				board[i+2][j+2] = curr.charAt(j);
			}
		}

		sc.close();
		
		int mostMoos = 0;
		int[][] directions = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
		for (int i='A'; i<='Z'; i++) {
			if (i=='M') {
				continue;
			}
			
			for (int j='A'; j<='Z'; j++) {
				
				if (j==i || j=='O') {
					continue;
				}
				
				int currMoos = 0;
				for (int k=2; k<N+3; k++) {
					for (int l=2; l<M+3; l++) {
						if (board[k][l] == i) {
							for (int a=0; a<8; a++) {
								if (board[k+directions[a][0]][l+directions[a][1]] == j && 
										board[k+2*directions[a][0]][l+2*directions[a][1]] == j) {
									currMoos++;
								}
							}
						}
					}
				}
				mostMoos = Math.max(currMoos, mostMoos);
			
			}
		}
		
		w.println(mostMoos);
		w.close();
	}

}
