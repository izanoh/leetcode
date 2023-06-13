package com.sathaporn.problem2;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestSolutionProblem2 {
	
	@ParameterizedTest
	@MethodSource("com.sathaporn.problem2.TestSolutionProblem2#dataTest")
	public void doTestParameter(ListNode l1, ListNode l2, String expectOutputStr) {
		SolutionProblem2 solutionProblem2 = new SolutionProblem2();
		Runtime runtime = Runtime.getRuntime();
		long startTime = System.currentTimeMillis();
		runtime.gc();
		ListNode listNode = solutionProblem2.addTwoNumbers(l1, l2);
		long usedMemory = runtime.totalMemory() - runtime.freeMemory();
		long endTime = System.currentTimeMillis();
		long runtimeAsLong = endTime - startTime;
		System.out.println("Runtime: " + runtimeAsLong + " milliseconds , Memory used: " + usedMemory + " bytes");
		String outputStr = solutionProblem2.convertNodeToString(listNode);
		Assertions.assertEquals(expectOutputStr, outputStr, "output should be "+expectOutputStr);
	}
	
	static Stream<Arguments> dataTest() {
	    return Stream.of(
	      Arguments.of( new ListNode(2, new ListNode(4, new ListNode(3)))
	    		  , new ListNode(5, new ListNode(6, new ListNode(4)))
	    		  , "708"),
	      Arguments.of( new ListNode(0)
	    		  , new ListNode(0)
	    		  , "0"),
	      Arguments.of( new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))))
	    		  , new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))
	    		  , "89990001")
	    );
	}
}
