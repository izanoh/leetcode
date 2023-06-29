package com.sathaporn.problem5;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestSolutionProblem5 {
	@ParameterizedTest
	@MethodSource("com.sathaporn.problem5.TestSolutionProblem5#dataTest")
	public void doTestParameter(String s, String expectOutput) {
		SolutionProblem5 solutionProblem = new SolutionProblem5();
		Runtime runtime = Runtime.getRuntime();
		long startTime = System.currentTimeMillis();
		runtime.gc();
		String result = solutionProblem.longestPalindrome(s);
		long usedMemory = runtime.totalMemory() - runtime.freeMemory();
		long endTime = System.currentTimeMillis();
		long runtimeAsLong = endTime - startTime;
		System.out.println("Runtime: " + runtimeAsLong + " milliseconds , Memory used: " + usedMemory + " bytes");
		Assertions.assertEquals(expectOutput, result, "output should be "+expectOutput);
	}
	
	static Stream<Arguments> dataTest() {
	    return Stream.of(
	  	      Arguments.of( "babad", "bab"),
	  	      Arguments.of( "cbbd", "bb")
	    );
	}
}
