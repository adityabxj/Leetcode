class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        // Find the common prefix of left and right in binary representation
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        // Shift left to the right to recover the original value
        return left << shift;
    }
}