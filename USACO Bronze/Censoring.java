import java.util.*;
import java.io.*;

public class Censoring {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("censor.in"));
		PrintWriter w = new PrintWriter("censor.out");
		
		String input = sc.next();
		String badWord = sc.next();
		int N = input.length();
		int T = badWord.length();
		
		StringBuilder answer = new StringBuilder("");
		
		sc.close();
		
		for (int i=0; i<N; i++) {
			answer.append(input.charAt(i));
			if (answer.length() >= T && answer.subSequence(answer.length()-T, answer.length()).toString().equals(badWord)) {
				answer.delete(answer.length()-T, answer.length());
			}
		}
		
		w.println(answer.toString());
		
		w.close();
	}

}
