package V8;
import java.util.Scanner; //importerar scanner
import java.util.Random;// importerar random

public class NumberSpel {
	public static void main(String[] args) {
	
		boolean again = true;
		Scanner sc = new Scanner(System.in);
		
	while(again == true){
		Random random = new Random(); // genererar ett random tal
		int tal = random.nextInt(101); // h�mtar ett number mellan 0-100
		System.out.println("Im thinking of a number betwen 0 and 100");
		
		Spel(tal); // h�mtar methoden 
		
		System.out.println("Do you want to play again?");
		System.out.println();
		System.out.println("Y" + "    " + "N");
		String ag = sc.next();
		if(ag.toLowerCase().equals("y")) { // g�r alla siffror till lowercase och kollar om man skriver Y
			again = true;
		}else if(ag.toLowerCase().equals("n")) { // g�r alla siffror till lowercase och kollar om man skriver N
			again = false; // stoppar loopen som k�r om spelet
		}
		}
	}
	
	
	public static int Spel(int tal) {
		Scanner scanner = new Scanner(System.in); // skapar en ny scanner
		Boolean spel = true; 
		int y = 0;
		
		while(spel=true) { // skapar en while loop
			
			int x = scanner.nextInt();
			y++;
			
			if(x < tal) { // om talet man skriver �r mindre �n talet skriver den h�gre
				System.out.println("higher");
			} else if(x > tal) { // om talet man skriver �r st�re �n talet skriver den l�ggre
				System.out.println("Lower");
			} else if(x == tal) { // om man gissar r�tt tal skriver den att man vunnit
				System.out.println();
				System.out.println();
				System.out.println("You Won");
				System.out.println("It took you " + y + " tries");
				break; // g�r ur loopen
			}
		}
		
		return 0;
	}
}


