package com.capgemini.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DesignerPdfViewer {

	// Complete the designerPdfViewer function below.
	static int designerPdfViewer(int[] h, String word) {
		char a = 'a';
		int aa = Character.getNumericValue(a);
		List<Integer> heights = new ArrayList<Integer>();
		
		char [] charWord = word.toCharArray();
		
		for(int i = 0; i < charWord.length; i++) {
			char letter = charWord[i];
			int characterValue = Character.getNumericValue(letter);
			int index = characterValue - aa;
			heights.add(h[index]);
		}
		
		int maxHeight = Collections.max(heights);
		
		int area = maxHeight * word.length();
		
		return area;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int[] h = new int[26];
		System.out.println("Enter the heights of each alphabet");
		String[] hItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < 26; i++) {
			int hItem = Integer.parseInt(hItems[i]);
			h[i] = hItem;
		}
		System.out.println("Enter a string value: ");
		String word = scanner.nextLine();

		int result = designerPdfViewer(h, word);

		System.out.println(String.valueOf(result));
	
		scanner.close();
	}

}
