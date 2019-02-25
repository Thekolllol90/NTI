package V8;

import java.util.Scanner; //importerar scanner
import java.util.Random;// importerar random

public class NumberSpel {
	public static void main(String[] args) {

		boolean again = true;
		Scanner sc = new Scanner(System.in);
		Random random = new Random(); // genererar ett random tal
		int intarray[] = {		// skaapr en array som poäng lista
				99, 88, 33, 44, 55
		};
		while (again == true) {

			System.out.println("choose a difficulty");
			System.out.println();
			System.out.println("1.easy   2.medium   3.hard  4.imposible");
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
			int rep = Spel(tal); // hämtar methoden
			
			
			intarray[intarray.length - 1]
			
			bubbleSort(intarray);

			System.out.println("Do you want to play again?");
			System.out.println();
			System.out.println("Y" + "    " + "N");
			String ag = sc.next();
			if (ag.toLowerCase().equals("y")) { // gör alla siffror till lowercase och kollar om man skriver Y
				again = true;
			} else if (ag.toLowerCase().equals("n")) { // gör alla siffror till lowercase och kollar om man skriver N
				again = false; // stoppar loopen som kör om spelet
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

        // initierar nödvändiga variabler
        boolean swapped = true;
        int counter = 0;

        // loopen körs tills hela arrayen kollas igenom utan att några tal byter plats med varandra
        do {

            swapped = false;

            //loopar igenom hela arrayen 1 gång
            for (int i = 0; i < intarray.length - 1; i++) {

                // jämför två tal bredvid varandra och byter plats på dem om det högra talet är större än det vänstra
                if (intarray[i] > intarray[i + 1]) {
                    int temp = intarray[i + 1];
                    intarray[i + 1] = intarray[i];
                    intarray[i] = temp;
                    swapped = true; // har åtminstone ett byte skett under körningen så ändras swapped värde till true
                }
                // håller koll på antalet iterationer
                counter++;
            }

        } while (swapped); // do-while loopen körs alltid minst en gång

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

		return y;
	}
}
