package org.hearth.july14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author jeevanp
 * 
 *         http://www.hackerearth.com/problem/algorithm/a-needle-in-the-haystack
 *         -1/
 * 
 *         Our hacker, Little Stuart lately has been fascinated by ancient
 *         puzzles. One day going through some really old books he finds
 *         something scribbled on the corner of a page. Now Little Stuart
 *         believes that the scribbled text is more mysterious than it
 *         originally looks, so he decides to find every occurrence of all the
 *         permutations of the scribbled text in the entire book. Since this is
 *         a huge task, Little Stuart needs your help, he needs you to only
 *         figure out if any permutation of the scribbled text exists in the
 *         given text string, so he can save time and analyze only those text
 *         strings where a valid permutation is present. Input: First line
 *         contains number of test cases T.Each test case contains two lines
 *         ,first line contains pattern and next line contains a text string.
 *         All characters in both the strings are in lowercase only [a-z].
 * 
 *         Output: For each test case print "YES" or "NO" (quotes for clarity)
 *         depending on whether any permutation of the pattern exists in the
 *         text string.
 * 
 *         Constraints: 1 ≤ T ≤ 100 
 *         				1 ≤ |Pattern| ≤ 1000 
 *         				1 ≤ |Text String| ≤ 100000
 *
 */
public class NeedleInHaystack {
	public static void main(String a[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfInputs = Integer.valueOf(br.readLine());
		
		for(int i = 0; i < noOfInputs; i++) {
			String needle = br.readLine();
			String haystack = br.readLine();
			System.out.println(checkSubstring(needle, haystack));
		}
	}

	private static String checkSubstring(String needle, String haystack) {
		if(haystack.contains(needle) || haystack.contains(new StringBuilder(needle).reverse().toString())) {
			return "YES";
		}
		return "NO";
	}
}
