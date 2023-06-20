package com.sathaporn.problem4;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestSolutionProblem4 {
	@ParameterizedTest
	@MethodSource("com.sathaporn.problem4.TestSolutionProblem4#dataTest")
	public void doTestParameter(int[] nums1, int[] nums2, double expectOutput) {
		SolutionProblem4 solutionProblem4 = new SolutionProblem4();
		Runtime runtime = Runtime.getRuntime();
		long startTime = System.currentTimeMillis();
		runtime.gc();
		double median = solutionProblem4.findMedianSortedArrays(nums1, nums2);
		long usedMemory = runtime.totalMemory() - runtime.freeMemory();
		long endTime = System.currentTimeMillis();
		long runtimeAsLong = endTime - startTime;
		System.out.println("Runtime: " + runtimeAsLong + " milliseconds , Memory used: " + usedMemory + " bytes");
		Assertions.assertEquals(expectOutput, median, "output should be "+expectOutput);
	}
	
	static Stream<Arguments> dataTest() {
	    return Stream.of(
	  	      Arguments.of( new int[]{1,3}, new int[]{2}, 2.00000),
		      Arguments.of( new int[]{1,2}, new int[]{3,4}, 2.50000)
	    );
	}
}
