import java.util.*;

public class ComparingStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String first = sc.next();
		String second = sc.next();
		
		sc.close();
		
		if (first.length() != second.length()) {
			System.out.println("NO");
		} 
		
		/*
		iterate through both strings
			check if index in errors array is greater than 1:
				print "NO"
				exit
				
			if first[i] is not equal to second[i]:
				mark in errors array
				increase index in errors array
		
		if index in errors array is 0:
			print "YES"
		
		else if index in errors array is 1:
			print "NO"
		
		else if (first[error[0]] == second[error[1]] and first[error[1]] == second[error[0]]):
			print "YES"
		else:
			print "NO"
		
		*/
		
		
		else {		
			int[] errors = new int[3];
			int index = 0;
			for (int i=0; i<first.length(); i++) {
				if (first.charAt(i) != second.charAt(i)) {
					errors[index] = i;
					index++;
				}
				
				if (index > 2) {
					System.out.println("NO");
					System.exit(0);
				}
			}
			
			if (index == 0) {
				System.out.println("YES");
			} else if (index == 1) {
				System.out.println("NO");
			} else if (first.charAt(errors[0]) == second.charAt(errors[1]) && first.charAt(errors[1]) == second.charAt(errors[0])) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
			
	}
		
}

