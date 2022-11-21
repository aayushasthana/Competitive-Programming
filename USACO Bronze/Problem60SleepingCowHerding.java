import java.util.*;
import java.io.*;
public class Problem60SleepingCowHerding {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("herding.in"));
		PrintWriter w = new PrintWriter("herding.out");
		
		int[] nums = new int[3];
		
		for (int i=0; i<3; i++) {
			nums[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(nums);
		int max = nums[1]-nums[0];
		int min = nums[1]-nums[0];
		
		for (int i=0; i<2; i++) {
			int diff = nums[i+1] - nums[i];
			max = Math.max(max, diff);
			min = Math.min(min, diff);
		}
		
		System.out.println(min);
		System.out.println(max);
		
		if (min == 1 && max == 1) {
			w.println(0);
			w.println(0);
			w.close();
			System.exit(0);
		}
		
		min--;
		
		if (min == 1) {
			w.println(min);
		}
		
		else {
			w.println(2);
		}
		
		w.println(max-1);
		
		w.close();
	}

}
