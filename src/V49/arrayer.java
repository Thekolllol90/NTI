package V49;

import java.util.Scanner;

public class arrayer {
	public static void main(String[] args) {
		
	Scanner input = new Scanner(System.in);
	int[] olikatal = {1, 5, 10, 77, 63, 2, -7, 7, 4, 9, 4, 6};
	System.out.println("Skriv hur många tal du vill ha");
	int[] olikatal2 = new int[input.nextInt()];
	int counter  = 0;
	
	double[] deciamaltal = {1.0, 2.2, 3.5};
	
	String[] namn = {"Tomas", "Ludvig", "Isak", "Dilan", "Ahmed"};
	
	System.out.printf("skriv %d heltal!", olikatal2.length);
	
	for (int i = 0; i < olikatal2.length; i++) {
		
		olikatal2[i] = input.nextInt();
		
		}
	
	for (int i = olikatal2.length - 1; i >= 0; i--) {
		
		 System.out.print(olikatal2[i] + ", ");
		
		}
	
	for (int i = 0; i < olikatal2.length; i++) {
		
		if (olikatal2[i] == 4) {
			
			counter++;
			
			}
		}
	System.out.println(counter);
	}
}
