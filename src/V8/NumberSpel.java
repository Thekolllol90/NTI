package V8;

import java.util.Scanner; //importerar scanner
import java.util.Random;// importerar random

public class NumberSpel {
	public static void main(String[] args) {

		boolean again = true;
		Scanner sc = new Scanner(System.in);
		Random random = new Random(); // genererar ett random tal
		// String dif = "0";
		while (again == true) {

			System.out.println("choose a difficulty");
			System.out.println();
			System.out.println("1.easy   2.medium   3.hard  4.imposible");
			// dif = sc.nextLine();
			int dif = sc.nextInt();

			int tal = 0;
			int val = 0;

			if (dif == 1) { //ger olika antal möjliga tal beroende på vilken svårhetsgrad man väljer
				val = 101;
			} else if (dif == 2) {
				val = 151;
			} else if (dif == 3) {
				val = 201;
			}
			System.out.println("Im thinking of a number betwen 0 and " + (val - 1));
			tal = random.nextInt(val);
			Spel(tal); // hämtar methoden

			System.out.println("Do you want to play again?");
			System.out.println();
			System.out.println("Y" + "    " + "N");
			String ag = sc.next();
			if (ag.toLowerCase().equals("y")) { // gör alla siffror till lowercase och kollar om man skriver Y
				again = true;
			} else if (ag.toLowerCase().equals("n")) { // gör alla siffror till lowercase och kollar om man skriver N
				again = false; // stoppar loopen som kör om spelet
				System.out.println("Okay, Goodbye");
			}
		}
		sc.close();
	}

	public static int Spel(int tal) {
		Scanner scanner = new Scanner(System.in); // skapar en ny scanner
		Boolean spel = true;
		int y = 0;

		while (spel == true) { // skapar en while loop

			int x = scanner.nextInt();
			y++;

			if (x < tal) { // om talet man skriver är mindre än talet skriver den högre
				System.out.println("higher");
			} else if (x > tal) { // om talet man skriver är störe än talet skriver den läggre
				System.out.println("Lower");
			} else if (x == tal) { // om man gissar rätt tal skriver den att man vunnit
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
