package V8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;// importerar random
import java.util.Scanner; //importerar scanner

public class NumberSpel {

	public static void sparaArray(int[] array) { // en method som sparar en array i ett dokument
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("array.txt");
			for (int i = 0; i < array.length; i++) {
				if (i == array.length - 1)
					fileWriter.write(String.format("%d", array[i]));
				else
					fileWriter.write(array[i] + ",");
			}

			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int[] h�mtaArray() { // en method som h�mtar en sparad array
		FileReader fileReader;
		try {
			fileReader = new FileReader("array.txt");
			BufferedReader reader = new BufferedReader(fileReader);

			String line = reader.readLine();
			String[] values = line.split(",");

			int[] result = new int[values.length];
			for (int i = 0; i < values.length; i++) {
				result[i] = Integer.parseInt(values[i]);
			}

			reader.close();
			fileReader.close();

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {

		boolean again = true;
		Scanner sc = new Scanner(System.in);
		Random random = new Random(); // genererar ett random tal

		int intarray[] = { // skaapr en array som po�ng lista
				99, 88, 33, 44, 55 };

		intarray = h�mtaArray();

		while (again == true) {

			System.out.println("choose a difficulty");
			System.out.println();
			System.out.println("1.easy   2.medium   3.hard  4.imposible"); // l�ter anv�nderen v�lja en sv�rhetsgrad
			int dif = sc.nextInt();

			int tal = 0;
			int val = 0;
			int rep = 0;

			if (dif == 1) { // ger olika antal m�jliga tal beroende p� vilken sv�rhetsgrad man v�ljer
				val = 101;
				System.out.println("Im thinking of a number betwen 0 and " + (val - 1));
				tal = random.nextInt(val);
				rep = Spel(tal); // h�mtar methoden
			} else if (dif == 2) {
				val = 151;
				System.out.println("Im thinking of a number betwen 0 and " + (val - 1));
				tal = random.nextInt(val);
				rep = Spel(tal); // h�mtar methoden
			} else if (dif == 3) {
				val = 201;
				System.out.println("Im thinking of a number betwen 0 and " + (val - 1));
				tal = random.nextInt(val);
				rep = Spel(tal); // h�mtar methoden
			} else if (dif == 4) {
				val = 201;
				System.out.println("Im thinking of a number betwen 0 and " + (val - 1));
				 rep = Spelim(tal);
			}

			bubbleSort(intarray); // h�mtar bubble sort som sorterar arrayen

			if (rep < intarray[intarray.length - 1]) {
				intarray[intarray.length - 1] = rep;
			}

			bubbleSort(intarray); // h�mtar bubble sort som sorterar arrayen

			sparaArray(intarray);

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

				for (int i = 0; i < intarray.length; i++) { // skriver ut arrayen som en po�ng lista
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

		// loopen k�rs tills hela arrayen kollas igenom utan att n�gra tal byter plats
		// med varandra
		do {

			swapped = false;

			// loopar igenom hela arrayen 1 g�ng
			for (int i = 0; i < intarray.length - 1; i++) {

				// j�mf�r tv� tal bredvid varandra och byter plats p� dem om det h�gra talet �r
				// st�rre �n det v�nstra
				if (intarray[i] > intarray[i + 1]) {
					int temp = intarray[i + 1];
					intarray[i + 1] = intarray[i];
					intarray[i] = temp;
					swapped = true; // har �tminstone ett byte skett under k�rningen s� �ndras swapped v�rde till
									// true
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

	public static int Spelim(int tal) { // samma som det andra spelet men genererar ett nytt tal efter varje f�rs�k
		Scanner scanner = new Scanner(System.in); // skapar en ny scanner
		boolean spel = true;
		int y = 0;
		int mip = 0;

		while (spel == true) { // skapar en while loop

			mip = (int) (Math.random()*200.0); // genererar ett random tal			
			
			int x = scanner.nextInt();
			y++;

			if (x < mip) { // om talet man skriver �r mindre �n talet skriver den h�gre
				System.out.println("higher");
			} else if (x > mip) { // om talet man skriver �r st�re �n talet skriver den l�ggre
				System.out.println("Lower");
			} else if (x == mip) { // om man gissar r�tt tal skriver den att man vunnit
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