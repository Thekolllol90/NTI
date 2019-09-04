package V35;

import java.util.Scanner;

public class repitition {
	public static void main(String[] args) {
		
	summera_array();
	
	vander_ord();
	
	}
	
	public static void summera_array() {
		int[] array = {1, 4, 8};
		int x = 0;
		
		for(int i = 0; i < array.length; i++) {
			x = x + array[i];
		}
		
		System.out.print(x);
	}
	
	public static void vander_ord() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Skriv in tre ord");
		
		String one = "";
		String two = "";
		String three = "";
		
		one = scanner.nextLine();
		two = scanner.nextLine();
		three = scanner.nextLine();
		
		System.out.print(three + " " + two + " " + one);
		
	}
}
