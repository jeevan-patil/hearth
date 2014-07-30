package org.hearth.july14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author jeevanp
 *
 * 
	In the race for the best Internet browser, there's now a new contender for it, this browser is called the: "The Semantic Mind-Reader!" After its promo on the world wide web, everyone's been desperately waiting for the browser to be released. And why shouldn't they be curious about it, after all, it's the new project of our very own genius "Little Jhool!" He's worked very hard for this browser, and to add new mind reading features to it.
	
	Apart from the various security powers it possesses, it's called the mind-reader for a reason. Here's why:
	
	You don't need to type 'www.' to open a website anymore.
	Though, you still need to type '.com' to open a website.
	The browser predicts ALL THE VOWELS in the name of the website. (Not '.com', though. Again!)
	Obviously, this means you can type the name of a website faster and save some time.
	Now to convince users that his browser will indeed save A LOT of time for users to open a particular website, Little Jhool has asked you to prepare a report on the same.
	
	Input format:
	The first line contains tc, the number of test cases.
	The second line contains the name of websites, as a string.
	
	Output format:
	You have to print the ratio of characters you would have typed in Jhool's browser, to your normal browser.
	
	Constraints:
	1 <= tc <= 100
	1 <= Length of the website <= 200
	
	NOTE: You do NOT need to print the output in its lowest format. You should print in its original fraction format.
	The names of all the websites will be in small case only.
	
	Every string will start from www. and end with .com, so well!
 */
public class BestBrowser {
	public static void main(String a[]) throws Exception {
		acceptInput();
	}

	private static void acceptInput() throws NumberFormatException, IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.valueOf(br.readLine());
		String[] sites = new String[cases];
		for(int i = 0; i < cases; i++) {
			sites[i] = br.readLine();
		}

		for(String site : sites) {
			System.out.println(prepareReport(site));
		}
	}

	private static String prepareReport(String site) {
		int vowelCount = 0;
		int indexOfWWW = site.lastIndexOf("www.");
		String strippedSiteName = site.substring((indexOfWWW + ("www.").length()), site.length());
		strippedSiteName = strippedSiteName.substring(0, strippedSiteName.lastIndexOf(".com"));

		for(char siteChar : strippedSiteName.toCharArray()) {
			if("aeiou".contains(String.valueOf(siteChar))) {
				++vowelCount;
			}
		}

		return (strippedSiteName.length() - vowelCount + (".com").length()) + "/" + site.length();
	}
}
