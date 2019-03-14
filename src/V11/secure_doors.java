package V11;

import java.util.ArrayList;
import java.util.Scanner;

public class secure_doors {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many people?");
		int antal = Integer.parseInt(scanner.nextLine());
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
						System.out.println(name + " enterd (anomely)");
						
						break;
					}
				}
				
				if(!yeet) {
				nameList.add(name);
				System.out.println(name + " entered");
				}			
			}else if(command.equals("exit")) {
				boolean yeet = false;
				for(int i = 0; i < nameList.size(); i++) {
					if(nameList.get(i).equals(name)) {
						yeet = true;
						nameList.remove(i);
						System.out.println(name + " exited");
						break;
					}
				}
				
				if(!yeet) {
					System.out.println(name + " exited (anomely)");
				}
				
			}
			
		}
	}
}
