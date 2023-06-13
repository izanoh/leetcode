package com.sathaporn.problem2;


public class SolutionProblem2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode outputNode = new ListNode();

		ListNode currentOutputNode = outputNode;

		ListNode currentInL1 = l1;
		ListNode currentInL2 = l2;
		
		int carryPlus = 0;
		
		int sumCurrent = currentInL1.val + currentInL2.val + carryPlus;
		if (sumCurrent / 10 > 0) {
			carryPlus = 1;
		}
		currentOutputNode.val = sumCurrent%10;
		
		while (hasMoreElements(currentInL1) || hasMoreElements(currentInL2) || carryPlus == 1) {
			int currentL1 = 0;
			if (hasMoreElements(currentInL1)) {
				currentInL1 = currentInL1.next;
				currentL1 = currentInL1.val;
			}
			int currentL2 = 0;
			if (hasMoreElements(currentInL2)) {
				currentInL2 = currentInL2.next;
				currentL2 = currentInL2.val;
			}
			sumCurrent = currentL1 + currentL2 + carryPlus;
			
			if (sumCurrent / 10 > 0) {
				carryPlus = 1;
			} else {
				carryPlus = 0;
			}

			currentOutputNode.next = new ListNode(sumCurrent%10);
			currentOutputNode = currentOutputNode.next;
		}

		return outputNode;
	}

	public boolean hasMoreElements(ListNode node) {
		return null != node.next;
	}
	
	public String convertNodeToString(ListNode listNode) {
		String strNode1 = "";
		if (null == listNode) {
			return "";
		} else {
			strNode1 = listNode.val + "";
		}
		while (hasMoreElements(listNode)) {
			listNode = listNode.next;
			strNode1 = strNode1 + (String.valueOf(listNode.val));
		}
		return strNode1;
	}
}
