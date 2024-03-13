//check if n is a anypower of 2 or not    
// eg. n=16   so 2^4 is 16 so true 

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}