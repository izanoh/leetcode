package com.sathaporn.problem7;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestSolutionProblem7 {
	@ParameterizedTest
	@MethodSource("com.sathaporn.problem7.TestSolutionProblem7#dataTest")
	public void doTestParameter(int x, int expectOutput) {
		SolutionProblem7 solutionProblem = new SolutionProblem7();
		Runtime runtime = Runtime.getRuntime();
		long startTime = System.currentTimeMillis();
		runtime.gc();
		int result = solutionProblem.reverse(x);
		long usedMemory = runtime.totalMemory() - runtime.freeMemory();
		long endTime = System.currentTimeMillis();
		long runtimeAsLong = endTime - startTime;
		System.out.println("Runtime: " + runtimeAsLong + " milliseconds , Memory used: " + usedMemory + " bytes");
		Assertions.assertEquals(expectOutput, result, "output should be "+expectOutput);
	}
	
	static Stream<Arguments> dataTest() {
	    return Stream.of(
	  	      Arguments.of( 123, 321),
	  	      Arguments.of( -123, -321),
	  	      Arguments.of( 120, 21),
	  	      Arguments.of( 1534236469, 0)
	    );
	}
}
