package org.hearth.march14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jeevan
 * @orgaization :)
 * @date 18-Mar-2014 10:35:39 PM
 * 
 *       Danny has a possible list of passwords of Manny's facebook account. All
 *       passwords length is odd. But Danny knows that Manny is a big fan of
 *       palindromes. So, his password and reverse of his password both should
 *       be in the list.
 * 
 *       You have to print the length of Manny's password and it's middle
 *       character.
 * 
 *       Note : The solution will be unique.
 * 
 *       INPUT The first line of input contains the integer N, the number of
 *       possible passwords. Each of the following N lines contains a single
 *       word, its length being an odd number greater than 2 and lesser than 14.
 *       All characters are lowercase letters of the English alphabet.
 * 
 *       OUTPUT The first and only line of output must contain the length of the
 *       correct password and its central letter.
 * 
 *       CONSTRAINTS 1 ≤ N ≤ 100
 * 
 *       Sample Input (Plaintext Link) 4 abc def feg cba
 * 
 *       Sample Output (Plaintext Link) 3 b
 */

public class Password {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Password pass = new Password();

		try {
			String input = br.readLine();
			String palindrome;
			int cases = Integer.parseInt(input);
			List<String> passList = new ArrayList<String>(cases);

			for (int i = 0; i < cases; i++) {
				input = br.readLine();
				passList.add(input);
				palindrome = pass.reverse(input);
				if (passList.contains(palindrome)) {
					System.out.println(input.length() + " "
							+ pass.getMiddleChar(input));
				}
			}
		} catch (Exception e) {
			// System.out.println(0);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * Reverse the string
	 * 
	 * @param word
	 * @return
	 */
	private String reverse(String word) {
		if (word == null) {
			return word;
		}

		int length = word.length();
		String reverse = "";
		for (int i = length - 1; i >= 0; i--)
			reverse = reverse + word.charAt(i);
		return reverse;
	}

	/**
	 * Get middle characters in the word
	 * 
	 * @param word
	 * @return
	 */
	private String getMiddleChar(String word) {
		char middleOne;
		char[] arr = word.toCharArray();
		middleOne = arr[word.length() / 2];
		return String.valueOf(middleOne);
	}
}