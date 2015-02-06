package org.hearth.feb15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 
 * @author Jeevan
 * 
 *         Problem Statement -
 * 
 * 
 *         You are asked to calculate factorials of some small positive
 *         integers.
 *
 *         Input An integer T, denoting the number of testcases, followed by T
 *         lines, each containing a single integer N.
 *
 *         Output For each integer N given at input, output a single line the
 *         value of N!
 *
 *         Input Constraint
 *
 *         1 <= T <= 100 1 <= N <= 100
 *
 *         Sample Input 4 1 2 5 3 
 *         Sample Output 1 2 120 6
 */
public class SmallFactorial {

	public static void main(String a[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int noOfCases = Integer.valueOf(br.readLine());

			if (!(noOfCases > 100)) {
				for (int i = 0; i < noOfCases; i++) {
					int num = Integer.valueOf(br.readLine());
					System.out.println(factorial(num));
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

	private static BigInteger factorial(int num) {
		BigInteger fact = new BigInteger("1");
		for (int c = 1; c <= num; c++) {
			fact = fact.multiply(new BigInteger(String.valueOf(c)));
		}
		return fact;
	}
}
