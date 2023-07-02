package com.sathaporn.problem6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SolutionProblem6 {
	public String convert(String s, int numRows) {
		Map<Integer, List<String>> mapOutput = new HashMap<>();
		
		for (int i = 1; i <= numRows; i++) {
			mapOutput.put(i, new ArrayList<>());
		}
		
		int position = 1;
		int indexOfChar = 0;
		boolean isReverse = false;
		while (indexOfChar < s.length()) {
			if (numRows==1) {
				mapOutput.get(1).add(s.charAt(indexOfChar)+"");
			} else {
				mapOutput.get(position).add(s.charAt(indexOfChar)+"");
				if (position==numRows) {
					isReverse = true;
				}
				if (position==1) {
					isReverse = false;
				}
				
				if(isReverse) {
					position--;
				} else {
					position++;
				}
			}
			indexOfChar++;
			
		}
		
		String output = "";
		for (int i = 1; i <= numRows; i++) {
			output += mapOutput.get(i).stream().collect(Collectors.joining());
		}
		
		return output;
	}
}
