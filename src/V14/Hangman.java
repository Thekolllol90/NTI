package V14;

import java.awt.Color; //importerar
import java.util.ArrayList;
import java.util.Arrays;
import hangman.HangmanConsoleWindow;

public class Hangman {
	
	private static HangmanConsoleWindow window = new HangmanConsoleWindow(); // skapar ett fönster som spelet körs i. är tillgänglig överallt
	private static String[] word = {"wire", "fire", "water", "sun", "stone", "foot", "dog", "cat", "table", "window", "mirror", "hangman", "computer", "phone"}; //lista med olika ord som kan bli slumpade. är tillgänglig överallt

	public static void main(String[] args) { //main method
		
		boolean playing = true; // skapar en variabel
		while(playing) { // skapar en loop som gäller medans playing är sant
			window.changeTextColor(Color.green); // ändrar färgen på texten i window till grönt
			window.clear(); // rensar fönstret
			window.println("what game will you play?"); //frågar vilket spel man vill kö
			window.println("1. hangman 2. 3. 4. 5."); // ger allternativ på spel
			char game = window.nextChar(); // låter personen välja ett spel och sparar valet
			if(game == '1') { // om man väljer 1 startar hangman methoden
				hangman();
			}else { // om man väljer något som inte finns så går den in här
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
	 * kollar om man ska spela själv eller med en vän. om man ska spela med en vän så frågar den om man vill skapa ett eget ord eller slupma ett som när man kör ensam.
	 * return: null
	 */
	public static void hangman(){
		boolean hangman = true; 
		String playWord = ""; // skapar en tom string
		int word; // skapar en tom int
		while (hangman) { // medans hangman är sant körs koden 
		window.clear();
		window.println("are you going to play with");
		window.println("a friend or alone?");
		window.println("1. alone 2. friend");
		char type = window.nextChar(); // skapra och spara det som skrivs in i en char
		if(type == '1') { // om man väljer 1 blir hangman falsk och methoden generatedWord körs
			playWord = generatedWord(); // kör methoden och sparar resultatet i playWord
			hangman = false;
		} else if(type == '2') { // om man väljer 2 frågar den om man vill göra ett eget ord eller sluma ett
			hangman = false;
			window.clear();
			window.println("Do you want to use a generated");
			window.println("word or your own word?");
			window.println("1. Generated     2. own word");
			word = window.nextChar();
			if(word == '1') { // om 1 slumpar den ett ord
				playWord = generatedWord(); // kör methoden och sparar resultatet i playWord
			} else if(word == '2') { //om man väljer 2 får man skapa ett eget ord
				playWord = ownWord(); // kör methoden och sparar resultatet i playWord
			} else { // om man inte väljer något av alternativen
				invalid(); //kör methoden och går tillbaka
			}
		} else { // om man inte väljer något av alternativen
			invalid(); //kör methoden och går tillbaka till topen pga while loopen
		}
		}
		char[] splitWord = stringToArrayList(playWord);//kör methoden och sparar resultatet
		hangman_play(splitWord,playWord); // startar methoden hangman_play och skickar med några variabler
	}
	public static void hangman_play(char[] splitWord, String playWord) {
		boolean hang  = true; // skapar variabler
		boolean game = true;
		boolean rightLetter = true;
		int wrong = 0;
		int right = 0;
		int guess = 0;
		int loop = 1;
		char guessLetter = ' '; 
		char[] wrongLetter = new char[10]; // skapar en char array med 10 platser
		char[] typeWord = new char[playWord.length()]; // skapar en char array med lika många platser som playWord
		for(int i = 0; i < playWord.length(); i++) { //fyller typeword med _
			typeWord[i] = '_';
		}
		for(int i = 0; i < 10; i++) { //fyller wrongletter med _
			wrongLetter[i] = '_';
		}
		while(hang) {
			window.clear();
			while(game) {
			guess++; // lägger till 1 på antal gissningar
			window.println("Type a letter");
			guessLetter = window.nextChar(); // sparar bokstaven man gissar
			
			if(Character.isAlphabetic(guessLetter)) {		
			for(int i = 0; i < playWord.length(); i++) {
				if(typeWord[i] == '_') {
					if(splitWord[i] == guessLetter) {
						typeWord[i] = guessLetter;
						right++;
						rightLetter = false;
					}
				}
			}
			loop = 1;
			for(int i = 0; i < loop; i++) {
				if(guessLetter == wrongLetter[i]) {
					rightLetter = false;
					guess--;
				}
				if(wrongLetter[i] == '_' && rightLetter) {
					wrongLetter[i] = guessLetter;
					rightLetter = true;
					wrong++;			

				} else if(rightLetter){
					loop++;
				} else {
					rightLetter = true;
	
				}
			}

			game = drawMan(wrong, typeWord, wrongLetter, game, splitWord);
			if(right == splitWord.length) {
					window.clear();
					window.println("you won!!");
					window.println("it took you " + guess + " tries");
					window.print("the word was ");
					for(int i = 0; i < splitWord.length; i++) {
						window.print("" + splitWord[i]);
					}
					
					window.println();
					window.print("To continue press space");
					window.nextChar();
					game = false;
				}
			}else {
				invalid();
			}
			}
			hang = false;
		}
	}

	public static String ownWord() {
		String Playword;
		window.clear();
		window.println("whats the word?");
		Playword = window.nextString().toLowerCase();
		return Playword;
		}
	public static void invalid() {
		window.clear();
		window.println("please pick a valid option");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static String generatedWord() {
		String gWord = "";
		int random = (int)(Math.random() * 8 + 1);
		for(int i = 0; i < random; i++) {
			gWord = word[i];
		}
		return gWord;
	}
	public static char[] stringToArrayList(String playWord) {
		char[] splitWord = playWord.toCharArray();
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
	public static boolean drawMan(int wrong, char[] typeWord, char[] wrongLetter, boolean game, char[] splitWord) {
		window.clear();
		for(int i = 0; i < typeWord.length; i++) {
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
			window.changeTextColor(Color.yellow);
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
			window.changeTextColor(Color.red);
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
			for(int i = 0; i < splitWord.length; i++) {
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