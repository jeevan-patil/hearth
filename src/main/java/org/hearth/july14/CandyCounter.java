package org.hearth.july14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author jeevanp
 * 
 *         http://www.hackerearth.com/problem/algorithm/candy-counter/
 * 
 *         Himanshu is going on a trip to meet his two nieces Vidhi and Paridhi
 *         for the first time! But due to the tight schedule and contests in
 *         between, he meets them for only first N days of his trip! His nieces
 *         were eagerly waiting for him from the first day, since they knew that
 *         he would bring candies for them.
 * 
 *         Himanshu follows a way in giving the candies. The first day he meets,
 *         he gives one candy to each. On the next day, he gives one more candy
 *         to each than the amount of candies given to each last day. So its two
 *         to each for the second day and so on. Given the value of N, can you
 *         tell me the amount of candies received by the two sisters?
 * 
 *         Input
 * 
 *         The first line contains the number of test case T. Each of the next T
 *         lines contains a number N, the number of days Himanshu spends with
 *         his nieces.
 * 
 *         Output
 * 
 *         Output the number of chocolates received by the two sisters.
 * 
 *         Constraints
 * 
 *         1<=T<=100
 * 
 *         1<=N<=10^8
 * 
 *         Sample Input 
 *		 	2
 *			1
 *			2
 *			Sample Output 
 *			2
 *			6
 * 
 * 			Explanation
 * 			For day 1 : Himanshu needs to give 1 chocolates to each. So it is 2 in total.
 *         	For day 2 : Himanshu needs to give 2 chocolates on day 1 followed by
 *         	2 each on the next day. So total is 6.
 *
 */
public class CandyCounter {
	public static void main(String[] args) {
		final int noOfPersons = 2;
		CandyCounter counter = new CandyCounter();
		for(Integer days : counter.acceptCases()) {
			long candyCount = 0;
			for(int i = 1; i <= days; i++) {
				candyCount += noOfPersons * i;
			}
			System.out.println(candyCount);
		}
	}

	private List<Integer> acceptCases() {
		List<Integer> cases = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);

		try {
			int noOfCases = scanner.nextInt();
			for(int i = 0; i < noOfCases; i++) {
				cases.add(scanner.nextInt());
			}
		} catch (NumberFormatException e) {
		} finally {
			scanner.close();
		}

		return cases;
	}

}