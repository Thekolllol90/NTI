package V49;

public class uppgifterV49 {
public static void main(String[] args) {
	
		// 100 tal i intervallet [0-9]
		int[] numbers = {1,1,1,2,6,7,8,4,3,7,8,9,3,1,3,7,8,5,3,4,8,9,6,4,2,4,7,9,7,4,3,2,3,6,7,8,7,7,5,7,9,6,1,4,0,8,6,5,6,8,9,0,7,5,4,3,2,4,5,9,8,5,9,8,8,4,5,6,7,8,9,0,9,0,9,7,5,2,1,2,3,4,5,4,4,5,3,4,5,0,8,7,0,7,9,7,0,6,5,4};


		// 100 namn
		String[] names = {"Crystal","Tam","Ed","Beulah","Daina","Benjamin","Kia","Clelia","Cassy","Gita","Celsa","Karoline","Talitha","Lewis","Betsy","Colin","Glendora","Carola","Rosalba","Jeanie","Yevette","Armand","Neal","Lilla","Dorethea","Delta","Maye","Nikita","Shoshana","Carola","Margie","Haywood","Venessa","Natacha","Gilbert","Kandi","Tyisha","Tammie","Blossom","Penney","Diana","Audrey","Willard","Zoraida","Drusilla","Jacquline","Cyndy","Janiece","Tressie","Kami","Lashanda","Leann","Tom","Santana","Junita","Gisela","Tom","Marquerite","Bryant","Lauralee","Yael","Kelle","Samantha","Tom","Meta","Lanette","Wanetta","Carola","Jana","Neal","Brady","Rigoberto","Felicia","Hellen","Georgeann","Carola","Isaias","Ellis","Roseanne","Lenard","Ela","Ophelia","Alesha","Mafalda","Flor","Kelsi","Autumn","Sondra","Pasty","Jacquelyne","Benjamin","Emmie","Mickie","Lang","Jamee","Felice","Daniella","Carola","Nathalie","Genevive"};
		
		System.out.println(antal7(numbers));
		System.out.println(antalTom(names));
		
		System.out.println(index(names));
		System.out.println(summa(numbers));
		System.out.println(antalL(names));
		System.out.println(long5(names));
		System.out.println(antaltal(numbers));
		System.out.println(antalunikanamn(names));
		System.out.println(vanligastnamn(names));
}
/**
 * kollar antal 7or i en arry
 * @param numbers listan/arrayen med number
 * @return antal 7or
 */
public static int antal7(int[] numbers) {
	int result = 0;
	for (int i = 0; i < numbers.length; i++) { // en lopp beroende på hur lång arrayen är
		if(numbers[i] == 7) {
			result++;
		}
	}
	return result;
	}
/**
 * räknar hur många gånger tom kommer upp i en array
 * @param names listan/arrayen med namn
 * @return antal tom
 */
public static int antalTom(String[] names) {
	int result = 0;
	for (int i = 0; i < names.length; i++) { // en lopp beroende på hur lång arrayen är
		if(names[i] == "Tom") {
			result++;
		}
	}
	return result;
	}
/**
 * kollar vilket number det finns mest och minst utav
 * @param numbers
 * @return
 */
public static int strörstminst(int[] numbers){
    int noll = 0;
    int ett = 0;
    int två = 0;
    int tre = 0;
    int fyra = 0;
    int fem = 0;
    int sex = 0;
    int sju = 0;
    int åta = 0;
    int nio = 0;
    return 0;
}
/**
 * kollar vilken index som namnet drusilla ligger på
 * @param names arryen med namn
 * @return indexen som namnet ligger på
 */
public static int index(String[] names) {
	int res = 0;
	for (int i = 0; i < names.length; i++) { // en lopp beroende på arrayen
		if(names[i] == "Drusilla") {
			res = i;
		}
	}
	return res;
}
/**
 * suman utav alla jämna tal
 * @param numbers arrayen med talen 
 * @return summan 
 */
public static int summa(int[] numbers) {
	int result = 0;
	for (int i = 0; i < numbers.length; i++) { //lopp beroende på array
		if(numbers[i] == 2) { //om 2 lägg till 2
			result = result + 2; 
		}else if(numbers[i] == 4) { // om 4 lägg till 4
			result = result + 4;
		}else if(numbers[i] == 6) { // -||-
			result = result + 6;
		}else if(numbers[i] == 8) { // -||-
			result = result + 8;
		}
	}
	return result;
}
/**
 * räknar hur många namn som börjar på bokstaven L
 * @param names arrayen med namn
 * @return antal L 
 */
public static int antalL(String[] names) {
	int result = 0;
	for (int i = 0; i < names.length; i++) { // lopp beronde på array
		if(names[i].charAt(0) == 'L') { // kollar om första bokstaven = L
			result++;
		}
	}
	return result;
}
/**
 * kollar hur många namn som är 5 bokstäver lång
 * @param names arrayen med namn
 * @return hur många namn
 */
public static int long5(String[] names) {
	int result = 0;
	for (int i = 0; i < names.length; i++) { // array beroende utav array
		if(names[i].length() ==  5) { // kollar längden
			result++;
		}
	}
	return result;
}
/**
 * kollar hur många det finns utav alla tal
 * @param numbers arrayen med number
 * @return hur många det finns utav alla tal
 */
public static int[] antaltal(int[] numbers){
    int[] result = new int[10];
    for(int i = 0; i < numbers.length; i++){ // lopp berodende utav array
        result[numbers[i]]++;
    }
    return result;
}
/**
 * räknar ut hur många unika namn det finns
 * @param names array med namn
 * @return antal namn
 */
public static int antalunikanamn(String[] names){
    int result = 0;
    for (int i = 0; i < names.length; i++) { // lopp berodnde utav array
        int j;
        for (j = 0; j < names.length; j++) { // lopp berodnde utav array
            if(names[i].equals(names[j])) { // om namnet inte redan har lästst lägg till 1 till result
                break;  
            }
        }
        if(i == j) {
            result++;
        }
    }
    return result;
}
/**
 * kollar vilket namn som är valigast
 * @param names array med namn
 * @return vanligaste namnet
 */
public static String vanligastnamn(String[] names){
    int Index = 0;
    int Length = 0;
    for (int i = 0; i < names.length; i++) { // lopp berodnde utav array
        int res = 0;
        for (int j = 0; j < names.length; j++) { // lopp berodnde utav array
            if(names[i].equals(names[j])) {
                res++;
            }
        }
        if(res > Length) {
            Length = res;
            Index = i;  
        }
    }
    return names[Index];
}
}
