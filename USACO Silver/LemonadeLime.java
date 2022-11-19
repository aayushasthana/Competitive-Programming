import java.io.*;
import java.util.*;

public class LemonadeLime {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("lemonade.in"));
		PrintWriter w = new PrintWriter("lemonade.out");
		
		int N = sc.nextInt();
		int[] ws = new int[N];
		for (int i=0; i<N; i++) ws[i] = sc.nextInt();
		
		sc.close();
		
		Arrays.sort(ws);
		int count = 0;
		for (int i=N-1; i>=0; i--) {
			if (count <= ws[i]) {
				count++;
			}
		}
		
		w.println(count);
		
		w.close();

	}

}
