package com.sathaporn.problem6;

import java.util.HashMap;
import java.util.Map;

public class SolutionProblem6 {
	public String convert(String s, int numRows) {
		Map<Integer, StringBuilder> mapOutput = new HashMap<>();
		
		if(numRows==1 || s.length()==1){
            return s;
        }
		
		int position = 1;
		int indexOfChar = 0;
		boolean isReverse = false;
		while (indexOfChar < s.length()) {
			
			if (!mapOutput.containsKey(position)) {
				mapOutput.put(position, new StringBuilder(""));
			}
			
			mapOutput.get(position).append(s.charAt(indexOfChar));
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
			indexOfChar++;
			
		}
		
		String output = "";
		for (int i = 1; i <= numRows; i++) {
			if (null != mapOutput.get(i)) {
				output += mapOutput.get(i);
			}
		}
		
		return output;
	}
}
