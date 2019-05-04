package V14;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import hangman.HangmanConsoleWindow;

public class Hangman {
	
	private static HangmanConsoleWindow window = new HangmanConsoleWindow();
	private static String[] word = {"ström", "eld", "vatten", "sol", "sten", "skor", "hund", "katt", "bord", "den", "nej", "hangman"};

	
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
				window.println();
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
		String playWord = "";
		int word;
		window.clear();
		window.println("are you going to play with");
		window.println("a friend or alone?");
		window.println("1. alone 2. friend");
		char type = window.nextChar();
		if(type == '1') {
			playWord = generatedWord();
		} else if(type == '2') {
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
		char[] splitWord = stringToArrayList(playWord);	
		hangman_play(splitWord,playWord);
	}
	
	public static void hangman_play(char[] splitWord, String playWord) {
		boolean hang  = true;
		boolean game = true;
		int wrong = 0;
		int right = 0;
		int guess = 0;
		char guessLetter = ' ';
		char[] typeWord = new char[playWord.length()];
		for(int i = 0; i < playWord.length(); i++) {
			typeWord[i] = '_';
		}
		while(hang) {
			while(game) {
			guess++;
			window.clear();
			window.println("Type a letter");
			guessLetter = window.nextChar();
			for(int i = 0; i < playWord.length(); i++) {
				if(typeWord[i] == '_') {
					if(splitWord[i] == guessLetter) {
						typeWord[i] = guessLetter;
						right++;
					}else {
						wrong++;					
					}
				}
			}
			drawMan(wrong, typeWord);
			if(right == splitWord.length) {
				
			}
			}
			hang = playAgain();
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
	public static boolean playAgain() {
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
	}	
	public static void drawMan(int wrong, char[] typeWord) {
		window.clear();
		window.print(Arrays.toString(typeWord));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
}
