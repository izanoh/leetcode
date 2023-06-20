package com.sathaporn.problem4;

import java.util.Arrays;

public class SolutionProblem4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int lenghtNum1 = nums1.length;
		int lenghtNum2 = nums2.length;
		
		int[] all = new int[lenghtNum1+lenghtNum2];
		
		int position = 0;
		int indexNum1 = 0, indexNum2 = 0;
		
		while (indexNum1 < lenghtNum1 && indexNum2 < lenghtNum2) {

			if (nums1[indexNum1] <= nums2[indexNum2]) {
				all[position] = nums1[indexNum1];
				indexNum1++;
			} else {
				all[position] = nums2[indexNum2];
				indexNum2++;
				
			}
			System.out.println("indexNum1 : " + indexNum1 + " indexNum2 : " + indexNum2 + " arr : "+Arrays.toString(all));
			position++;
		}
		
		while (indexNum1 < lenghtNum1) {
			all[position] = nums1[indexNum1];
			indexNum1++;
            position++;
        }

        while (indexNum2 < lenghtNum2) {
        	all[position] = nums2[indexNum2];
        	indexNum2++;
            position++;
        }
		System.out.println(Arrays.toString(all));
		
		if (all.length % 2 ==0) {
			int medianPosition = ((all.length / 2))-1;

			return (all[medianPosition] + all[medianPosition+1]) / 2.0;
		} else {
			int medianPosition = ((all.length / 2));
			return all[medianPosition]/1.0;
		}
	}
}
