package V11;

import java.util.ArrayList;
import java.util.Scanner;

public class secure_doors {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many people?");
		int antal = Integer.parseInt(scanner.nextLine()); // skapar en int, parseint f�r att n�r man anv�nder next int s� l�mnar den en \n men next line tar bort shiten
		boolean boi = true;
		
		ArrayList<String> nameList = new ArrayList<>(antal); //skaper en arrayList d�r man sj�lv f�r v�lja antal index
		while(boi) {
		
			String[] line = scanner.nextLine().split(" ");  // delar upp en string till tv� s� man bara beh�ver skriva en g�ng

            String command = line[0]; // f�rsta delen av stringen 
            String name = line[1];	// andra delen av stringen

			if(command.equals("entry")) { // om man skriver entry
				
				boolean yeet = false;
				for(int i = 0; i < nameList.size(); i++) {	// kollar igenom listan efter namnet man skrivit
					if(nameList.get(i).equals(name)) {
						yeet = true;
						System.out.println(name + " enterd (anomely)"); //om personen som skrivs in redan finns i byggnaden
						
						break; // sluter kolla p� namn
					}
				}
				
				if(!yeet) {		//om namnet inte finns i arrayListen
				nameList.add(name);
				System.out.println(name + " entered");
				}			
			}else if(command.equals("exit")) { // om man skriver exit
				boolean yeet = false;
				for(int i = 0; i < nameList.size(); i++) { // kollar igenom arrayListen
					if(nameList.get(i).equals(name)) {
						yeet = true;
						nameList.remove(i);
						System.out.println(name + " exited");
						break; // slutar kolla namn
					}
				}
				
				if(!yeet) { // om namnet inte finns i listan 
					System.out.println(name + " exited (anomely)");
				}
				
			}
			
		}
	}
}
