/*RANK CALCULATOR
Given the marks of a list of students write a program to calculate the ranks obtained by the
students with the following criteria
1. If two students got same marks they will get same rank
2. The student placed next to the same marks students will get the rank skipping the
intermediate ranks. Refer to the example below
MARKS
Iron Man - 10, Spider Man - 10, Captain Marvel - 15, Thor - 13, Hulk - 10, Hawkeye - 8
RANKS
Captain Marvel - 1, Thor - 2, Iron Man - 3, Spider Man - 3, Hulk - 3, Hawkeye - 6
INPUT
function calculate_ranks([{“Iron Man” : 10, “Spider Man”: 10, “Captain Marvel”: 15, “Thor”: 13,
“Hulk”: 10, “Hawkeye”: 8}])
{
//YOUR CODE
}
OUTPUT
[{“Iron Man” : 3, “Spider Man”: 3, “Captain Marvel”: 1, “Thor”: 2, “Hulk”: 3, “Hawkeye”: 6}]*/

package com.masaitask;

import java.util.*;

public class RankCalculator {

	public static void main(String[] args) {

		Map<String, Integer> marks = new HashMap<String, Integer>();

		marks.put("Iron Man", 10);
		marks.put("Spider Man", 10);
		marks.put("Captain Marvel", 15);
		marks.put("Thor", 13);
		marks.put("Hulk", 10);
		marks.put("Hawkeye", 8);

		Map<String, Integer> ans = sortByValue(marks);
		System.out.println(ans.toString());

	}

	public static Map<String, Integer> sortByValue(Map<String, Integer> hm) {
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		int rank = 1;
		int current_marks = -1;
		int i = 1;

		for (Map.Entry<String, Integer> aa : list) {

			if (aa.getValue() == current_marks) {
				temp.put(aa.getKey(), i - 1);
				rank++;

			} else {
				temp.put(aa.getKey(), rank++);
				current_marks = aa.getValue();
				i++;

			}

		}
		return temp;
	}

}
