package V14;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import hangman.HangmanConsoleWindow;

public class Hangman {
	
	private static HangmanConsoleWindow window = new HangmanConsoleWindow();
	private static String[] word = {"ström", "eld", "vatten", "sol", "sten", "skor", "hund", "katt", "bord", "den", "nej", "hangman", "vaa", "haa"};

	public static void main(String[] args) {
		
		boolean playing = true;
		while(playing) {
			window.changeTextColor(Color.green);
			window.clear();
			window.println("what game will you play?");
			window.println("1. hangman 2. 3. 4. 5.");
			char game = window.nextChar();
			if(game == '1') {
				hangman();
			}else {
				window.clear();
				window.println("please pick an existing game");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void hangman(){
		boolean hangman = true;
		String playWord = "";
		int word;
		while (hangman) {
		window.clear();
		window.println("are you going to play with");
		window.println("a friend or alone?");
		window.println("1. alone 2. friend");
		char type = window.nextChar();
		if(type == '1') {
			playWord = generatedWord();
			hangman = false;
		} else if(type == '2') {
			hangman = false;
			window.clear();
			window.println("Do you want to use a generated");
			window.println("word or your own word?");
			window.println("1. Generated     2. own word");
			word = window.nextChar();
			if(word == '1') {
				playWord = generatedWord();
			} else if(word == '2') {
				playWord = ownWord();
			} else {
				invalid();
			}
		} else {
			invalid();
		}
		}
		char[] splitWord = stringToArrayList(playWord);	
		hangman_play(splitWord,playWord);
	}
	public static void hangman_play(char[] splitWord, String playWord) {
		boolean hang  = true;
		boolean game = true;
		boolean rightLetter = true;
		int wrong = 0;
		int right = 0;
		int guess = 0;
		int loop = 1;
		char guessLetter = ' ';
		char[] wrongLetter = new char[10];
		char[] typeWord = new char[playWord.length()];
		for(int i = 0; i < playWord.length(); i++) {
			typeWord[i] = '_';
		}
		for(int i = 0; i < 10; i++) {
			wrongLetter[i] = '_';
		}
		while(hang) {
			window.clear();
			while(game) {
			guess++;
			window.println("Type a letter");
			guessLetter = window.nextChar();
			
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
			window.print("" + typeWord[i]);
		}
		window.println();
		if(wrong == 1) {
			window.print("----------");
		} else if(wrong == 2) {
			window.println("     |    ");
			window.println("     |    ");
			window.println("     |    ");
			window.println("     |    ");
			window.print("-----|----");
		} else if(wrong == 3) {
			window.println("     _________    ");
			window.println("     |    ");
			window.println("     |    ");
			window.println("     |    ");
			window.println("     |    ");
			window.print("-----|----");
		} else if(wrong == 4) {
			window.println("     _________    ");
			window.println("     |       | ");
			window.println("     |       |");
			window.println("     |    ");
			window.println("     |    ");
			window.println("     |    ");
			window.println("     |    ");
			window.print("-----|----");
			window.changeTextColor(Color.yellow);
		} else if(wrong == 5) {
			window.println("     _________    ");
			window.println("     |       | ");
			window.println("     |       |");
			window.println("     |       O ");
			window.println("     |      /|");
			window.println("     |    ");
			window.println("     |    ");
			window.print("-----|----");
		} else if(wrong == 6) {
			window.println("     _________    ");
			window.println("     |       | ");
			window.println("     |       |");
			window.println("     |       O ");
			window.println("     |      /|\\");
			window.println("     |       ");
			window.println("     |      ");
			window.print("-----|----");
		} else if(wrong == 7) {
			window.println("     _________    ");
			window.println("     |       | ");
			window.println("     |       |");
			window.println("     |       O ");
			window.println("     |      /|\\");
			window.println("     |       |");
			window.println("     |      /");
			window.print("-----|----");
			window.changeTextColor(Color.red);
		}else if(wrong == 8) {
			window.clear();
			window.println("     _________    ");
			window.println("     |       | ");
			window.println("     |       |");
			window.println("     |       O ");
			window.println("     |      /|\\");
			window.println("     |       |");
			window.println("     |      / \\");
			window.println("-----|----");
			
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