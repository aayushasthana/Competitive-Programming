import java.util.*;
import java.io.*;
public class COW {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("cow.in"));
		PrintWriter pw = new PrintWriter("cow.out");
		
		int N = sc.nextInt();
		String str = sc.next();
		
		sc.close();
		
		long w = 0;
		long ow = 0;
		long cow = 0;
		
		for (int i=N-1; i>=0; i--) {
			if (str.charAt(i) == 'W') w++;
			if (str.charAt(i) == 'O') ow += w;
			if (str.charAt(i) == 'C') cow += ow;
		}
		
		pw.println(cow);
		pw.close();
	}

}
