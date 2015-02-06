package org.hearth.feb15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Jeevan
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
					if(input.matches("[a-zA-Z]+")) {
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
		Map<String, Integer> countHolder = new HashMap<String, Integer>();
		prepareComboMap(countHolder, _str);

		int uniqueSubStrings = 0;
		for(String key : countHolder.keySet()) {
			if(countHolder.get(key) == 1) {
				++uniqueSubStrings;
			}
		}
		return uniqueSubStrings;
	}

	private static void prepareComboMap(Map<String, Integer> map, String _str) {
		try {
			int strLen = _str.length();
			for(int count = 0; count < strLen; count++) {
				manageMap(map, String.valueOf(_str.charAt(count)));

				StringBuilder sb = new StringBuilder(String.valueOf(_str.charAt(count)));
				for(int itrCnt = (count + 1); itrCnt < strLen; itrCnt++) {
					sb.append(String.valueOf(_str.charAt(itrCnt)));
					manageMap(map, sb.toString());
				}
			}
		} catch(Exception e) {
			
		}
	}

	private static void manageMap(Map<String, Integer> map, String _str) {
		if(!map.containsKey(_str)) {
			map.put(_str, 1);
		} else {
			map.put(_str, (map.get(_str) + 1));
		}
	}
}
