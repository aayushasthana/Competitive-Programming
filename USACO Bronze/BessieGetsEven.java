import java.util.*;
import java.io.*;

public class BessieGetsEven {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("geteven.in"));
		PrintWriter w = new PrintWriter("geteven.out");
		
		//0 = B, 1 = E, 2 = S, 3 = I, 4 = G, 5 = O, 6 = M
		int[][] oddEven = new int[7][2];
		int N = sc.nextInt();
		for (int i=0; i<N; i++) {
			char curr = sc.next().charAt(0);
			int num = sc.nextInt();
			if (curr == 'B') oddEven[0][Math.abs(num%2)]++;
			else if (curr == 'E') oddEven[1][Math.abs(num%2)]++;
			else if (curr == 'S') oddEven[2][Math.abs(num%2)]++;
			else if (curr == 'I') oddEven[3][Math.abs(num%2)]++;
			else if (curr == 'G') oddEven[4][Math.abs(num%2)]++;
			else if (curr == 'O') oddEven[5][Math.abs(num%2)]++;
			else if (curr == 'M') oddEven[6][Math.abs(num%2)]++;
		}
		
		sc.close();
		
		int ans = 0;
		for (int b=0; b<2; b++) {
			for (int e=0; e<2; e++) {
				for (int s=0; s<2; s++) {
					for (int i=0; i<2; i++) {
						for (int g=0; g<2; g++) {
							for (int o=0; o<2; o++) {
								for (int m=0; m<2; m++) {
									int BESIGOM = (b + e + s + s + i + e) * (g + o + e + s) * (m + o + o);
									if (BESIGOM % 2 == 0) {
										ans += oddEven[0][b] * oddEven[1][e] * oddEven[2][s] * oddEven[3][i] 
												* oddEven[4][g] * oddEven[5][o] * oddEven[6][m];
									}
								}
							}
						}
					}
				}
			}
		}
		
		w.println(ans);
		
		w.close();
	}

}
