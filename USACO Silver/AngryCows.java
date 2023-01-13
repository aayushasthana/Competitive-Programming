import java.util.*;
import java.io.*;

public class AngryCows {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("angry.in"));
		PrintWriter w = new PrintWriter("angry.out");
		int N = sc.nextInt();
		int K = sc.nextInt();
		long[] cows = new long[N];
		
		for (int i=0; i<N; i++) {
			cows[i] = sc.nextLong();
		}
		
		Arrays.sort(cows);
		
		long a = 0;
		long b = 500000000;
		long mid = -1;
		while (a != b) {
			mid = (a+b)/2;
			if (needed(mid, cows) <= K) {
				b=mid;
			} else {
				a=mid+1;
			}
		}
		
		w.println(a);
		
		sc.close();
		w.close();
	}
	
	public static int needed (long rad, long[] nums) {
		int cowsUsed = 1;
		long blastEndPos = nums[0] + rad*2;
		for (int i=0; i<nums.length; i++) {
			if (nums[i] > blastEndPos) {
				blastEndPos=nums[i] + rad*2;
				cowsUsed++;
			}
		}
		
		return cowsUsed;
	}
}
