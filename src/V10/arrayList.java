package V10;

import java.util.ArrayList;
import java.util.Scanner;

public class arrayList {
	public static void main(String[] args) {
		
		int[] niklas = {1, 2, 3, 4, 5};
		String[] boi = {"Sträng" , "hej", "bög", "lol", "yeet"};
		
		for (int i = 0; i < niklas.length; i++) {
			System.out.print(niklas[i]);
			System.out.println(" " + boi[i]);

		}
		System.out.println();
		System.out.println();
		List();
	}
	
	
	
	public static void List() {
		
		ArrayList<String> nameList = new ArrayList<>();

		nameList.add("NIKLAS");
		nameList.add("PATRIK");
		nameList.add("THEO");
		
		for(int i = 0; i < nameList.size(); i++) {
			System.out.print(" " + nameList.get(i));
		}
		System.out.println();
		nameList.add(1, "Anna");
		System.out.println(nameList);
		
		nameList.set(2, "Britt");
		System.out.println(nameList);
		
		nameList.remove(3);
		System.out.println(nameList);

		nameList.remove("Britt");
		System.out.println(nameList);

		ArrayList<Integer> wow = new ArrayList<>();
		wow.add(123 * 2);
		wow.add(new Integer(123));
		
		for (int i = 0; i < 100; i++) {
			wow.add(i * i);
		}
		
		int l = wow.get(0);
		
		System.out.println(wow);
		
	}
	
	
	

}
