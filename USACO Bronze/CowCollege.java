import java.util.*;

public class CowCollege {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] c = new long[N];
		for (int i=0; i<N; i++) c[i] = sc.nextLong();
		Arrays.sort(c);
		
		long maxPrice = 0;
		long perPrice = 0;
		for (int i=0; i<N; i++) {
			long currPrice = (N-i)*c[i];
			if (currPrice > maxPrice) {
				maxPrice = currPrice;
				perPrice = c[i];
			}
		}
		
		System.out.println(maxPrice + " " + perPrice);
		
		sc.close();
	}

}
