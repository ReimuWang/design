package com.test;

public class Solution {

    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int lastIndex = 0;
        int lastValue = nums[lastIndex];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == lastValue) continue;
            nums[++lastIndex] = nums[i];
            lastValue = nums[lastIndex];
        }
        return lastIndex + 1;
    }
}