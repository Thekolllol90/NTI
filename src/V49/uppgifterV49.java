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
}
public static int antal7(int[] numbers) {
	int result = 0;
	for (int i = 0; i < numbers.length; i++) {
		if(numbers[i] == 7) {
			result++;
		}
	}
	return result;
	}
public static int antalTom(String[] names) {
	int result = 0;
	for (int i = 0; i < names.length; i++) {
		if(names[i] == "Tom") {
			result++;
		}
	}
	return result;
	}
public static int störstMinst(int[] numbers) {
	int result = 0;
	for (int i = 0; i < numbers.length; i++) {
		
	}
	return result;
}
public static int index(String[] names) {
	int res = 0;
	for (int i = 0; i < names.length; i++) {
		if(names[i] == "Drusilla") {
			res = i;
		}
	}
	return res;
}
public static int summa(int[] numbers) {
	int result = 0;
	for (int i = 0; i < numbers.length; i++) {
		if(numbers[i] == 2) {
			result = result + 2;
		}else if(numbers[i] == 4) {
			result = result + 4;
		}else if(numbers[i] == 6) {
			result = result + 6;
		}else if(numbers[i] == 8) {
			result = result + 8;
		}
	}
	return result;
}
public static int antalL(String[] names) {
	int result = 0;
	for (int i = 0; i < names.length; i++) {
		if(names[i].charAt(0) == 'L') {
			result++;
		}
	}
	return result;
}
public static int long5(String[] names) {
	int result = 0;
	for (int i = 0; i < names.length; i++) {
		if(names[i].length() ==  5) {
			result++;
		}
	}
	return result;
}
public static int[] antaltal(int[] numbers){
    int[] result = new int[10];

    for(int i=0;i<numbers.length;i++){
    	
        result[numbers[i]]++;
        
    }
    
    return result;
}
}
