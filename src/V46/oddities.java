package V46;

import java.util.Scanner;

public class oddities {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		boolean run1 = true;
		
		while(run1) {
			int x = sca.nextInt();
			if ((x % 2) == 0) { // kollar om modelus utav x blir 0
				System.out.print(x);
				System.out.print(" is even");
			}
			else {			// om modelus utav x inte blir 0
				System.out.print(x);
				System.out.print(" is odd");
			}
			System.out.println();
		}
		sca.close();
	}
}
