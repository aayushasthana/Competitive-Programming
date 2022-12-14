import java.util.*;
import java.io.*;

public class LonelyPhoto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String s = sc.next();
		
		ArrayList<Long> sections = new ArrayList<Long>();
		
		int pointer = s.charAt(0);
		long currLength = 0;
		for (int i=0; i<N; i++) {
			if (pointer != s.charAt(i) && pointer == 'G') {
				sections.add(currLength);
				currLength = 1;
				pointer = 'H';
			}
			
			else if (pointer != s.charAt(i) && pointer == 'H') {
				sections.add(currLength);
				currLength = 1;
				pointer = 'G';
			}
			
			else currLength++;
			if (i==N-1) sections.add(currLength);
		}
		
		//System.out.println(sections);
		
		long count = 0;
		for (int i=0; i<sections.size(); i++) {
			if (sections.get(i) == 1 && i==0) count += sections.get(i+1) + 1 - 2;
			else if (sections.get(i) == 1 && i==sections.size()-1) count += sections.get(i-1) + 1 - 2;
			else if (sections.get(i) == 1) count += (sections.get(i+1) + 1) * (sections.get(i-1) + 1) - 3; 
		}
		System.out.println(count);
		
		sc.close();
		
		
	}

}
