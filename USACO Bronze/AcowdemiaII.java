import java.util.*;
public class AcowdemiaII {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();
		Map<String, Integer> ids = new HashMap<String, Integer>();
		for (int i=0; i<N; i++) {
			ids.put(sc.next(), i);
		}
		
		char[][] ordering = new char[N][N];
		for (int i=0; i<N; i++) {
            Arrays.fill(ordering[i], '?');
            ordering[i][i] = 'B';
        }
		
		for (int i=0; i<K; i++) {
			String[] pub = new String[N];
			for (int j=0; j<N; j++) pub[j] = sc.next();
			
			for (int j=0; j<N; j++) {
				boolean isSenior = false;
				
				for (int l=j+1; l<N; l++) {
					if (pub[l-1].compareTo(pub[l]) > 0) {
						isSenior = true;
					}
					
					if (isSenior) {
						ordering[ids.get(pub[l])][ids.get(pub[j])] = '1';
						ordering[ids.get(pub[j])][ids.get(pub[l])] = '0';
					}
				}
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(ordering[i][j]);
			}
			System.out.println();
		}
		
		sc.close();
	}
}
