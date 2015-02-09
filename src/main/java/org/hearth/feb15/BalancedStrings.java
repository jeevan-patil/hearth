package org.hearth.feb15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author jeevan
 *
 */
public class BalancedStrings {

	public static void main(String[] a) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			BalancedStrings bs = new BalancedStrings();
			int noOfCases = Integer.valueOf(br.readLine());
			if (!(noOfCases > 10)) {
				for (int i = 0; i < noOfCases; i++) {
					String input = br.readLine();
					if (input.matches("[a-z]+") && (1 <= noOfCases && noOfCases <= 100000)) {
						System.out.println(bs.searchUniqueSubstrings(input));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
			}
		}
	}

	private int searchUniqueSubstrings(String _str) {
		Map<String, BigInteger> countHolder = new HashMap<String, BigInteger>();
		generateSubstrings(countHolder, _str);

		int balancedStrings = 0;
		for (String key : countHolder.keySet()) {
			if (isBalancedString(key)) {
				++balancedStrings;
			}
		}
		return balancedStrings;
	}

	private static void generateSubstrings(Map<String, BigInteger> map, String _str) {
		try {
			Long strLen = Long.valueOf(_str.length());
			for (Long count = 0l; count < strLen; count++) {
				String temp = String.valueOf(_str.charAt(Integer.valueOf(String.valueOf(count))));
				manageMap(map, temp);

				StringBuilder sb = new StringBuilder(temp);
				for (Long itrCnt = (count + 1); itrCnt < strLen; itrCnt++) {
					sb.append(String.valueOf(_str.charAt(Integer.valueOf(String.valueOf(itrCnt)))));
					manageMap(map, sb.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean isBalancedString(String str) {
		Map<String, BigInteger> map = new HashMap<String, BigInteger>();
		if(!isNullOrEmpty(str)) {
			for(Character c : str.toCharArray()) {
				if(!isNullOrEmpty(str)) {
					int charCount = str.length() - str.replaceAll(String.valueOf(c), "").length();
					map.put(String.valueOf(c), new BigInteger("" + charCount));
				}
			}
		}

		boolean response = true;
		for(String key : map.keySet()) {
			if(!map.get(key).mod(new BigInteger(""+2)).equals(new BigInteger(""+0))) {
				response = false;
				break;
			}
		}
		return response;
	}

	private static void manageMap(Map<String, BigInteger> map, String _str) {
		if (!map.containsKey(_str)) {
			map.put(_str, new BigInteger("1"));
		} else {
			map.put(_str, (new BigInteger("1").add(map.get(_str))));
		}
	}

	private static boolean isNullOrEmpty(String _str) {
		if(null == _str || _str.trim().length() == 0) {
			return true;
		}
		return false;
	}
}
