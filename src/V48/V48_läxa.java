package V48;

import java.util.Scanner;

public class V48_l�xa {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		double radius = 10;
		System.out.println(volumeOfSphere(radius));
		
		String strr = "boi";
		System.out.println(reverseString(strr));
		
		String x = "ccccc";
		System.out.println(count(x));
		
		String str = "neo";
		System.out.println(piratSpr�k(str));
	}
	/**
	 * tar in en radie och skriver volymen 
	 * @param radius radien
	 * @return volymen 
	 */
	public static double volumeOfSphere(double radius) { 
		double volym = ((Math.PI * Math.pow(radius, 3) * 4) / 3);
		
		return volym;
	}
	/**
	 * tar en string och skriver ut den backl�nges
	 * @param str texten man vill v�nda
	 * @return den v�nda texten 
	 */
	public static String reverseString(String strr) {
		String res = "";
		for (int i = strr.length() - 1; i >= 0; i--) {
			res += strr.charAt(i);
		}
		
		return res;
	}
	/**
	 * r�knar hur m�nga g�nger c anv�nds i en string
	 * @param x stringen
	 * @return
	 */
	public static int count(String x) {
		int y = x.length() - x.replace("c", "").length();
		
		return (y);
	}
	/**
	 * skriver om ett ord i piratspr�k
	 * @param str ordet man vill skriva om
	 * @return ordet i piratspr�k
	 */
	public static String piratSpr�k(String str){
        char konsonant[] = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'w', 'v', 'z', 'x' };
        String result = "";
        for(int i = 0; i < str.length(); i++) {
            boolean found = false;
            for(int j = 0; j < konsonant.length; j++) {
                if(str.charAt(i) == konsonant[j]) {
                    found = true;
                    break;
                }
            }

            if(found) {
                result += (str.charAt(i) + "o" + str.charAt(i));
            }
            else {
                result += str.charAt(i);
            }
        }
        return result;
	}
}
