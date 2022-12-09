import java.util.*;
import java.io.*;

public class WordProcessor {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("word.in"));
		PrintWriter w = new PrintWriter("word.out");
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		String[] words = new String[N];
		
		for (int i=0; i<N; i++) {
			words[i] = sc.next();
		}
		
		sc.close();
		
		int currK = K;
		
		for (int i=0; i<N; i++) {
			if (currK - words[i].length() >= 0) {
				if (i==0) {
					w.print(words[i]);
				}
				
				else {
					w.print(" "+words[i]);
				}
				currK -= words[i].length();
			}
			
			else {
				w.println();
				w.print(words[i]);
				currK = K - words[i].length();
			}
		}
		
		w.close();
	}

}
