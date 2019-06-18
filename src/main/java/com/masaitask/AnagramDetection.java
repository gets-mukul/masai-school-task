/*
 * 
 * ANAGRAM DETECTION
Two words are anagrams of each other, if elements of one can be permuted to get the other.
For example ’MASAI SCHOOL’, ‘ASHLA COSIMO’ AND ’CHAOS SALOMI’ are anagrams of each
other. Can you come up with an function to test, if two given arrays are anagrams in the most
efficient manner.
INPUT
function anagram_check(word1, word2)
{
// YOUR CODE
}
OUTPUT
TRUE - If word1 and word2 are anagrams
FALSE - If word1 and word2 are not anagrams
 * */

package com.masaitask;

import java.util.HashMap;

public class AnagramDetection {

	public static void main(String[] args) {
		String word1 = "MASAI SCHOOL";
		String word2 = "ASHLA COSIMO";

		Boolean ans = anagram_check(word1, word2);

		System.out.println(ans);

	}

	private static Boolean anagram_check(String word1, String word2) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < word1.length(); i++) {
			char c = word1.charAt(i);
			if (map.containsKey(c)) {
				int val = map.get(c);
				map.put(c, val + 1);
			} else {
				map.put(c, 1);
			}
		}

		for (int i = 0; i < word2.length(); i++) {
			char c = word2.charAt(i);
			if (map.containsKey(c)) {
				int val = map.get(c);
				map.put(c, val - 1);
			} else {
				map.put(c, 1);
			}
		}

		for (int x : map.values()) {
			if (x != 0) {
				return false;
			}
		}
		return true;
	}

}
