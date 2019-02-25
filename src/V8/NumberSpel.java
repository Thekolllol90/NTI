package V8;

import java.util.Scanner; //importerar scanner
import java.util.Random;// importerar random

public class NumberSpel {
	public static void main(String[] args) {

		boolean again = true;
		Scanner sc = new Scanner(System.in);
		Random random = new Random(); // genererar ett random tal
		int intarray[] = {		// skaapr en array som po�ng lista
				99, 88, 33, 44, 55
		};
		while (again == true) {

			System.out.println("choose a difficulty");
			System.out.println();
			System.out.println("1.easy   2.medium   3.hard  4.imposible");
			int dif = sc.nextInt();

			int tal = 0;
			int val = 0;

			if (dif == 1) { //ger olika antal m�jliga tal beroende p� vilken sv�rhetsgrad man v�ljer
				val = 101;
			} else if (dif == 2) {
				val = 151;
			} else if (dif == 3) {
				val = 201;
			}
			System.out.println("Im thinking of a number betwen 0 and " + (val - 1));
			tal = random.nextInt(val);
			int rep = Spel(tal); // h�mtar methoden
			
			
			intarray[intarray.length - 1]
			
			bubbleSort(intarray);

			System.out.println("Do you want to play again?");
			System.out.println();
			System.out.println("Y" + "    " + "N");
			String ag = sc.next();
			if (ag.toLowerCase().equals("y")) { // g�r alla siffror till lowercase och kollar om man skriver Y
				again = true;
			} else if (ag.toLowerCase().equals("n")) { // g�r alla siffror till lowercase och kollar om man skriver N
				again = false; // stoppar loopen som k�r om spelet
				System.out.println("Okay, Goodbye");
				System.out.println();
				
				for(int i = 0; i < intarray.length; i++) { // skriver ut arrayen
					System.out.println(intarray[i]);
				}
				
			}
		}
		sc.close();
	}
	
	static void bubbleSort(int[] intarray) {

        // initierar n�dv�ndiga variabler
        boolean swapped = true;
        int counter = 0;

        // loopen k�rs tills hela arrayen kollas igenom utan att n�gra tal byter plats med varandra
        do {

            swapped = false;

            //loopar igenom hela arrayen 1 g�ng
            for (int i = 0; i < intarray.length - 1; i++) {

                // j�mf�r tv� tal bredvid varandra och byter plats p� dem om det h�gra talet �r st�rre �n det v�nstra
                if (intarray[i] > intarray[i + 1]) {
                    int temp = intarray[i + 1];
                    intarray[i + 1] = intarray[i];
                    intarray[i] = temp;
                    swapped = true; // har �tminstone ett byte skett under k�rningen s� �ndras swapped v�rde till true
                }
                // h�ller koll p� antalet iterationer
                counter++;
            }

        } while (swapped); // do-while loopen k�rs alltid minst en g�ng

    }
	
	public static int Spel(int tal) {
		Scanner scanner = new Scanner(System.in); // skapar en ny scanner
		Boolean spel = true;
		int y = 0;

		while (spel == true) { // skapar en while loop

			int x = scanner.nextInt();
			y++;

			if (x < tal) { // om talet man skriver �r mindre �n talet skriver den h�gre
				System.out.println("higher");
			} else if (x > tal) { // om talet man skriver �r st�re �n talet skriver den l�ggre
				System.out.println("Lower");
			} else if (x == tal) { // om man gissar r�tt tal skriver den att man vunnit
				System.out.println();
				System.out.println();
				System.out.println("You Won");
				System.out.println("It took you " + y + " tries");
				break; // g�r ur loopen
			}
		}

		return y;
	}
}
