import java.util.*;
import java.io.*;

public class SecretCode {
	
	static long ans = 0;
	static String str;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("scode.in"));
		PrintWriter w = new PrintWriter("scode.out");
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		str = st.nextToken();
		compress(str);
		
		w.println(ans);
		w.close();
	}

	public static void compress(String curr) {
		if (curr.length() > 2) {
			int halfIndex = (curr.length()+1)/2;
			String f = curr.substring(0,halfIndex);
			String s = curr.substring(halfIndex-1, curr.length());
			
			if (f.substring(0,f.length()-1).equals(s.substring(1, s.length()))) {
				ans++;
				compress(f);
			}
			
			if (f.substring(1,f.length()).equals(s.substring(1, s.length()))) {
				ans++;
				compress(f);
			}
			
			if (s.substring(0, s.length()-1).equals(f.substring(0, f.length()-1))) {
				ans++;
				compress(s);
			}
			
			if (s.substring(1, s.length()).equals(f.substring(0, f.length()-1))) {
				ans++;
				compress(s);
			}
		}
	}
}
