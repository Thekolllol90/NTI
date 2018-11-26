package V46;

import java.util.Scanner;
import java.util.ArrayList;

public class bijele {
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		String boi = scanner.nextLine();
		
		ArrayList<Integer> list = new ArrayList<Integer>() {{
			add(1);
			add(1);
			add(2);
			add(2);
			add(2);
			add(8);
		}} ;
		String[] boii = boi.split(" +");
	for(int i = 0; i < boii.length; i++) {
		if(Integer.parseInt(boii[i]) == list.get(i)){
			System.out.println("0");
		} else {
			System.out.println(list.get(i) - Integer.parseInt(boii[i]));
		}
	}
		
		
		
		scanner.close();
	}
}
