package ArrayList;

import java.util.*;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) {
                positives.add(num);
            } else {
                negatives.add(num);
            }
        }

        // Interleave positive and negative integers while maintaining order
        int[] result = new int[nums.length];
        int index = 0;
        // First, put positive integers at odd indexes
        for (int i = 0; i < positives.size(); i++) {
            result[index] = positives.get(i);
            index += 2;
        }

        index = 1; // Reset index to put negative integers at even indexes
        // Next, put negative integers at even indexes
        for (int i = 0; i < negatives.size(); i++) {
            result[index] = negatives.get(i);
            index += 2;
        }

        return result;
    }
}
