import java.util.*;
import java.io.*;

public class CowBaseball {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("baseball.in"));
		PrintWriter w = new PrintWriter("baseball.out");
		
		int N = sc.nextInt();
		long[] cows = new long[N];
		for (int i=0; i<N; i++) cows[i] = sc.nextInt();
		Arrays.sort(cows);
		
		sc.close();
		
		//for (int i=0; i<N; i++) System.out.print(cows[i] + " ");
		//System.out.println();
		
		long count = 0;
		for (int i=0; i<N-2; i++) {
			for (int j=i+1; j<N-1; j++) {
				long XY = cows[j] - cows[i];
				
				//binary search for min
				int a1 = j+1;
				int b1 = N-1;
				while (a1 != b1) {
					int mid = (a1+b1)/2;
					if (cows[mid] - cows[j] >= XY) {
						b1=mid;
					} else {
						a1=mid+1;
					}
				}
				
				//binary search for max
				int a2 = j+1;
				int b2 = N-1;
				while (a2 != b2) {
					int mid = (a2+b2+1)/2;
					if (cows[mid] - cows[j] <= 2*XY) {
						a2=mid;
					} else {
						b2=mid-1;
					}
				}
				
				//System.out.printf("i = %d, j = %d, a2 = %d, a1 = %d\n", cows[i], cows[j], cows[a2], cows[a1]);
				
				if (a2 == a1 && a1 == N-1 && cows[N-1]-cows[j] >= XY && cows[N-1]-cows[j] <= 2*XY) {
					count++;
					//System.out.printf("INC = %d\n\n", 1);
				} else if (a2 == a1 && a1 == N-1) {
					//System.out.printf("INC = %d\n\n", 0);
					continue;
				} else if (a2 == a1 && a1 == j+1 && cows[j+1]-cows[j] >= XY && cows[j+1]-cows[j] <= 2*XY) {
					count++;
					//System.out.printf("INC = %d\n\n", 1);
				} else if (a2 == a1 && a1 == j+1) {
					//System.out.printf("INC = %d\n\n", 0);
					continue;
				} else {
					count+=a2-a1+1;
					//System.out.printf("INC = %d\n\n", a2-a1+1);
				}
			}
		}
		
		w.println(count);
		
		w.close();
	}

}
