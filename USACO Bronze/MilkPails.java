import java.util.*;
import java.io.*;

public class MilkPails {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("pails.in"));
		PrintWriter w = new PrintWriter("pails.out");
		
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Integer> possibilities = new ArrayList<Integer>();
		ArrayList<Integer> finalP = new ArrayList<Integer>();
		
		int tests = (M/X)+1;
		System.out.println(tests);
		
		for (int i=tests; i>0; i--) {
			for (int j=0; j<tests; j++) {
				possibilities.add((X*i) + (Y*j));
			}
		}
		
		for (int i=0; i<possibilities.size(); i++) {
			if (possibilities.get(i)<= M) {
				finalP.add(possibilities.get(i));
			}
		}
		
		System.out.println(Collections.max(finalP));
		w.println(Collections.max(finalP));
		
		sc.close();
		w.close();
	}

}
