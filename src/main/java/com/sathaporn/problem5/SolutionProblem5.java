package com.sathaporn.problem5;

public class SolutionProblem5 {
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 2)
            return s;

        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {
            // Case Check for odd length palindromes
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLength) {
                    start = left;
                    maxLength = right - left + 1;
                }
                left--;
                right++;
            }

            // Case Check for even length palindromes
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLength) {
                    start = left;
                    maxLength = right - left + 1;
                }
                left--;
                right++;
            }
        }

        return s.substring(start, start + maxLength);
    }
	
	
}
