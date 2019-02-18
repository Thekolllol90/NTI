package V8;
import java.util.Scanner; //importerar scanner
import java.util.Random;// importerar random

public class NumberSpel {
	public static void main(String[] args) {
	
		Random random = new Random(); // genererar ett random tal
		int tal = random.nextInt(101); // hämtar ett number mellan 0-100
		System.out.println("Im thinking of a number betwen 0 and 100");
		
		Spel(tal); // hämtar methoden 
	}
	
	
	public static int Spel(int tal) {
		Scanner scanner = new Scanner(System.in); // skapar en ny scanner
		Boolean spel = true; 
		int y = 0;
		
		while(spel=true) { // skapar en while loop
			
			int x = scanner.nextInt();
			y++;
			
			if(x < tal) { // om talet man skriver är mindre än talet skriver den högre
				System.out.println("higher");
			} else if(x > tal) { // om talet man skriver är störe än talet skriver den läggre
				System.out.println("Lower");
			} else if(x == tal) { // om man gissar rätt tal skriver den att man vunnit
				System.out.println();
				System.out.println();
				System.out.println("You Won");
				System.out.println("It took you " + y + " tries");
				break; // går ur loopen
			}
		}
		
		return 0;
	}
}


