package com.sathaporn.problem3;

import java.util.HashSet;

public class SolutionProblem3 {
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
        int maxLength = 0;
        int i = 0, j = 0;
        HashSet<Character> set = new HashSet<>();

        System.out.println(s);
        while (i < n && j < n) {
            System.out.print(" i " + i + " j " + j);
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                System.out.print(" add " + s.charAt(j));
                j++;
                maxLength = Math.max(maxLength, j - i);
            } else {
                set.remove(s.charAt(i));
                System.out.print(" del " + s.charAt(i));
                i++;
            }
            System.out.println(" after i " + i + " j " + j + " maxLength " + maxLength + " set " + set);
        }
        return maxLength;
	}
}
