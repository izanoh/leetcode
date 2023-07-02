package com.sathaporn.problem6;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestSolutionProblem6 {
	@ParameterizedTest
	@MethodSource("com.sathaporn.problem6.TestSolutionProblem6#dataTest")
	public void doTestParameter(String s, int nunRows, String expectOutput) {
		SolutionProblem6 solutionProblem = new SolutionProblem6();
		Runtime runtime = Runtime.getRuntime();
		long startTime = System.currentTimeMillis();
		runtime.gc();
		String result = solutionProblem.convert(s, nunRows);
		long usedMemory = runtime.totalMemory() - runtime.freeMemory();
		long endTime = System.currentTimeMillis();
		long runtimeAsLong = endTime - startTime;
		System.out.println("Runtime: " + runtimeAsLong + " milliseconds , Memory used: " + usedMemory + " bytes");
		Assertions.assertEquals(expectOutput, result, "output should be "+expectOutput);
	}
	
	static Stream<Arguments> dataTest() {
	    return Stream.of(
	  	      Arguments.of( "PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
	  	      Arguments.of( "PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
	  	      Arguments.of( "A", 1, "A")
	    );
	}
}
