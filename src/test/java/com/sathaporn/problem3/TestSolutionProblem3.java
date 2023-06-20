package com.sathaporn.problem3;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestSolutionProblem3 {
	@ParameterizedTest
	@MethodSource("com.sathaporn.problem3.TestSolutionProblem3#dataTest")
	public void doTestParameter(String s, int expectOutputStr) {
		SolutionProblem3 solutionProblem3 = new SolutionProblem3();
		Runtime runtime = Runtime.getRuntime();
		long startTime = System.currentTimeMillis();
		runtime.gc();
		int length = solutionProblem3.lengthOfLongestSubstring(s);
		long usedMemory = runtime.totalMemory() - runtime.freeMemory();
		long endTime = System.currentTimeMillis();
		long runtimeAsLong = endTime - startTime;
		System.out.println("Runtime: " + runtimeAsLong + " milliseconds , Memory used: " + usedMemory + " bytes");
		Assertions.assertEquals(expectOutputStr, length, "output should be "+expectOutputStr);
	}
	
	static Stream<Arguments> dataTest() {
	    return Stream.of(
	  	      Arguments.of( "abcabcbb", 3),
		      Arguments.of( "bbbbb", 1),
		      Arguments.of( "pwwkew", 3)
	    );
	}
}
