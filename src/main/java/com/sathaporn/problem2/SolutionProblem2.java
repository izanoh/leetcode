package com.sathaporn.problem2;


public class SolutionProblem2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode outputNode = new ListNode();

		ListNode currentOutputNode = outputNode;

		ListNode currentInL1 = l1;
		ListNode currentInL2 = l2;
		
		int carryPlus = 0;
		int sumCurrent = 0;
		
		while (null != currentInL1 || null != currentInL2 || carryPlus == 1) {
			sumCurrent = 0;
			if (null != currentInL1) {
				sumCurrent += currentInL1.val;
				currentInL1 = currentInL1.next;
			}
			
			if (null != currentInL2) {
				sumCurrent += currentInL2.val;
				currentInL2 = currentInL2.next;
			}
			
			sumCurrent += carryPlus;
			
			carryPlus = sumCurrent / 10;
			currentOutputNode.val = sumCurrent%10;
			
			if ((null != currentInL1 || null != currentInL2 || carryPlus == 1)) {
				currentOutputNode.next = new ListNode();
				currentOutputNode = currentOutputNode.next;
			}
			
		}

		return outputNode;
	}
	
	public String convertNodeToString(ListNode listNode) {
		String strNode = "";
		while (null != listNode) {
			strNode = strNode + listNode.val;
			listNode = listNode.next;
		}
		return strNode;
	}
}
