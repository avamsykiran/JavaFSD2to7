package com.cts.jsedemo.fundas;

public class App03 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Hello, My name is Gagan Bihari Nisal. Currently Im working as PAT in Cognizant. My employee id 2118959.";
		char[] ch = input.toCharArray();
		int letter = 0;
		int space = 0;
		int num = 0;
		int sentences = 0;
		for (char c:ch) {
			if (Character.isLetter(c)) {
				letter++;
			} else if (Character.isSpaceChar(c)) {
				space++;
			} else if (Character.isDigit(c)) {
				num++;
			} else if (c == '.') {
				sentences++;
			}
		}
		System.out.println("Input:\n" + input);
		System.out.println("Character Count: " + input.length());
		System.out.println("Alpha Count: " + letter);
		System.out.println("Digits: " + num);
		System.out.println("Words: " + (space + 1));
		System.out.println("Sentences: " + sentences);
		// System.out.println("other: " + other);
	}
}
