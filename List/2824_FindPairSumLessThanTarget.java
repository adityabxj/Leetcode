package List;

import java.util.List;

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        int count = 0;

        // Sort the array
        nums.sort(null);

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum < target) {
                // If the sum is less than the target, all pairs with the current right pointer
                // will satisfy the condition
                count += right - left;
                left++;
            } else {
                // If the sum is greater than or equal to the target, move the right pointer to
                // the left
                right--;
            }
        }

        return count;
    }
}
