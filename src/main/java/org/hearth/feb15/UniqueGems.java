package org.hearth.feb15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Jeevan
 * @Problem
 * 
 *          Rahul has entered into a mysterious land of gems. There is a record
 *          S for each of the gems that is maintained in form of a string. Each
 *          gem is characterized by some substring of this string.
 *          Interestingly, the number of occurrences of a sub-string in S is the
 *          exact number of such gems present in the land.
 * 
 *          However, Rahul is only interested in unique gems. Please tell the
 *          number of such sub-strings that occur exactly once.
 * 
 *          Input Format:
 * 
 *          The first line of input file contains an integer T, denoting the
 *          number of test cases. Each of the following T lines contain a
 *          string.
 * 
 *          Output Format:
 * 
 *          The output file should contain exactly T numbers, each representing
 *          output to corresponding test case.
 * 
 *          Constraints:
 * 
 *          1 ≤ T ≤ 10 1 ≤ |S| ≤ 105 Each of the characters in string S lie
 *          between a-z.
 * 
 *          Sample Explanation:
 * 
 *          Case #1: aaa is the only substring that occurs once.
 * 
 *          Case #2: b, ab, ba, aba are the unique substrings.
 * 
 *          Case #3: aba, bab, ba, and abab are unique substrings.
 * 
 *          Sample Input 3 aaa aba abab 
 *          Sample Output 1 4 4
 * 
 *
 */
public class UniqueGems {
	public static void main(String a[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int noOfCases = Integer.valueOf(br.readLine());
			if (!(noOfCases > 10)) {
				for (int i = 0; i < noOfCases; i++) {
					String input = br.readLine();
					if (input.matches("[a-z]+")) {
						System.out.println(searchUniqueSubstrings(input));
					}
				}
			}
		} catch (Exception e) {
		} finally {
			try {
				br.close();
			} catch (IOException e) {
			}
		}
	}

	private static int searchUniqueSubstrings(String _str) {
		Map<String, BigInteger> countHolder = new HashMap<String, BigInteger>();
		prepareComboMap(countHolder, _str);

		int uniqueSubStrings = 0;
		for (String key : countHolder.keySet()) {
			if (countHolder.get(key).equals(new BigInteger("1"))) {
				++uniqueSubStrings;
			}
		}
		return uniqueSubStrings;
	}

	private static void prepareComboMap(Map<String, BigInteger> map, String _str) {
		try {
			Long strLen = Long.valueOf(_str.length());
			for (Long count = 0l; count < strLen; count++) {
				String temp = String.valueOf(_str.charAt(Integer.valueOf(String.valueOf(count))));
				manageMap(map, temp);

				StringBuilder sb = new StringBuilder(temp);
				for (Long itrCnt = (count + 1); itrCnt < strLen; itrCnt++) {
					sb.append(String.valueOf(_str.charAt(Integer.valueOf(String.valueOf(itrCnt)))));
					manageMap(map, sb.toString().intern());
				}
			}
		} catch (Exception e) {

		}
	}

	private static void manageMap(Map<String, BigInteger> map, String _str) {
		if (!map.containsKey(_str)) {
			map.put(_str, new BigInteger("1"));
		} else {
			map.put(_str, (new BigInteger("1").add(map.get(_str))));
		}
	}
}
