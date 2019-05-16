package V14;

import java.awt.Color; //importerar
import java.util.ArrayList;
import java.util.Arrays;
import hangman.HangmanConsoleWindow;

public class Hangman {
	
	private static HangmanConsoleWindow window = new HangmanConsoleWindow(); // skapar ett f�nster som spelet k�rs i. �r tillg�nglig �verallt
	private static String[] word = {"wire", "fire", "water", "sun", "stone", "foot", "dog", "cat", "table", "window", "mirror", "hangman", "computer", "phone"}; //lista med olika ord som kan bli slumpade. �r tillg�nglig �verallt

	public static void main(String[] args) { //main method
		
		boolean playing = true; // skapar en variabel
		while(playing) { // skapar en loop som g�ller medans playing �r sant
			window.changeTextColor(Color.green); // �ndrar f�rgen p� texten i window till gr�nt
			window.clear(); // rensar f�nstret
			window.println("what game will you play?"); //fr�gar vilket spel man vill k�
			window.println("1. hangman 2. 3. 4. 5."); // ger allternativ p� spel
			char game = window.nextChar(); // l�ter personen v�lja ett spel och sparar valet
			if(game == '1') { // om man v�ljer 1 startar hangman methoden
				hangman();
			}else { // om man v�ljer n�got som inte finns s� g�r den in h�r
				window.clear();
				window.println("please pick an existing game");
				try {
					Thread.sleep(2000); // stoppar programet i antal millisekunder
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * kollar om man ska spela sj�lv eller med en v�n. om man ska spela med en v�n s� fr�gar den om man vill skapa ett eget ord eller slupma ett som n�r man k�r ensam.
	 * return: null
	 */
	public static void hangman(){
		boolean hangman = true; 
		String playWord = ""; // skapar en tom string
		int word; // skapar en tom int
		while (hangman) { // medans hangman �r sant k�rs koden 
		window.clear();
		window.println("are you going to play with");
		window.println("a friend or alone?");
		window.println("1. alone 2. friend");
		char type = window.nextChar(); // skapra och spara det som skrivs in i en char
		if(type == '1') { // om man v�ljer 1 blir hangman falsk och methoden generatedWord k�rs
			playWord = generatedWord(); // k�r methoden och sparar resultatet i playWord
			hangman = false;
		} else if(type == '2') { // om man v�ljer 2 fr�gar den om man vill g�ra ett eget ord eller sluma ett
			hangman = false;
			window.clear();
			window.println("Do you want to use a generated");
			window.println("word or your own word?");
			window.println("1. Generated     2. own word");
			word = window.nextChar();
			if(word == '1') { // om 1 slumpar den ett ord
				playWord = generatedWord(); // k�r methoden och sparar resultatet i playWord
			} else if(word == '2') { //om man v�ljer 2 f�r man skapa ett eget ord
				playWord = ownWord(); // k�r methoden och sparar resultatet i playWord
			} else { // om man inte v�ljer n�got av alternativen
				invalid(); //k�r methoden och g�r tillbaka
			}
		} else { // om man inte v�ljer n�got av alternativen
			invalid(); //k�r methoden och g�r tillbaka till topen pga while loopen
		}
		}
		char[] splitWord = stringToArrayList(playWord);//k�r methoden och sparar resultatet
		hangman_play(splitWord,playWord); // startar methoden hangman_play och skickar med n�gra variabler
	}
	public static void hangman_play(char[] splitWord, String playWord) {
		boolean hang  = true; // skapar variabler
		boolean game = true;
		boolean rightLetter = true;
		int wrong = 0;
		int right = 0;
		int guess = 0;
		int loop = 1;
		int exsist = 0;
		char guessLetter = ' '; 
		char[] wrongLetter = new char[8]; // skapar en char array med 10 platser
		char[] typeWord = new char[playWord.length()]; // skapar en char array med lika m�nga platser som playWord
		for(int i = 0; i < playWord.length(); i++) { //fyller typeword med _
			typeWord[i] = '_';
		}
		for(int i = 0; i < 8; i++) { //fyller wrongletter med _
			wrongLetter[i] = '_';
		}
		window.clear();
		for(int i = 0; i < typeWord.length; i++) {
			window.print(" " + typeWord[i]);
		}
		window.println();
		while(hang) {
			while(game) {
			guess++; // l�gger till 1 p� antal gissningar
			window.println("Type a letter");
			guessLetter = window.nextChar(); // sparar bokstaven man gissar
			
			if(Character.isAlphabetic(guessLetter)) {	//kollar s� att bokstaven man skriver �r en bokstav och inte n�got annat
			for(int i = 0; i < playWord.length(); i++) { //en loop som sparar om man skrivit r�tt bokstav p� r�tt plats
				if(typeWord[i] == '_') {
					if(splitWord[i] == guessLetter) {
						typeWord[i] = guessLetter;
						right++; 
						rightLetter = false; //g�r s� att den inte sparar
					}
				}
			}
			loop = 1; //s�tter den till 1 f�r att l�sa ett problem som g�r att den dubblar det den skriver
			for(int i = 0; i < loop; i++) { //en loop som sparar det som man skrivt fel och bara en g�ng
				if(guessLetter == wrongLetter[i]) {
					rightLetter = false; 
					guess--;
				}
				if(wrongLetter[i] == '_' && rightLetter) {
					wrongLetter[i] = guessLetter;
					rightLetter = true;
					wrong++;			

				} else if(rightLetter){
					loop++; //g�r s� att om f�rsta platsen redan har n�got g�r den till n�sta plats
				} else {
					rightLetter = true;
	
				}
			}

			game = drawMan(wrong, typeWord, wrongLetter, game, splitWord);
			if(right == splitWord.length) { //kollar s� man skrivit r�tt p� allt
					window.clear();
					window.println("you won!!");
					window.println("it took you " + guess + " tries");
					window.print("the word was ");
					for(int i = 0; i < splitWord.length; i++) { //skriver ut hela ordet
						window.print("" + splitWord[i]); 
					}
					
					window.println();
					window.print("To continue press space");
					window.nextChar(); // v�ntar p� att man trycker p� en kanpp s� g�r programet vidare
					game = false;
				}
			}else {
				invalid();
			}
			}
			hang = false;
		}
	}
/**
 * l�ter en skriva in ett eget ord
 * @return det egna ordet
 */
	public static String ownWord() {
		String Playword;
		window.clear();
		window.println("whats the word?");
		Playword = window.nextString().toLowerCase(); //g�r det man skriver till sm� bockst�ver
		return Playword;
		}
	/**
	 * anv�nds om man trycker p� en knapp som inte man ska trycka p�
	 */
	public static void invalid() {
		window.clear();
		window.println("please pick a valid option");
		try {
			Thread.sleep(2000); //stoppar programet i antalet millisekunder
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * tar ett random ord fr�n arraylistan med ord
	 * @return ordet som �r taget ur listan
	 */
	public static String generatedWord() {
		String gWord = "";
		int random = (int)(Math.random() * 14 + 1); //genererar ett random number 
		for(int i = 0; i < random; i++) {
			gWord = word[i];
		}
		return gWord;
	}
	/**
	 * g�r om en string till en char array
	 * @param playWord oredt som skickas med allts� ett eget ord eller ett random
	 * @return char array f�r ordet
	 */
	public static char[] stringToArrayList(String playWord) {
		char[] splitWord = playWord.toCharArray(); //g�r om string till char array
		return splitWord;
	}
	/*public static boolean playAgain() {

		boolean hang = false;
		boolean choose = true;
		
		while(choose) {
		window.clear();
		window.println("Do you want to play again?");
		window.println("1. yes     2. no");
		char play = window.nextChar();
			if(play == '2') {
				hang = false;
				choose = false;
			} else if(play == '1') {
				hang = true;
				choose = false;
			} else {
				invalid();
			} 
		}
		return hang;
	}	*/
	/**
	 * skriver ut det man gissat, m�lar en liten gubbe, och skriver ut det man gjort fel
	 * @param wrong hur m�nga fel man har s� den kan m�la gubben
	 * @param typeWord ordet man skriver
	 * @param wrongLetter bokst�verna man skrivit fel
	 * @param game om spelat ska k� eller inte
	 * @param splitWord hela ordet
	 * @return
	 */
	public static boolean drawMan(int wrong, char[] typeWord, char[] wrongLetter, boolean game, char[] splitWord) {
		window.clear();
		for(int i = 0; i < typeWord.length; i++) { //skriver ut det man kommit fram till
			window.print(" " + typeWord[i]);
		}
		window.println();
		if(wrong == 1) {
			window.print("----------");
		} else if(wrong == 2) {
			window.println("     |    ");
			window.println("     |    ");
			window.println("     |    ");
			window.println("     |    ");
			window.print("----/|\\----");
		} else if(wrong == 3) {
			window.println("     _________    ");
			window.println("     |/    ");
			window.println("     |    ");
			window.println("     |    ");
			window.println("     |    ");
			window.print("----/|\\----");
		} else if(wrong == 4) {
			window.println("     _________    ");
			window.println("     |/     \\| ");
			window.println("     |       |");
			window.println("     |    ");
			window.println("     |    ");
			window.println("     |    ");
			window.println("     |    ");
			window.print("----/|\\----");
			window.changeTextColor(Color.yellow); //g�r om f�rgen till gul
		} else if(wrong == 5) {
			window.println("     _________    ");
			window.println("     |/     \\| ");
			window.println("     |       |");
			window.println("     |       O ");
			window.println("     |      /|");
			window.println("     |    ");
			window.println("     |    ");
			window.print("----/|\\----");
		} else if(wrong == 6) {
			window.println("     _________    ");
			window.println("     |/     \\| ");
			window.println("     |       |");
			window.println("     |       O ");
			window.println("     |      /|\\");
			window.println("     |       ");
			window.println("     |      ");
			window.print("----/|\\----");
		} else if(wrong == 7) {
			window.println("     _________    ");
			window.println("     |/     \\| ");
			window.println("     |       |");
			window.println("     |       O ");
			window.println("     |      /|\\");
			window.println("     |       |");
			window.println("     |      /");
			window.print("----/|\\----");
			window.changeTextColor(Color.red); //g�r om r�gen till r�d
		}else if(wrong == 8) {
			window.clear();
			window.println("     _________    ");
			window.println("     |/     \\| ");
			window.println("     |       |");
			window.println("     |       O ");
			window.println("     |      /|\\");
			window.println("     |       |");
			window.println("     |      / \\");
			window.println("----/|\\----");
			
			window.println();
			window.println("You lose!");
			window.println();
			window.print("The word was ");
			for(int i = 0; i < splitWord.length; i++) { //skriver ut ordet
				window.print("" + splitWord[i]);
			}
			window.println();
			window.print("To continue press space");
			window.nextChar();
			game = false;
		}
		window.println();
		window.println("Wrong Letters");
		for(int i = 0; i < wrongLetter.length; i++) {
			window.print(" " + wrongLetter[i]);	
		}
		window.println();
		return game;
	}
	
}