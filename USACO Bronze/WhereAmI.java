import java.util.*;
import java.io.*;
public class WhereAmI {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("whereami.in"));
		PrintWriter w = new PrintWriter("whereami.out");
		
		int N = sc.nextInt();
		String input = sc.next();
		
		sc.close();
		
		HashSet<Character> count = new HashSet<Character>();
		for (int i=0; i<N; i++) {
			count.add(input.charAt(i));
		}
		
		w.println(count.size());
		
		w.close();
	}

}
