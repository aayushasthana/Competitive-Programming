import java.util.*;

public class Photoshoot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String curr = sc.next();
		
		ArrayList<Integer> sections = new ArrayList<Integer>();
		for (int i=0; i<N-1; i+=2) {
			if (curr.charAt(i) == 'G' && curr.charAt(i+1) == 'H') sections.add(0);
			if (curr.charAt(i) == 'H' && curr.charAt(i+1) == 'G') sections.add(1);
		}
		
		int count = 0;
		if (sections.size() == 0) {
			System.out.println(0);
			return;
		}
		
		//System.out.println(sections);
		sections.add(1);
		int pointer = sections.get(0);
		for (int i=0; i<sections.size(); i++) {
			if (sections.get(i) != pointer && pointer == 0) {
				count++;
				pointer = 1;
			} else if (sections.get(i) != pointer && pointer == 1) {
				count++;
				pointer = 0;
			}
		}
		
		System.out.println(count);
		
		sc.close();
	}
}
