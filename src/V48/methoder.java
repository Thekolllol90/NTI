package V48;

import java.util.Scanner;

public class methoder {
 public static void main(String[] args) {
	 Scanner scanner = new Scanner (System.in);
	 double cm = 1;
	 System.out.printf("%.10f m^3",cm3tom3(cm));
	 System.out.println("");
	 System.out.println("");
	 
	String name1 = "Jakob";
	String name2 = "nyklaz";
	double age1 = 20;
	double age2 = 15;
	System.out.println(greetingPlusAge(name1, name2, age1, age2));
	System.out.println("");
	System.out.println("");
	
	double first = 11;
	double last = 12;
	System.out.print(delta(first, last));
	System.out.println(" ");
	
	double radius = 10;
	System.out.print(volumeOfSphere(radius));
	scanner.close();
}

	public static double kelvinToCelsius(double kelvin){
		double Celsius = kelvin - 273.15;
		return Celsius;
	}
	public static double cm3tom3(double cm){
		return cm / 1000000;
	}
	public static String greetingPlusAge(String name1, String name2, double age1, double age2) {
		String text = "hej " + name1 + " din bög." + " hej " + name2 + " hur mår du?" + " eran ålder blir " + (age1 + age2);
		return text;
	}
	public static double delta(double first, double last){  
		if(first >= last) {
		double delta = first - last;
		return delta;
		} else {
			double delta = last - first;
			return delta;
		}
	}
	public static double volumeOfSphere(double radius) {
		double volym = ((Math.PI * Math.pow(radius, 3) * 4) / 3);
		
		return volym;
	}
}
