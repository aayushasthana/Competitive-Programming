import java.util.*;

public class AirCownditioningII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] cowSTART = new int[N];
		int[] cowEND = new int[N];
		int[] cowNEED = new int[N];
		int[] acSTART = new int[10];
		int[] acEND = new int[10];
		int[] acREDUCTION = new int[10];
		int[] acCOST = new int[10];
		
		for (int i=0; i<N; i++) {
			cowSTART[i] = sc.nextInt();
			cowEND[i] = sc.nextInt();
			cowNEED[i] = sc.nextInt();
		}
		
		for (int i=0; i<M; i++) {
			acSTART[i] = sc.nextInt();
			acEND[i] = sc.nextInt();
			acREDUCTION[i] = sc.nextInt();
			acCOST[i] = sc.nextInt();
		}
		
		sc.close();
		
		int ans = 100000000;
		
		for (int ac1=0; ac1<2; ac1++)
		for (int ac2=0; ac2<2; ac2++)
		for (int ac3=0; ac3<2; ac3++)
		for (int ac4=0; ac4<2; ac4++)
		for (int ac5=0; ac5<2; ac5++)
		for (int ac6=0; ac6<2; ac6++)
		for (int ac7=0; ac7<2; ac7++)
		for (int ac8=0; ac8<2; ac8++)
		for (int ac9=0; ac9<2; ac9++)
		for (int ac10=0; ac10<2; ac10++) {
			int[] AC = {ac1, ac2, ac3, ac4, ac5, ac6, ac7, ac8, ac9, ac10};
			int[] t = new int[101];
			int curr = 0;
			
			for (int i=0; i<10; i++) {
				//1 means AC is on
				if (AC[i] == 1) {
					//update temperature array
					for (int j=acSTART[i]; j<=acEND[i]; j++) t[j] += acREDUCTION[i];
					//add cost
					curr += acCOST[i];
				}
			}
			
			//check if cows are chill
			boolean works = true;
			for (int i=0; i<N; i++) {
				for (int j=cowSTART[i]; j<=cowEND[i]; j++) {
					if (cowNEED[i] > t[j]) works = false;
				}
			}
			
			if (works) ans = Math.min(ans, curr);
		}
		
		System.out.println(ans);
	}
}

