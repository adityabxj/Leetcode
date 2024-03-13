// Missing num in a array from 1 to 9 if there is 0 in the array then we have to find the missing digit

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int exsum = n * (n + 1) / 2;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return exsum - sum;
    }
}