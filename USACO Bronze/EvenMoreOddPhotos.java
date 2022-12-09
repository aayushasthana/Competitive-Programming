import java.util.*;

public class EvenMoreOddPhotos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//1 = odd, 0 = even
		int[] breedIDs = new int[N];
		int oddCount = 0;
		int evenCount = 0;
		
		for (int i=0; i<N; i++) {
			if (sc.nextInt()%2 == 0) {
				breedIDs[i] = 0;
				evenCount++;
			}
			
			else {
				breedIDs[i] = 1;
				oddCount++;
			}
		}
		
		sc.close();
		
		int retval = 0;
		if (evenCount > oddCount) {
			retval = 2*oddCount + 1;
		}
		
		else if (evenCount == oddCount) {
			retval = 2*oddCount;
		}
		
		else {
			if ((oddCount - evenCount) % 3 == 0) {
				retval = 2*evenCount + 2*(oddCount-evenCount)/3;
			}
			
			else if ((oddCount - evenCount) % 3 == 1) {
				retval = 2*evenCount + 1 + 2*(oddCount-evenCount-4)/3;
			}
			
			else {
				retval = 2*evenCount + 1 + 2*(oddCount-evenCount-2)/3;
			}
		}
		
		System.out.println(retval);
	}

}
