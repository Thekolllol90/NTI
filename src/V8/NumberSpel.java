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

	public static int[] hämtaArray() { // en method som hämtar en sparad array
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

		int intarray[] = { // skaapr en array som poäng lista
				99, 88, 33, 44, 55 };

		intarray = hämtaArray();

		while (again == true) {

			System.out.println("choose a difficulty");
			System.out.println();
			System.out.println("1.easy   2.medium   3.hard  4.imposible"); // låter använderen välja en svårhetsgrad
			int dif = sc.nextInt();

			int tal = 0;
			int val = 0;
			int rep = 0;

			if (dif == 1) { // ger olika antal möjliga tal beroende på vilken svårhetsgrad man väljer
				val = 101;
				System.out.println("Im thinking of a number betwen 0 and " + (val - 1));
				tal = random.nextInt(val);
				rep = Spel(tal); // hämtar methoden
			} else if (dif == 2) {
				val = 151;
				System.out.println("Im thinking of a number betwen 0 and " + (val - 1));
				tal = random.nextInt(val);
				rep = Spel(tal); // hämtar methoden
			} else if (dif == 3) {
				val = 201;
				System.out.println("Im thinking of a number betwen 0 and " + (val - 1));
				tal = random.nextInt(val);
				rep = Spel(tal); // hämtar methoden
			} else if (dif == 4) {
				val = 201;
				System.out.println("Im thinking of a number betwen 0 and " + (val - 1));
				 rep = Spelim(tal);
			}

			bubbleSort(intarray); // hämtar bubble sort som sorterar arrayen

			if (rep < intarray[intarray.length - 1]) {
				intarray[intarray.length - 1] = rep;
			}

			bubbleSort(intarray); // hämtar bubble sort som sorterar arrayen

			sparaArray(intarray);

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

				for (int i = 0; i < intarray.length; i++) { // skriver ut arrayen som en poång lista
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

		// loopen körs tills hela arrayen kollas igenom utan att några tal byter plats
		// med varandra
		do {

			swapped = false;

			// loopar igenom hela arrayen 1 gång
			for (int i = 0; i < intarray.length - 1; i++) {

				// jämför två tal bredvid varandra och byter plats på dem om det högra talet är
				// större än det vänstra
				if (intarray[i] > intarray[i + 1]) {
					int temp = intarray[i + 1];
					intarray[i + 1] = intarray[i];
					intarray[i] = temp;
					swapped = true; // har åtminstone ett byte skett under körningen så ändras swapped värde till
									// true
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

	public static int Spelim(int tal) { // samma som det andra spelet men genererar ett nytt tal efter varje försök
		Scanner scanner = new Scanner(System.in); // skapar en ny scanner
		boolean spel = true;
		int y = 0;
		int mip = 0;

		while (spel == true) { // skapar en while loop

			mip = (int) (Math.random()*200.0); // genererar ett random tal			
			
			int x = scanner.nextInt();
			y++;

			if (x < mip) { // om talet man skriver är mindre än talet skriver den högre
				System.out.println("higher");
			} else if (x > mip) { // om talet man skriver är störe än talet skriver den läggre
				System.out.println("Lower");
			} else if (x == mip) { // om man gissar rätt tal skriver den att man vunnit
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