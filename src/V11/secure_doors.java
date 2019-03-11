package V11;

import java.util.ArrayList;
import java.util.Scanner;

public class secure_doors {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many people?");
		int antal = scanner.nextInt();
		boolean boi = true;
		
		ArrayList<String> nameList = new ArrayList<>(antal);
		while(boi) {
		
			String[] line = scanner.nextLine().split(" ");

            String command = line[0];
            String name = line[1];

			if(command.equals("entry")) {
				
				boolean yeet = false;
				for(int i = 0; i < nameList.size(); i++) {
					if(nameList.get(i).equals(name)) {
						yeet = true;
						System.out.println(" enterd (anomely) " + name);
						
						break;
					}
				}
				nameList.add(name);
					
			}else if(command.equals("exit")) {
				nameList.remove(name);
				
				
			}
			
		}
	}
}
