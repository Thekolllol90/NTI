package V8;
import java.util.Scanner; //importerar scanner
import java.util.Random;// importerar random

public class NumberSpel {
	public static void main(String[] args) {
	
		Random random = new Random(); // genererar ett random tal
		int tal = random.nextInt(101); // hämtar ett number mellan 0-100
	}
	
	
	public int Spel(int tal) {
		Scanner scanner = new Scanner(System.in); // skapar en ny scanner
		Boolean spel = true; 
		
		while(spel=true) { // skapar en while loop
			
			int x = scanner.nextInt();
			int y = 0;
			y++;
			
			if(x < tal) {
				System.out.println("higher");
			} else if(x > tal) {
				System.out.println("Lower");
			} else if(x == tal) {
				System.out.println();
				System.out.println("You Won");
				System.out.println("It took you" + y + "tries");
			}
		}
		
		return 0;
	}
}


