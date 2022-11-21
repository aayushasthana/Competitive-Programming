import java.util.*;
import java.io.*;

public class Problem40WYDTCCTR2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("circlecross.in"));
		PrintWriter w = new PrintWriter("circlecross.out");
		
		char[] input = new char[52];
		String inputAsString = sc.next();
		for (int i=0; i<52; i++) {
			input[i] = inputAsString.charAt(i);
		}
		
		sc.close();
		
		/*
		 int count = 0;
		 Iterate i=A...Z:
		 	Iterate j=i+1...Z:
		 		char iStatus = 'N'; (I = in, O = out, N = Neither)
		 		char jStatus = 'N'
		 		
		 		int iEntry;
		 		int jEntry;
		 		int iExit;
		 		int jExit;
		 		
		 		Iterate through character array:
		 			if (current character == i && iStatus == 'N') {
		 				iStatus = 'I';
		 				iEntry = current position;
		 			}
		 			
		 			else if (current character == i && iStatus == 'I') {
		 				iStatus = 'O';
		 			}
		 			
		 			else if (current character == j && jStatus == 'N') {
		 				jStatus = 'I';
		 			}
		 			
		 			else if (current character == j && jStatus == 'I') {
		 				jStatus = 'O';
		 			}
		 			
		 */
		
		int count = 0;
		for (char i='A'; i<='Z'; i++) {
			for (char j=(char) (i+1); j<='Z'; j++) {
				
				char iStatus = 'N';
		 		char jStatus = 'N';
		 		
		 		int iEntry = 0;
		 		int jEntry = 0;
		 		int iExit = 0;
		 		int jExit = 0;
				
				for (int k=0; k<52; k++) {
				
					if (input[k] == i && iStatus == 'N') {
		 				iStatus = 'I';
		 				iEntry = k;
		 			}
		 			
		 			else if (input[k] == i && iStatus == 'I') {
		 				iStatus = 'O';
		 				iExit = k;
		 			}
		 			
		 			else if (input[k] == j && jStatus == 'N') {
		 				jStatus = 'I';
		 				jEntry = k;
		 			}
		 			
		 			else if (input[k] == j && jStatus == 'I') {
		 				jStatus = 'O';
		 				jExit = k;
		 			}
		 			
				}
				
				if (iEntry < jEntry && jEntry < iExit && iExit < jExit) {
					System.out.println("i: "+i+" j: "+j);
					count++;
				} else if (jEntry < iEntry && iEntry < jExit && jExit < iExit) {
					count++;
				}
			}
		}
		
		w.println(count);
		
		w.close();
	}

}
