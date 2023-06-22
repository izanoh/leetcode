package com.sathaporn.problem4;

public class SolutionProblem4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int lenghtNum1 = nums1.length;
		int lenghtNum2 = nums2.length;
		
		int previous = 0;
		int current = 0;
		
		int position = 0;
		int indexNum1 = 0, indexNum2 = 0;

		boolean isOddLength = ((lenghtNum1+lenghtNum2) % 2)==1;
		int medianPosition = (((lenghtNum1+lenghtNum2) / 2));
		
		while (indexNum1 < lenghtNum1 && indexNum2 < lenghtNum2) {

			if (nums1[indexNum1] <= nums2[indexNum2]) {
				current = nums1[indexNum1];
				indexNum1++;
			} else {
				current = nums2[indexNum2];
				indexNum2++;
			}
			
			if (position == medianPosition ) {
				if (isOddLength) {
					return current/1.0;
				} else {
					return (current+ previous )/2.0;
				}
			}
			previous = current;
			position++;
		}
		
		while (indexNum1 < lenghtNum1) {
			current = nums1[indexNum1];
			if (position == medianPosition ) {
				if (isOddLength) {
					return current/1.0;
				} else {
					return (current+ previous )/2.0;
				}
			}
			previous = current;
			indexNum1++;
            position++;
        }

        while (indexNum2 < lenghtNum2) {
        	current = nums2[indexNum2];
        	if (position == medianPosition ) {
				if (isOddLength) {
					return current/1.0;
				} else {
					return (current+ previous )/2.0;
				}
			}
			previous = current;
        	indexNum2++;
            position++;
        }
		return current/1.0;
	}
}
