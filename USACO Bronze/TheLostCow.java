import java.util.*;
import java.io.*;

public class TheLostCow {

	public static void main(String[] args) throws Exception {
		cow c = new cow();
		c.algo();
	}
}

class cow {
	Scanner sc;
	PrintWriter w;
	int ogFJ;
	int FJ;
	int prevFJ;
	int Bessie;
	int total;
	
	cow() throws Exception {
		sc = new Scanner(new File("lostcow.in"));
		w = new PrintWriter("lostcow.out");
	}
	
	void algo() {
		getInputs();
		boolean stop = false;
		
		for (int i=0; stop == false; i++) {
			if (FJ==Bessie) {
				stop = true;
			}
			
			else {
				FJ = (int) (ogFJ + Math.pow(-2, i));
				total += Math.abs(prevFJ-FJ);
				
				if (((Bessie <= FJ) && (Bessie>prevFJ)) || ((Bessie >= FJ) && (Bessie<prevFJ))) {
					total -= Math.abs(FJ-Bessie);
					stop = true;
				}
				
				else {
					prevFJ = FJ;
				}
			}
		}
		
		System.out.println(total);
		
		w.print(total);
		w.close();
	}
	
	void getInputs() {
		ogFJ = sc.nextInt();
		Bessie = sc.nextInt();
		
		System.out.println(ogFJ);
		System.out.println(Bessie);
		
		FJ = ogFJ;
		prevFJ = ogFJ;
		total = 0;
		
		sc.close();
	}
}
