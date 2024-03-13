package Arrays;

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}

// a[] = [1,2,1,4,2]
// logic
// performing X-OR operations
// res=0

// 0 ^ 1 = 1
// 1 ^ 2 = 3
// 3 ^ 1 = 2
// 2 ^ 4 = 6
// 6 ^ 2 = 4

// 4 is the uinque element