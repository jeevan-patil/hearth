package org.hearth.july14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @author jeevanp
 *
	Ashima is moody, and like most girlfriend suffers from serious mood swings. Currently, looking at Pankaj's interest in numbers, she got interested in them too. To protect himself from serious emotional blackmail, he has given Ashima some numbers to play with. Ashima being a loving girlfriend that she is, is not satisfied with playing with the numbers alone and wants Pankaj to play with her too. 
	She has written down the numbers in a line and is asking Pankaj to tell her the median from some starting position to another. Pankaj has answered some such queries of her, but being playful that she is, she wants to play more. Pankaj needs your help in answering her queries. 
	
	Definition: The median of a sequence of numbers is the middle element of that sequence when the sequence is sorted. For even number of elements in the sequence, the first of the middle two elements is called the median.
	
	Input 
	The first line of the input contains N, the number of integers Pankaj gave Ashima to play with. Next N lines contains one integer each, one of the numbers of the number given by Pankaj.
	Next line contains an integer Q, the number of queries asked by Ashima. Next Q lines contain a pair of space separated integers (i, j), implying that Ashima is interested in the median of numbers in the sequence from ith position to the jth position (both included, 1-based indexing, i ≤ j). 
	
	Output:
	Q lines, each containing the median for that particular query. 
	
	Constraints
	1 ≤ N ≤ 1414
	1 ≤ Q ≤ N2
	Each of the numbers in the sequence given by Pankaj to Ashima will be positive and fit into an integer.
	
	Note: Large I/O. Be careful with certain languages.
 */
public class GirlfriendsRequest {
	public static void main(String a[]) throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numbers = Integer.valueOf(br.readLine());
		int[] inputs = new int[numbers + 1];
		inputs[0] = 0;

		for(int i = 1; i <= numbers; i++) {
			inputs[i] = Integer.valueOf(br.readLine());
		}

		int noOfQuestions = Integer.valueOf(br.readLine());
		String[] allQuestions = new String[noOfQuestions];
		for(int j = 0; j < noOfQuestions; j++) {
			allQuestions[j] = br.readLine();
		}

		Arrays.sort(inputs);

		for(String question : allQuestions) {
			System.out.println(findMedian(inputs, question));
		}

		br.close();
	}

	private static int findMedian(int[] inputs, String pair) throws Exception {
		String[] points = pair.split(" ");
		int start = Integer.valueOf(points[0].trim());
		int end = Integer.valueOf(points[1].trim());

		if(start == end) {
			return inputs[start];
		}

		int[] subArray = Arrays.copyOfRange(inputs, start, end + 1);
		if((end - start) % 2 == 0) {
			return subArray[subArray.length / 2];
		} else {
			return subArray[subArray.length / 2 - 1];
		}
	}
}
