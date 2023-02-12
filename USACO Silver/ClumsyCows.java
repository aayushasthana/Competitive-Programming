import java.util.*;
import java.io.*;

public class ClumsyCows {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("clumsy.in"));
		PrintWriter w = new PrintWriter("clumsy.out");
		
		String input = sc.next();
		sc.close();
		
		int sum = 0;
		int steps = 0;
		for (int i=0; i<input.length(); i++) {
			if (input.charAt(i) == '(') sum++;
			else sum--;
			
			if (sum < 0) {
				sum+=2;
				steps++;
			}
		}
		
		steps+=sum/2;
		
		w.println(steps);
		w.close();
	}

}
