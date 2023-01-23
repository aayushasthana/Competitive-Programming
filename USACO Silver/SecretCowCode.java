import java.util.*;
import java.io.*;

public class SecretCowCode {
	
	static String str;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter w = new PrintWriter("cowcode.out");
		
		str = st.nextToken();
		long N = Long.parseLong(st.nextToken());
		br.close();
		
		w.println(solve(N));
		w.close();
	}

	public static char solve(long N) {
		long length = str.length();
		while (2*length < N) {
			length *= 2;
		}
		
		//base case
		if (N <= str.length()) {
			return str.charAt((int) (N-1));
		}
		
		//transitions
		if (N==length+1) {
			return solve(N-1);
		} else {
			return solve(N-length-1);
		}
	}
}
