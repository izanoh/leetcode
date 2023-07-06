package com.sathaporn.problem7;

public class SolutionProblem7 {
	public int reverse(int x) {
		int reverse = 0;
		
		boolean lessZero = x < 0;
		if (lessZero) {
			x=-x;
		}
		
		while (x>0) {
			int digit = x%10;
			if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && digit > 7)) {
	            return 0;
			}
	        if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && digit < -8)) {
	            return 0;
	        }
			reverse = (reverse * 10 ) + digit;
			x = x/10;
		}
		if (lessZero) {
			return -reverse;
		} else {
			return reverse;
		}
	}
}
