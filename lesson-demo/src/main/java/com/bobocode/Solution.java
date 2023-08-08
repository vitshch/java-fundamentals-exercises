package com.bobocode;

import java.util.Arrays;

public class Solution {

    public static int removeDuplicates(int[] nums) {
        int insertIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            } else {
                nums[i] = 0;
            }
        }
        return insertIndex;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 3};
        int count = removeDuplicates(arr);
        System.out.println(count);
        System.out.println(Arrays.toString(arr));
    }
}
